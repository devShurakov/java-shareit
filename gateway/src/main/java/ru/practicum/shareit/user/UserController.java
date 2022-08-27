package ru.practicum.shareit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@Validated
@RequestMapping(value = "/users")
public class UserController {

    private final UserClient userClient;

    @Autowired
    public UserController(UserClient userClient) {

        this.userClient = userClient;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid UserDto userDto) {

        return userClient.create(userDto);
    }

    @PatchMapping(value = "/{userId}")
    public ResponseEntity<Object>  update(@PathVariable int userId,
                          @RequestBody UserDto userDto) {

        return userClient.update((long) userId, userDto);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<Object>  getUser(@PathVariable int userId) {

        return userClient.getDtoUser(userId);
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {

        return userClient.getAllUsers();
    }


    @DeleteMapping(value = "/{userId}")
    public void delete(@PathVariable long userId) {

        userClient.delete(userId);
    }

}
