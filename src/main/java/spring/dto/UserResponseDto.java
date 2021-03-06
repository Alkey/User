package spring.dto;

public class UserResponseDto {
    private Long id;
    private String login;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "UserResponseDto{" + "id=" + id
                + ", login='" + login + '\'' + '}';
    }
}
