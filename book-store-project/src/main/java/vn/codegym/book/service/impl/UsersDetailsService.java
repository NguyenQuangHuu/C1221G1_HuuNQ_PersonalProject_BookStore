package vn.codegym.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.book.model.Users;
import vn.codegym.book.repository.IUsersRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class UsersDetailsService implements UserDetailsService {
    @Autowired
    private IUsersRepository iUsersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = this.iUsersRepository.findUsersByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException("Không tìm thấy người dùng");
        }
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        users.getUserRoles().forEach(role -> grantedAuthorityList.add(new SimpleGrantedAuthority(role.getRoles().getName())));
//      Sử dụng email để xác nhận đăng kí mới dùng
//        if(users.getActive()){
//            return new User(users.getUsername(),users.getPassword(),true, true, true,true,grantedAuthorityList);
//        }
//        return new User(users.getUsername(),users.getPassword(),false,false,false,false,null);
        return new User(users.getUsername(), users.getPassword(), true, true, true, true, grantedAuthorityList);
    }
}
