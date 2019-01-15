package demo.kotlin.security

import demo.kotlin.model.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle

private const val EXPIRED_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwiZW5hYmxlIjp0cnVlLCJ" +
        "zdWIiOiJGcmVkIiwiaWF0IjoxNTQ3NTA0MTEwLCJleHAiOjE1NDc1MzI5MTB9._QOBJMLWNcFSzDwsiZbIJ5gmXG1tQZ" +
        "90jP4omKJIey84l7ZQ72sN_7WdN94XjDJsgZ4SoDJL4MtTpmy_o3wS1A"

@TestInstance(Lifecycle.PER_CLASS)
class JWTUtilTest {
    private lateinit var jwtUtil: JWTUtil

    @BeforeAll
    private fun beforeAll() {
        jwtUtil = JWTUtil("mysecret", "1000")
    }

    @Test
    fun `Verify generateToken generates a token, basic one !`() {
        val jwtToken = generateToken()
        assertThat(jwtToken).isNotNull().isNotEmpty()
    }

    @Test
    fun `Verify a token generated by JwtUtil for active user is valid`() {
        val jwtToken = generateToken()
        assertThat(jwtUtil.validateToken(jwtToken))
                .isTrue()
    }

    @Test
    fun `Verify a token generated by JwtUtil for inactive user is invalid`() {
        val jwtToken = generateToken(false)
        assertThat(jwtUtil.validateToken(jwtToken))
                .isFalse()
    }

    @Test
    fun `Verify a expired token generated by JwtUtil for active user is invalid`() {
        assertThat(jwtUtil.validateToken(EXPIRED_TOKEN))
                .isFalse()
    }

    private fun generateToken(active: Boolean = true) = jwtUtil.generateToken(User("Fred", "password", active = active))
}