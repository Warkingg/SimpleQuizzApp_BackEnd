package com.example.quizztest.service.user;

import com.example.quizztest.model.VerificationToken;

public interface IVerificationTokenService {
    VerificationToken findByToken(String token);

    void save(VerificationToken token);
}
