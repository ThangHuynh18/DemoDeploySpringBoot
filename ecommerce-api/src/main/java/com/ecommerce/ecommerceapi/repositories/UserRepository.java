package com.ecommerce.ecommerceapi.repositories;

import com.ecommerce.ecommerceapi.domain.User;
import com.ecommerce.ecommerceapi.exceptions.EtAuthException;

public interface UserRepository {
    Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;
    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
