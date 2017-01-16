package com.millinch.oauth2.web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@RestController
public class UserApi {

    @GetMapping("/user")
    public Principal userInfo(Principal user) {
        return user;
    }
}
