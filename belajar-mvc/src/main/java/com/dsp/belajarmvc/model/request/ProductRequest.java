package com.dsp.belajarmvc.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Long id;
    private String code;
    private String name;
    private Date expireDate;
    private Long price;
    private Long categoryId;
}
