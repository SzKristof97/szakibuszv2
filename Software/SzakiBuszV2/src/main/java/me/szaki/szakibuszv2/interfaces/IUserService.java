package me.szaki.szakibuszv2.interfaces;

import me.szaki.szakibuszv2.models.UserEntity;

/**
 * Interface for the user service
 */
public interface IUserService {
    /**
     * Registers a new user to the database
     * and returns the user if the registration was successful
     * @param userEntity the user to register
     * @return the registered user if the registration was successful or null if it wasn't
     */
    UserEntity registerUser(UserEntity userEntity);

    /**
     * Logins the user and returns the user if the login was successful
     * @param userEntity the user to login
     * @return the logged-in user if the login was successful or null if it wasn't
     */
    UserEntity loginUser(UserEntity userEntity);
}
