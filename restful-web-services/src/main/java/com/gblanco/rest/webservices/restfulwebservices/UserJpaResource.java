package com.gblanco.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/jpa/users")
@RestController
public class UserJpaResource {
    private UserDaoService service;

    public UserJpaResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/get/{id}")
    public User findUser(@PathVariable Integer id){
        if (id == 10) throw new UserNotFoundException("User not found");
        return new User(1, "gustavo");
    }

    @PostMapping("/store")
    public void storeUser(
            @Valid
            @RequestBody User user){
        System.out.println("PASANDO ");
    }
}
