package com.cursosandroidant.auth

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.hasItemInArray
import org.junit.Ignore
import org.junit.Test

/**
 * Created by davidgonzalez on 25/02/23
 */
class AuthHamcrestTest {

    //given-when-then
    @Test
    fun loginUser_correctData_returnSuccessEvent() {
        val result = userAuthenticationTDD("ant@gmail.com", "1234")
        assertThat(AuthEvent.USER_EXIST, `is`(result))
    }

    @Test
    fun loginUser_wrongData_returnsFailEvent() {
        val result = userAuthenticationTDD("antt@gmail.com", "1234")
        assertThat(AuthEvent.NOT_USER_EXIST, `is`(result))
    }

    @Test
    fun loginUser_emptyEmail_returnsFailEvent() {
        val result = userAuthenticationTDD("", "1234")
        assertThat(AuthEvent.EMPTY_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_emptyPassword_returnsFailEvent() {
        val result = userAuthenticationTDD("ant@gmail.com", "")
        assertThat(AuthEvent.EMPTY_PASSWORD, `is`(result))
    }

    @Test
    fun loginUser_emptyForm_returnsFailEvent() {
        val result = userAuthenticationTDD("", "")
        assertThat(AuthEvent.EMPTY_FORM, `is`(result))
    }

    @Test
    fun loginUser_completeForm_invalidEmail_returnsFailEvent() {
        val result = userAuthenticationTDD("antt@gmailcom", "1234")
        assertThat(AuthEvent.INVALID_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_completeForm_invalidPassword_returnsFailEvent() {
        val result = userAuthenticationTDD("antt@gmail.com", "1234e")
        assertThat(AuthEvent.INVALID_PASSWORD, `is`(result))
    }

    @Test
    fun loginUser_completeForm_invalidUser_returnsFailEvent() {
        val result = userAuthenticationTDD("antt@gmailcom", "1234e")
        assertThat(AuthEvent.INVALID_USER, `is`(result))
    }

    @Test(expected = AuthException::class)
    fun loginUser_nullEmail_returnsException() {
        val result = userAuthenticationTDD(null, "1234e")
        assertThat(AuthEvent.NULL_EMAIL, `is`(result))
    }

   /* @Test
    fun loginUser_nullPassword_returnsException() {
        assertThat(AuthException::class.java, `is`(result)) {
            print(userAuthenticationTDD("ant@gmail.com", null))
        }
    }*/

    @Test
    fun loginUser_nullForm_returnsException() {
        try {
            val result = userAuthenticationTDD(null, null)
            assertThat(AuthEvent.NULL_FORM, `is`(result))
        } catch (e: Exception) {
            (e as? AuthException)?.let {
                assertThat(AuthEvent.NULL_FORM, `is`(it.authEvent))
            }
        }
    }

    @Ignore("Falta definir un requisito del cliente") //Nota: la etiqueta @Ignore sirve para no correr la prueba
    @Test
    fun loginUser_completeForm_errorLengthPassword_returnsFailEvent() {
        val result = userAuthenticationTDD("ant@gmail.com", "123")
        assertThat(AuthEvent.PASSWORD_LENGTH, `is`(result))
    }

    @Test
    fun checkNames_differentUsers_match() { //Test para saber si el string contiene al menos una leta "a" y "i"
        assertThat("Maria", both(containsString("a")).and(containsString("i")))
    }

    @Test
    fun checkData_emailPassword_noMatch() { // Test para saber que el email no es igual al password
        val email = "david@gmail.com"
        val password = "1234"
        assertThat(email, not(`is`(password)))
    }

    @Test
    fun checkExist_newEmail_returnString() { //Test para comprobar si en una lista existe algun string
        val oldEmail = "ant@gmail.com"
        val newEmail = "david@gmail.com"
        val emails = arrayOf(oldEmail, newEmail)
        assertThat(emails, hasItemInArray(newEmail))
    }

    @Test
    fun checkDomain_arrayEmails_returnsString() { //Test para saber si los email contienen el dominio @android.com o algun string
        val nextEmail = "alejandro@android.com"
        val oldEmail = "ant@android.com"
        val newEmail = "david@android.com"
        val emails = arrayListOf(oldEmail, newEmail, nextEmail)
        assertThat(emails, everyItem(endsWith("android.com"))) //Tambien existe startWith
    }
}