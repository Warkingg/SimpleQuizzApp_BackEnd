package com.example.quizztest.service.user;

import com.example.quizztest.model.Role;
import com.example.quizztest.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
