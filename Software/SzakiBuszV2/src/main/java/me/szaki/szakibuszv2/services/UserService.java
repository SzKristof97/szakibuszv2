package me.szaki.szakibuszv2.services;

import io.swagger.v3.oas.annotations.Parameter;
import me.szaki.szakibuszv2.exceptions.PasswordNotMatchException;
import me.szaki.szakibuszv2.exceptions.UserAlreadyExistsException;
import me.szaki.szakibuszv2.exceptions.UserNotFoundException;
import me.szaki.szakibuszv2.interfaces.IUserService;
import me.szaki.szakibuszv2.models.UserEntity;
import me.szaki.szakibuszv2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for the user
 */
@Service
public class UserService implements IUserService {

    //<editor-fold desc="Private Fields">
    @Autowired
    private UserRepository userRepository;
    //</editor-fold>

    //<editor-fold desc="Public Methods">
    @Override
    @Parameter(name = "userEntity", description = "The user to register")
    @Description(value = "Registers a new user to the database and returns the user if the registration was successful")
    public UserEntity registerUser(UserEntity userEntity) {
        userEntity.setUsername(userEntity.getUsername().toLowerCase());

        // First check if the user is already registered
        Optional<UserEntity> user = userRepository.findByUsername(userEntity.getUsername());
        if (user.isPresent()) {
            throw new UserAlreadyExistsException("User already exsists");
        }

        // If the user is not registered, register it
        return userRepository.save(userEntity);
    }

    @Override
    @Parameter(name = "userEntity", description = "The user to login")
    @Description(value = "Logins the user and returns the user if the login was successful")
    public UserEntity loginUser(UserEntity userEntity) {
        userEntity.setUsername(userEntity.getUsername().toLowerCase());

        // Check if the user is registered
        Optional<UserEntity> user = userRepository.findByUsername(userEntity.getUsername());
        if (!user.isPresent()) {
            throw new UserNotFoundException("User not found");
        }

        // if the user is registered, check if the password is correct
        if (!user.get().getPassword().equals(userEntity.getPassword())) {
            throw new PasswordNotMatchException("Password not match");
        }

        // If the password is correct, return the user
        return user.get();
    }
    //</editor-fold>
}
