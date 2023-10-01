package ru.def.learn.pp_3_1_2.controllers;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.def.learn.pp_3_1_2.model.User;
import ru.def.learn.pp_3_1_2.service.UserService;

import java.util.Date;

@Controller
@RequestMapping
public class UserController {

    private final UserService userService;
    private static final String MAIN_PAGE = "redirect:/";


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index (Model model) {
        model.addAttribute("users", userService.getAll());
        return "index";
    }
    @GetMapping("/new")
    public String add (Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping("/")
    public String user(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.add(user);
        return MAIN_PAGE;
    }
    @DeleteMapping ("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return MAIN_PAGE;
    }
    @PatchMapping ("/{id}")
    public String update(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.update(user);
        return MAIN_PAGE;
    }
    @GetMapping("/{id}/patch")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }
}
