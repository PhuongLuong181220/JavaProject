package com.example.brand.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.brand.dto.ResponseDto;
import com.example.brand.dto.ResponseTableDto;
import com.example.brand.dto.UserDto;
import com.example.brand.entities.UserEntity;
import com.example.brand.repositories.user.UserRepository;

import java.util.List;

@Service// đanh dấu nó là service (1 bean trong spring bean container)
public class UserService {

    @Autowired
    UserRepository userRepository;

    //1: Sử dụng Spring data JPA để thêm sửa xóa, lấy danh sách bảng user và book

    public ResponseDto save(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        if (userDto.getId() != null){
            userEntity = userRepository.findById(userDto.getId()).get();
        } else {
            userEntity.setUserName(userDto.getUserName());
            userEntity.setPassword(userDto.getPassword());
        }
        userEntity.setFullName(userDto.getFullName());
        userEntity.setRole(userDto.getRole());
        userEntity.setStatus(userDto.getStatus());
        userEntity.setAddress(userDto.getAddress());
        userRepository.save(userEntity);
        return new ResponseDto("Lưu tài khoản " + userDto.getFullName() + " thành công");
    }

    public void list(ResponseTableDto tableDto) {
        tableDto.list(userRepository);
    }
    public UserEntity detail(Long id) {
        UserEntity detail = userRepository.findById(id).get();;
        return detail;
    }

    public String delete(Long id) {
        UserEntity detail = userRepository.findById(id).get();
        if (detail == null) return "Tài khoản không tồn tại";
        userRepository.deleteById(id);
        return "Xóa thành công";
    }
}