package take;

public class Staff {
    private int uid;
    private String username;
    private String password;
    private int role;//权限

    public int getRole() {
        return role;
    }

    public int getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
