package com.example.brand.repositories.user;

import com.example.brand.repositories.SearchingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.brand.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends SearchingRepository<UserEntity, Long>, UserRepositoryCustom {
    // jpql
    // ví dụ về hàm tìm kiếm phân trang
//    @Query("select u from UserEntity u where u.fullName like %:key% or u.userName like %:key%")
    @Query(value = "SELECT * FROM user  where FULL_NAME like %?1% or USER_NAME like %?1%", nativeQuery = true)
    Page<UserEntity> findAll(String key, Pageable pageable);

    // Tìm kiếm danh sách User có trạng thái active
    List<UserEntity> findAllByStatus(Integer status);
}

