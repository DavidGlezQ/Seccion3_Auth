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
}