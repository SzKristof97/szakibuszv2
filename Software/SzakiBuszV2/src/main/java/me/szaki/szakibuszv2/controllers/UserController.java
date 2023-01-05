package me.szaki.szakibuszv2.controllers;

import me.szaki.szakibuszv2.controllers.forms.LoginForm;
import me.szaki.szakibuszv2.controllers.forms.RegisterForm;
import me.szaki.szakibuszv2.exceptions.PasswordNotMatchException;
import me.szaki.szakibuszv2.exceptions.UserAlreadyExistsException;
import me.szaki.szakibuszv2.exceptions.UserNotFoundException;
import me.szaki.szakibuszv2.models.UserEntity;
import me.szaki.szakibuszv2.services.UserService;
import me.szaki.szakibuszv2.utilities.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class UserController {

    //<editor-fold defaultstate="collapsed" desc="Autowired Filed">
    @Autowired
    private UserService userService;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public UserController() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET">
    @GetMapping("/user/login")
    public UserEntity login(@RequestBody LoginForm loginForm) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(loginForm.getUsername());
        userEntity.setPassword(loginForm.getPassword());

        return userService.loginUser(userEntity);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="POST">
    @PostMapping("/user/register")
    public UserEntity register(@RequestBody RegisterForm registerForm) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerForm.getUsername());
        userEntity.setPassword(registerForm.getPassword());
        userEntity.setEmail(registerForm.getEmail());

        return userService.registerUser(userEntity);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Exception Handlers">
    @ExceptionHandler(value = UserAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorResponse handleUserAlreadyExsistsException(UserAlreadyExistsException e) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(value = PasswordNotMatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePasswordNotMatchException(PasswordNotMatchException e) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
    //</editor-fold>
}
