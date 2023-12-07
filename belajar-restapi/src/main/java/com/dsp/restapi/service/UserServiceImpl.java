package com.dsp.restapi.service;

import com.dsp.restapi.exception.CommonApiException;
import com.dsp.restapi.model.entity.UserEntity;
import com.dsp.restapi.model.request.RegisterRequest;
import com.dsp.restapi.model.response.Response;
import com.dsp.restapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Response> register(RegisterRequest request) {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(request, entity);
        entity.setId(UUID.randomUUID().toString());

        try{
            this.repository.save(entity);
            Response result = new Response(200,"Success", entity);
            return Optional.of(result);
        }catch (Exception e){
            throw new CommonApiException("Save user is failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
