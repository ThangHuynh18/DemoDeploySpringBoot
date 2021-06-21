package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.domain.User;
import com.ecommerce.ecommerceapi.exceptions.EtAuthException;

public interface UserService {
    User validateUser(String email, String password) throws EtAuthException;
    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
