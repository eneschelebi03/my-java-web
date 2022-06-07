package bg.softuni.mobilele.model.dto;

public class LoginUserDTO {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public LoginUserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "LoginUserDTO{" +
                "username='" + username + '\'' +
                ", password='" + (password != null ? "[PROVIDED]" : null) + '\'' +
                '}';
    }
}
