package net.konohana.sakuya.sample.service

import net.konohana.sakuya.sample.entity.User2
import net.konohana.sakuya.sample.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserRegistrationService {
    @Autowired
    private val passwordEncoder: PasswordEncoder? = null

    @Autowired
    lateinit var userRepository: UserRepository
    fun userRegistration(username: String, password: String) {
        val hashedPassword = passwordEncoder!!.encode(password)
        userRepository.saveAndFlush<User2>(User2(username, hashedPassword, "GENERAL"))
    }
}
