package com.dsp.restapi.service;

import com.dsp.restapi.model.request.RegisterRequest;
import com.dsp.restapi.model.response.Response;

import java.util.Optional;

public interface UserService {
    Optional<Response> register(RegisterRequest request);
}
