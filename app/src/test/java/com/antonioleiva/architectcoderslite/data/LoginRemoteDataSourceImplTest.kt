package com.antonioleiva.architectcoderslite.data

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LoginRemoteDataSourceImplTest {

    private val ds = LoginRemoteDataSourceImpl()

    @Test
    fun `user without @ returns error`(): Unit = runBlocking {
        val result = ds.tryLogin("user", "")
        assertTrue(result.userError)
    }

    @Test
    fun `user with @ returns success`(): Unit = runBlocking {
        val result = ds.tryLogin("user@", "")
        assertFalse(result.userError)
    }

    @Test
    fun `pass with less than 5 characters returns error`(): Unit = runBlocking {
        val result = ds.tryLogin("", "1234")
        assertTrue(result.passError)
    }

    @Test
    fun `pass with 5 characters returns success`(): Unit = runBlocking {
        val result = ds.tryLogin("", "12345")
        assertFalse(result.passError)
    }
}