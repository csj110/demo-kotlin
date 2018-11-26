package demo.kotlin.repository

import demo.kotlin.model.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.context.junit.jupiter.SpringExtension
import reactor.test.test

@ExtendWith(SpringExtension::class)
@SpringBootTest
class UserRepositoryTest(
        @Autowired private val userRepository: UserRepository,
        @Autowired private val passwordEncoder: PasswordEncoder) {

    @Test
    fun `Verify findByUsername returns existing Fred User`() {
        userRepository.findByUsername("Fred")
                .test()
                .consumeNextWith {
                    assertThat(it.username).isEqualTo("Fred")
                    assertThat(passwordEncoder.matches("password", it.password)).isTrue()
                    assertThat((it as User).id).isNotNull()
                }.verifyComplete()
    }

    @Test
    fun `Verify findByUsername returns no John User`() {
        userRepository.findByUsername("John")
                .test()
                .verifyComplete()
    }
}
