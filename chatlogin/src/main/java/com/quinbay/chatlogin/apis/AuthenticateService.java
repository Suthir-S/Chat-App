package com.quinbay.chatlogin.apis;

import com.quinbay.chatlogin.model.Authenticate;

import java.util.Map;

public interface AuthenticateService {
    Object loginUser(Authenticate user);
}
