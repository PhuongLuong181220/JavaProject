package com.example.brand.controller.backend;

import com.example.brand.config.paging.PagingParam;
import com.example.brand.dto.ResponseTableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.brand.dto.ResponseDto;
import com.example.brand.dto.UserDto;
import com.example.brand.service.UserService;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("backend/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("list")
    public String list(Model model, @PagingParam(path = "user")ResponseTableDto responseTableDto) {
        userService.list(responseTableDto);
        return "/user/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "user/create";
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.detail(id));
        return "user/detail";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.detail(id));
        return "user/edit";
    }

    @PostMapping(value = "save",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save(@Valid UserDto userDto, BindingResult bindingResult,
                       Model model, RedirectAttributes redirectAttributes)
            throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/create";
        } else if (!userDto.getPassword().equalsIgnoreCase(userDto.getRePassword())) {
            bindingResult.rejectValue("rePassword", "error.userDto", "Mật khẩu không khớp");
            return "user/create";
        }
        ResponseDto dto = userService.save(userDto);
        redirectAttributes.addFlashAttribute("message", dto.getMessage());
        return "redirect:/backend/user/list";

//        return "/jsp/user/create.jsp";
    }

    @PostMapping(value = "update",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String update(UserDto userDto, RedirectAttributes redirectAttributes)
            throws SQLException {
        ResponseDto dto = userService.save(userDto);
        redirectAttributes.addFlashAttribute("message", dto.getMessage());
        return "redirect:/backend/user/list";

//        return "/jsp/user/create.jsp";
    }

    @DeleteMapping(value = "delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id)
            throws SQLException {
        return userService.delete(id);

    }


}