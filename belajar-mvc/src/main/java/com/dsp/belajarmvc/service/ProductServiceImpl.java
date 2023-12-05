package com.dsp.belajarmvc.service;

import com.dsp.belajarmvc.model.entity.CategoryEntity;
import com.dsp.belajarmvc.model.entity.ProductEntity;
import com.dsp.belajarmvc.model.request.ProductRequest;
import com.dsp.belajarmvc.model.response.ProductResponse;
import com.dsp.belajarmvc.repository.CategoryRepository;
import com.dsp.belajarmvc.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository repository;
    private CategoryRepository categoryRepo;

    @Autowired
    public ProductServiceImpl(ProductRepository repository, CategoryRepository categoryRepo) {
        this.repository = repository;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<ProductResponse> getAll() {
        List<ProductEntity> result = this.repository.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }
        return result.stream().map(ProductResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductResponse> getById(Long id) {
        if(id == 0L) {
            return Optional.empty();
        }
        Optional<ProductEntity> result = repository.findById(id);
        return result.map(ProductResponse::new);
    }

    @Override
    public Optional<ProductResponse> save(ProductRequest request) {
        if(request == null) {
            return Optional.empty();
        }

        CategoryEntity category = this.categoryRepo.findById(request.getId()).orElse(null);
        if(category == null){
            return Optional.empty();
        }

        ProductEntity product = new ProductEntity(request, category);
        try{
            this.repository.save(product);
            log.info("Save product success");
            return Optional.of(new ProductResponse(product));
        }catch (Exception e){
            log.error("Save product failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
