package net.konohana.sakuya.sample.form

import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size
import org.springframework.validation.annotation.Validated

@Validated
data class UserRegistrationForm(
    @field:NotBlank
    @field:Size(min = 4, max = 20)
    val username: String? = null,

    @field:NotBlank
    @field:Size(min = 8, max = 20)
    val password: String? = null,

    @field:NotBlank
    @field:Size(min = 8, max = 20)
    val confirmPassword: String? = null,
) {
    @AssertTrue
    fun isPasswordValid(): Boolean {
        return if (password == null || confirmPassword == null) return false else password == confirmPassword
    }
}
