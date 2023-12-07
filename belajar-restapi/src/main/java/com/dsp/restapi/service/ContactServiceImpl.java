package com.dsp.restapi.service;

import com.dsp.restapi.exception.CommonApiException;
import com.dsp.restapi.model.entity.AddressEntity;
import com.dsp.restapi.model.entity.ContactEntity;
import com.dsp.restapi.model.entity.UserEntity;
import com.dsp.restapi.model.request.AddressRequest;
import com.dsp.restapi.model.request.ContactRequest;
import com.dsp.restapi.model.response.Response;
import com.dsp.restapi.repository.ContactRepository;
import com.dsp.restapi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService{
    private UserRepository userRepository;
    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(UserRepository userRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }

    @Transactional
    @Override
    public Optional<Response> save(ContactRequest request) {
        UserEntity user = userRepository.findById(request.getUserId()).orElse(null);
        if(user == null){
            //return Optional.empty();
            throw new CommonApiException("User not found", HttpStatus.BAD_REQUEST);
        }

        ContactEntity contact = new ContactEntity();
        BeanUtils.copyProperties(request, contact);
        // set user at contact
        contact.setUser(user);
        contact.setId(UUID.randomUUID().toString());

        for(AddressRequest addressRequest: request.getAddress()){
            AddressEntity addressEntity = new AddressEntity();
            // copy property
            BeanUtils.copyProperties(addressRequest, addressEntity);
            addressEntity.setId(UUID.randomUUID().toString());
            // call method yang ada di contact entity
            contact.addAddress(addressEntity);
        }

        try{
            contactRepository.save(contact);
            Response response = new Response(200, "Success", contact);
            return Optional.of(response);
        }catch (Exception e) {
            throw new CommonApiException("Save contact is failed", HttpStatus.INTERNAL_SERVER_ERROR);
            //return Optional.empty();
        }
    }
}
