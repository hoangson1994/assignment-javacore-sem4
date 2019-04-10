package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private int role;
    private int status;
    private long created_at;
    private long updated_at;
    HashMap<String, ArrayList> errors;

    public User() {
    }

    public User(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = Role.USER.getValue();
        this.created_at = System.currentTimeMillis();
        this.updated_at = System.currentTimeMillis();
    }

    public User(int id, String username, String password, String fullname, int role, int status, long created_at, long updated_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public enum Role {
        USER (1),
        ADMIN(2);
        private int value;

        Role(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }
    }

    public boolean isValid() {
        validate();
        return this.errors.size() == 0;
    }

    public void validate() {
        if (errors == null) {
            errors = new HashMap<>();
        }
        ArrayList<String> username = new ArrayList<>();
        ArrayList<String> password = new ArrayList<>();
        ArrayList<String> fullname = new ArrayList<>();
        if (this.username == null || this.username.length() == 0) {
            username.add("Username is required");
        }
        if (this.username.length() < 2 || this.username.length() > 30) {
            username.add("Username length must be between 2 to 30");
        }

        if (this.password == null || this.password.length() == 0) {
            password.add("Password is required");
        }
        if (this.password.length() < 2 || this.password.length() > 30) {
            password.add("Password length must be between 2 to 30");
        }

        if (this.fullname == null || this.fullname.length() == 0) {
            fullname.add("FullName is required");
        }
        if (this.fullname.length() < 2 || this.fullname.length() > 30) {
            fullname.add("FullName length must be between 2 to 30");
        }

        if (username.size() > 0)
            this.errors.put("username", username);
        if (password.size() > 0)
            this.errors.put("password", password);
        if (fullname.size() > 0)
            this.errors.put("fullname", fullname);

    }

    public HashMap<String, ArrayList> getErrors(){
        return this.errors;
    }
}
