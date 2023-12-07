package com.dsp.restapi.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_users")
public class UserEntity {
    @Id
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @Column(name = "username", length = 100, nullable = false)
    private String username;
    @Column(name = "email", length = 100, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "token")
    private String token;
    @Column(name = "token_expired")
    private BigInteger tokenExpired;
}
