package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.user.AddUserRequest;
import com.etiya.ecommercedemo4.business.dtos.response.user.AddUserResponse;
import com.etiya.ecommercedemo4.entities.concretes.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    AddUserResponse add(AddUserRequest addUserRequest);

    User getById(int id);
}
