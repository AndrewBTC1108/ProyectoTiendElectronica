package org.catcdfgz.co.models;

public class User {
    private String name;
    private String password;
    private Role roleUser;

    public User(String name, String password, Role roleUser) {
        this.name = name;
        this.password = password;
        this.roleUser = roleUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(Role roleUser) {
        this.roleUser = roleUser;
    }

}
