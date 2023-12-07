package com.dsp.restapi.controller;

import com.dsp.restapi.model.request.ContactRequest;
import com.dsp.restapi.model.response.Response;
import com.dsp.restapi.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody @Valid ContactRequest request){
        Response result = contactService.save(request).orElse(null);
        return ResponseEntity.ok(result);
    }
}
