package api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Login {

    private String username;
    private String password;
    private String access_token;
    private String name;
    private String code;
    private String hasState;

    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login(String name, String code, String hasState) {
        this.name = name;
        this.code = code;
        this.hasState = hasState;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHasState() {
        return hasState;
    }

    public void setHasState(String hasState) {
        this.hasState = hasState;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String toString() {
        return "Ahmet{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", access_token='" + access_token + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", hasState='" + hasState + '\'' +
                '}';
    }
}
