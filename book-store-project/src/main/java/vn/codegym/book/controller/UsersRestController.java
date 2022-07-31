package vn.codegym.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import vn.codegym.book.dto.JwtResponse;
import vn.codegym.book.dto.LoginRequest;
import vn.codegym.book.utils.JwtUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UsersRestController {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/sign-in")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);
        User user = (User) authentication.getPrincipal();
        List<String> roles = user.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return new ResponseEntity<>(new JwtResponse(jwt,loginRequest.getUsername(),loginRequest.getPassword(),roles),HttpStatus.OK);
    }
}
