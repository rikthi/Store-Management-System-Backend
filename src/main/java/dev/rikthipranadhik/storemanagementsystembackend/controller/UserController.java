package dev.rikthipranadhik.storemanagementsystembackend.controller;


import dev.rikthipranadhik.storemanagementsystembackend.dto.user.UserDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.user.User;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.user.UserMapper;
import dev.rikthipranadhik.storemanagementsystembackend.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(path="/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public  UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        if(userDTO.email().isEmpty() || userDTO.password().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
         User user = userService.createUser(userMapper.fromDTO(userDTO), userDTO.employeeId());
        return ResponseEntity.ok(user);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<User> getUser(@PathVariable("employeeId") Integer employeeId) {
        return ResponseEntity.ok(userService.getUserByEmployeeId(employeeId));
    }
}
