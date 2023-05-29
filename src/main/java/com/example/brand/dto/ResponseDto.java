package com.example.brand.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    String message;
    Object data;

    public ResponseDto(String message) {
        this.message = message;
    }
}
