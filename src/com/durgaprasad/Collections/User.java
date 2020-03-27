package com.durgaprasad.Collections;

public class User implements Comparable<User>{
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int compareTo(User user) {
        // 1 - This particular object is greater than the object we are comparing to.
        // 0 - This particular object is equal.
        // -1 - This particular object is less than the object we are comparing to.
        return this.username.compareTo(user.getUsername());
    }
}
