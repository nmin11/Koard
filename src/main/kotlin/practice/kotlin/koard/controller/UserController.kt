package practice.kotlin.koard.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import practice.kotlin.koard.dto.UserDto

@Controller
class UserController {

    @GetMapping("/login")
    fun loginForm(): String? {
        return "user/login"
    }

    @GetMapping("/register")
    fun registerForm(model: Model): String? {
        model.addAttribute("dto", UserDto())
        return "user/register"
    }

    @PostMapping("/logout")
    fun logout(): String? {
        return "redirect:/"
    }

}