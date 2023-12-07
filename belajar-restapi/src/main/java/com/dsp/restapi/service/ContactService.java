package com.dsp.restapi.service;

import com.dsp.restapi.model.request.ContactRequest;
import com.dsp.restapi.model.response.Response;

import java.util.Optional;

public interface ContactService {
    Optional<Response> save(ContactRequest request);
}
