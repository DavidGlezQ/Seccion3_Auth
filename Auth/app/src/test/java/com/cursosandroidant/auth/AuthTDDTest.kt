package com.cursosandroidant.auth

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Ignore
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

    @Test(expected = AuthException::class)
    fun login_nullEmail_returnsException() {
        val isAuthenticated = userAuthenticationTDD(null, "1234e")
        assertEquals(AuthEvent.NULL_EMAIL, isAuthenticated)
    }

    @Test
    fun login_nullPassword_returnsException() {
        assertThrows(AuthException::class.java) {
            print(userAuthenticationTDD("ant@gmail.com", null))
        }
    }

    @Test
    fun login_nullForm_returnsException() {
        try {
            val result = userAuthenticationTDD(null, null)
            assertEquals(AuthEvent.NULL_FORM, result)
        } catch (e: Exception) {
            (e as? AuthException)?.let {
                assertEquals(AuthEvent.NULL_FORM, it.authEvent)
            }
        }
    }

    @Ignore("Falta definir un requisito del cliente") //Nota: la etiqueta @Ignore sirve para no correr la prueba
    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com", "123")
        assertEquals(AuthEvent.PASSWORD_LENGTH, isAuthenticated)
    }
}