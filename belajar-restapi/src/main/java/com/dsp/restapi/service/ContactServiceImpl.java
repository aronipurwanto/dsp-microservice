package com.dsp.restapi.service;

import com.dsp.restapi.model.request.ContactRequest;
import com.dsp.restapi.model.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService{
    @Override
    public Optional<Response> save(ContactRequest request) {
        return Optional.empty();
    }
}
