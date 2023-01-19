package net.konohana.sakuya.sample.controller

import com.google.i18n.phonenumbers.PhoneNumberUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PhoneNumberController {

    @GetMapping("/api/convert/{number}")
    fun convertPhoneNumber(@PathVariable number: String): String {
        val phoneNumberUtil = PhoneNumberUtil.getInstance()
        return runCatching {
            phoneNumberUtil.format(
                phoneNumberUtil.parse(number, "JP"),
                PhoneNumberUtil.PhoneNumberFormat.NATIONAL
            )
        }.getOrElse {
            return "変換エラー！！"
        }
    }
}
