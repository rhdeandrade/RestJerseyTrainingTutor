package com.mastercard;

import com.mastercard.service.UserService;

import javax.ws.rs.Path;

/**
 * Created by e068806 on 7/3/2017.
 */
@Path("users")
public class UserResource {
    UserService userService = UserService.getInstance();
}
