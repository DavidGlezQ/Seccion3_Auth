package com.cursosandroidant.auth

/**
 * Created by davidgonzalez on 25/02/23
 */
class AuthException(val authEvent: AuthEvent, msg: String? = null) : Exception(msg)  {
}