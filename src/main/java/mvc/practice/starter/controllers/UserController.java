package mvc.practice.starter.controllers;

import mvc.practice.starter.dtos.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/10/25
 */

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "message/addForm";
    }
}
