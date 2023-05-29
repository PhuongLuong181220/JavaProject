package com.example.brand.controller.backend;

import com.example.brand.config.paging.PagingParam;
import com.example.brand.dto.BrandCategoryDto;
import com.example.brand.dto.ResponseTableDto;
import com.example.brand.service.BrandCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.sql.SQLException;

@Controller
public class BrandCategoryController {
    @Autowired
    BrandCategoryService brandCategoryService;

    @GetMapping("/backend/{path}/list")
    public String list(@PathVariable String path, @PagingParam ResponseTableDto dataTableDto, Model model){
        model.addAttribute("title", "brand".equalsIgnoreCase(path) ? " thương hiệu": "thể loại");
        dataTableDto.setPath(path);
        brandCategoryService.list(dataTableDto, path);
        return "brand-category/list";
    }
    @GetMapping("/backend/{path}/create")
    public String create(Model model, @PathVariable String path,
                         HttpServletRequest request, HttpServletResponse response){
        model.addAttribute("title", "brand".equalsIgnoreCase(path) ? " thương hiệu": "thể loại");
        model.addAttribute("path", path);
        return "/brand-category/create";
    }

    @GetMapping("/backend/{path}/edit/{id}")
    public String create(Model model, @PathVariable String path, @PathVariable Long id,
                         HttpServletRequest request, HttpServletResponse response){
        model.addAttribute("title", "brand".equalsIgnoreCase(path) ? " thương hiệu": "thể loại");
        model.addAttribute("path", path);
        model.addAttribute("model", brandCategoryService.getById(id, path));
        return "brand-category/edit";
    }

    @PostMapping(value = "/backend/{path}/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createform(@PathVariable String path, BrandCategoryDto dto,
                             RedirectAttributes redirectAttributes, Model model) throws Exception {
        brandCategoryService.save(dto, path);
        return "redirect:/backend/" + path + "/list";
    }



    @DeleteMapping(value = "/backend/{path}/delete/{id}")
    @ResponseBody
    public String delete(Model model, @PathVariable String path, @PathVariable Long id)
            throws SQLException {
        model.addAttribute("path", path);
        return brandCategoryService.delete(path, id);

//        return "/jsp/user/create.jsp";
    }

}

