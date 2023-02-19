package com.cursosandroidant.auth

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by davidgonzalez on 19/02/23
 */
class AuthTest {

    //Nota: la manera correcta para nombrar los metodos:
    /*1.-Accion a ejecutar
    * 2.-En base a que escenario, el formulario completo
    * 3.-Que es lo que debe pasar*/

    @Test
    fun login_complete_return_true() {
        val isAuthenticated = userAuthentication("ant@gmail.com", "1234")
        assertTrue(isAuthenticated)
    }

    @Test
    fun login_emptyEmail_return_false() {
        val isAuthenticated = userAuthentication("", "12345")
        assertFalse(isAuthenticated)
    }

    //TDD
    /*@Test
    fun login_nullEmail_return_false() {
        val isAuthenticated = userAuthenticationTDD(null, "12345")
        assertFalse(isAuthenticated)
    }

    @Test
    fun login_nullPassword_return_false() {
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com", null)
        assertFalse(isAuthenticated)
    }*/
}