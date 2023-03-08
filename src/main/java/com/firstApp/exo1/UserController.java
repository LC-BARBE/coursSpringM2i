package com.firstApp.exo1;

import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/users")
public class UserController {

    ArrayList<User> listUsers = new ArrayList<User>();
    User user = new User();
    UserService userService = new UserService();

    @GetMapping(value = "/form")
    public String userForm(HttpSession session, Model model) throws IOException {
        String[] fields = new String[User.class.getDeclaredFields().length];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = User.class.getDeclaredFields()[i].getName();
        }
        model.addAttribute("user", new User());
        model.addAttribute("fields", fields);
        return "userForm";
    }

    //    @PostMapping(value = "/submitForm")
    @RequestMapping(value = "/submitForm", method = RequestMethod.POST)
    public String submitForm(Model model, @ModelAttribute("user") User user) throws IOException, ParseException {
        user.setEmailValid(userService.verifyEmailByApi(user.getEmail()));
        this.listUsers.add(user);
        model.addAttribute("list", this.listUsers);
        return "userList";
    }

    @GetMapping(value = "/list")
    public String userShow(Model model) {
        model.addAttribute("list", this.listUsers);
        return "userList";
    }
}
