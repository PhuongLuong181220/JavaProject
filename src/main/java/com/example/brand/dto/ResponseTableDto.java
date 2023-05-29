package com.example.brand.dto;

import com.example.brand.repositories.SearchingRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTableDto {
    long totalElement;
    List<?> list;
    int totalPage;
    int page;
    int perpage;
    String key;
    String path;
    ModelAndViewContainer mavContainer;

    public ResponseTableDto(String path, int page, int perpage, String key, ModelAndViewContainer mavContainer) {
        this.page = page;
        this.perpage = perpage;
        this.key = key;
        this.path = path;
        this.mavContainer = mavContainer;
    }

    public void list(JpaRepository repository) {
        Page<?> pageAll = repository.findAll(PageRequest.of(page - 1, perpage));
        long tongSo = pageAll.getTotalElements();
        this.totalElement = tongSo;
        list = pageAll.getContent();
        this.totalPage = (int) (tongSo % perpage == 0 ? tongSo / perpage : tongSo / perpage + 1);
        mavContainer.addAttribute("list", this);
    }

    public void list(SearchingRepository repository) {
        Page<?> pageAll = repository.findAll(key, PageRequest.of(page - 1, perpage));
        long tongSo = pageAll.getTotalElements();
        this.totalElement = tongSo;
        list = pageAll.getContent();
        this.totalPage = (int) (tongSo % perpage == 0 ? tongSo / perpage : tongSo / perpage + 1);
        mavContainer.addAttribute("list", this);
    }
}
