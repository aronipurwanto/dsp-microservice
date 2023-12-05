package com.dsp.belajarmvc.service;

import com.dsp.belajarmvc.model.request.ProductRequest;
import com.dsp.belajarmvc.model.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponse> getAll();
    Optional<ProductResponse> getById(Long id);
    Optional<ProductResponse> save(ProductRequest request);
}
