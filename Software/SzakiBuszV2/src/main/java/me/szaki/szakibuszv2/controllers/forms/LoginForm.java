package me.szaki.szakibuszv2.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is used to store the data sent by the user in the login form.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    String username;
    String password;

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
}
