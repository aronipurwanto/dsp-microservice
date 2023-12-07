package com.dsp.restapi.service;

import com.dsp.restapi.model.request.RegisterRequest;
import com.dsp.restapi.model.response.Response;
import com.dsp.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Response> register(RegisterRequest request) {
        return Optional.empty();
    }
}
