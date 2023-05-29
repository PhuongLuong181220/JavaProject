package com.example.brand.repositories.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import com.example.brand.entities.ProductsEntity;
import com.example.brand.entities.UserEntity;
import com.example.brand.repositories.SearchingRepository;

public interface ProductRepository extends SearchingRepository<ProductsEntity, Long> {
    @Query(value = "SELECT * FROM products  where full_description like %?1% or " +
            "short_description like %?1% or alias like %?1% ", nativeQuery = true)
    Page<ProductsEntity> findAll(String key, Pageable pageable);

}
