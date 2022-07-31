package vn.codegym.book.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties({"password"})
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private String password;
    private List<String> rolesList;

    public JwtResponse(String token, String username, String password, List<String> rolesList) {
        this.token = token;
        this.username = username;
        this.password = password;
        this.rolesList = rolesList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<String> rolesList) {
        this.rolesList = rolesList;
    }
}
