package com.example.demo.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestParam {

    @NotBlank
    private String param;
}
