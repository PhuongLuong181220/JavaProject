package com.example.brand.controller.backend;

import com.example.brand.config.paging.PagingParam;
import com.example.brand.dto.ProductDto;
import com.example.brand.dto.ResponseDto;
import com.example.brand.dto.ResponseTableDto;
import com.example.brand.service.BrandCategoryService;
import com.example.brand.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
// 1: dựa vào link https://gist.github.com/m-cakir/05470e679b73e2036254cef949432fcc
// để thực hiện lưu ảnh trên google storage
// 2: Tạo 1 bảng product_image(id, productId, image_url) 1 sản phẩm có thể có nhiều ảnh
// 3: Tạo 1 tab (cùng màn hình với create và detail product)
// để thực hiện upload nhiều ảnh và lưu vào CSDL theo product id

@Controller
@RequestMapping("/backend/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    BrandCategoryService brandCategoryService;

    @GetMapping("/list")
    public String listProduct(
            @PagingParam(path = "product")
            ResponseTableDto responseTableDto) {
        productService.list(responseTableDto);
        return "product/list";
    }

    @GetMapping("/{id}")
    public String product(@PathVariable long id, Model model) {
        model.addAttribute("productDto", productService.getById(id));
        model.addAttribute("categories", brandCategoryService.findAll("category"));
        model.addAttribute("brands", brandCategoryService.findAll("brand"));
        return "product/detail";
    }

    @GetMapping("/create")
    private String create(Model model) {
        ProductDto productDto = new ProductDto();
        model.addAttribute("brands", brandCategoryService.findAll("brand"));
        model.addAttribute("categories", brandCategoryService.findAll("category"));
        model.addAttribute("productDto", productDto);
        return "product/create";
    }

    @PostMapping(value = "/save",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String save(@Valid @ModelAttribute("productDto") ProductDto productDto,
//                       @RequestParam("fileImage") MultipartFile file,
                       BindingResult bindingResult,
                       Model model, RedirectAttributes redirectAttributes) throws Exception {
        ResponseDto responseDto = productService.save(productDto);
        model.addAttribute("message", responseDto.getMessage());
        return "redirect:/backend/product/list";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        return productService.delete(id);
    }


}
