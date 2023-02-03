package com.quinbay.chatlogin.apis;

import java.util.Map;

public interface AuthenticateInterface {
    Map<String, Object> loginUser( String mobilenum , String password );
}
