package com.dsp.belajarmvc.service;

import com.dsp.belajarmvc.model.request.CategoryRequest;
import com.dsp.belajarmvc.model.response.CategoryResponse;
import com.dsp.belajarmvc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Optional<CategoryResponse> save(CategoryRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<CategoryResponse> update(CategoryRequest request, Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CategoryResponse> delete(Long id) {
        return Optional.empty();
    }
}
