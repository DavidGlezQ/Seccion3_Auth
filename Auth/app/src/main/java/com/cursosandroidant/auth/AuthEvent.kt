package com.cursosandroidant.auth

/**
 * Created by davidgonzalez on 19/02/23
 */
enum class AuthEvent {
    PASSWORD_LENGTH,
    //Success
    USER_EXIST,
    //Fail User
    NOT_USER_EXIST,
    EMPTY_EMAIL,
    EMPTY_PASSWORD,
    EMPTY_FORM,
    INVALID_EMAIL,
    INVALID_PASSWORD,
    INVALID_USER,
    //Exceptions
    NULL_EMAIL,
    NULL_PASSWORD,
    NULL_FORM
}