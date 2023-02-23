package com.cursosandroidant.auth

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by davidgonzalez on 19/02/23
 */
class AuthTDDTest {

    @Test
    fun login_completeForm_existUser_returnSuccessEvent() {
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com", "1234")
        assertEquals(AuthEvent.USER_EXIST, isAuthenticated)
    }

    @Test
    fun login_completeForm_notExistUser_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("antt@gmail.com", "1234")
        assertEquals(AuthEvent.NOT_USER_EXIST, isAuthenticated)
    }

    @Test
    fun login_emptyEmail_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("", "1234")
        assertEquals(AuthEvent.EMPTY_EMAIL, isAuthenticated)
    }

    @Test
    fun login_emptyPassword_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com", "")
        assertEquals(AuthEvent.EMPTY_PASSWORD, isAuthenticated)
    }

    @Test
    fun login_emptyForm_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("", "")
        assertEquals(AuthEvent.EMPTY_FORM, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("antt@gmailcom", "1234")
        assertEquals(AuthEvent.INVALID_EMAIL, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("antt@gmail.com", "1234e")
        assertEquals(AuthEvent.INVALID_PASSWORD, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidUser_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("antt@gmailcom", "1234e")
        assertEquals(AuthEvent.INVALID_USER, isAuthenticated)
    }

    @Test
    fun login_nullEmail_returnsException() {

    }

    @Test
    fun login_nullPassword_returnsException() {

    }

    @Test
    fun login_nullForm_returnsException() {

    }

    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent() {

    }
}