package net.konohana.sakuya.sample.controller

import net.konohana.sakuya.sample.form.UserRegistrationForm
import net.konohana.sakuya.sample.service.UserRegistrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

/**
 * Controller
 */
@Controller
@Validated
class AccountController {

    @Autowired
    lateinit var userRegistrationService: UserRegistrationService

    @GetMapping("/")
    fun showTop(): String {
        return "index"
    }

    @GetMapping("/login")
    fun showLoginPage(): String {
        return "login"
    }

    @GetMapping("/user/registration")
    fun showUserRegistration(@ModelAttribute("form") form: UserRegistrationForm?): String {
        return "user-registration"
    }

    @PostMapping("/user/registration")
    fun userRegistration(
        @Validated @ModelAttribute("form") form: UserRegistrationForm,
        result: BindingResult
    ): String {
        if (result.hasErrors()) {
            return "user-registration"
        }
        userRegistrationService.userRegistration(form.username!!, form.password!!)
        return "redirect:/login"
    }
}
