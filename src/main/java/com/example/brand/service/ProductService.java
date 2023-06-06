package com.example.brand.service;

import com.example.brand.dto.ProductDto;
import com.example.brand.dto.ResponseDto;
import com.example.brand.dto.ResponseTableDto;
import com.example.brand.entities.ProductsEntity;
import com.example.brand.repositories.product.ProductRepository;

import com.example.brand.utils.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    FileUtils fileUtils;

    public ResponseDto save(ProductDto productDto) throws Exception {
        String mesage = "";
        ProductsEntity productsEntity = new ProductsEntity();
        if (productDto.getId() != null) {
            mesage = "cập nhập ";
            productsEntity = getById(productDto.getId());
            BeanUtils.copyProperties(productDto, productsEntity);
            productsEntity.setUpdatedTime(new Timestamp(System.currentTimeMillis()));
        } else {
            mesage = "Tạo mới ";
            productsEntity.setAlias(productDto.getAlias());
            productsEntity.setCreatedTime(new Timestamp(System.currentTimeMillis()));
            productsEntity.setDiscountPercent(productDto.getDiscountPercent());
            productsEntity.setEnabled(productDto.isEnabled());
            productsEntity.setFullDescription(productDto.getFullDescription());
            productsEntity.setHeight(productDto.getHeight());
            productsEntity.setInStock(productDto.getInStock());
            productsEntity.setLength(productDto.getLength());
            productsEntity.setMainImage(productDto.getMainImage());
            productsEntity.setName(productDto.getName());
            productsEntity.setPrice(productDto.getPrice());
            productsEntity.setShortDescription(productDto.getShortDescription());
            productsEntity.setWeight(productDto.getWeight());
            productsEntity.setWidth(productDto.getWidth());
            productsEntity.setBrandId(productDto.getBrandId());
            productsEntity.setCategoryId(productDto.getCategoryId());
        }
        if (productDto.getFimeImage() != null) {

            productsEntity.setMainImage(fileUtils.savefile(productDto.getFimeImage()));
        }
        productRepository.save(productsEntity);

        ResponseDto responseDto = new ResponseDto(mesage + "thành công");
        return responseDto;
    }

    public void list(ResponseTableDto tableDto) {
        tableDto.list(productRepository);
    }

    public String delete(Long id) {
        ProductsEntity productsEntity = productRepository.findById(id).get();
        if (productsEntity == null)
            return "Sản phẩm không tồn tại";

        productRepository.delete(productsEntity);
        return "Xóa sản phẩm thành công";
    }

    public ProductsEntity getById(long id) {
        ProductsEntity productsEntity = productRepository.findById(id).get();
        return productsEntity;
    }
}

