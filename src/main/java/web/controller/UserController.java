package web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping()
    public String getUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("user", user);
        return "user";
    }
}
