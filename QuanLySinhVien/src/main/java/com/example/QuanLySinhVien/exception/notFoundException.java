package com.example.QuanLySinhVien.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class notFoundException extends RuntimeException{
    private int code;
    private String message;
}
