package com.dsp.restapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String companyName;
    private String phone;
    private List<AddressRequest> address;
}
