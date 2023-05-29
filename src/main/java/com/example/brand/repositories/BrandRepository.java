package com.example.brand.repositories;

import com.example.brand.entities.BrandEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrandRepository extends SearchingRepository<BrandEntity, Long> {
    @Query(value = "SELECT * FROM brand  where NAME like %?1% or DESCRIPTION like %?1%", nativeQuery = true)
    Page<BrandEntity> findAll(String key, Pageable pageable);
}
