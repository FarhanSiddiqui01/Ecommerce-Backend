package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CategoryDTO {
    private Long id;
    @NotBlank(message = "should not be empty!")
    private String name;
}
