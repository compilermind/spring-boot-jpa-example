package com.compilermind.controller;


import com.compilermind.dto.ResponseDTO;
import com.compilermind.dto.UserDTO;
import com.compilermind.model.User;
import com.compilermind.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/api")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping( value = "/user")
    public ResponseEntity<ResponseDTO<?>> add(@RequestBody UserDTO userDTO){
      try {
          User responseUserDTO = userService.addUser(userDTO);
          return ResponseEntity.status(HttpStatus.OK).body(
                  new ResponseDTO(responseUserDTO,HttpStatus.OK.value(), "SUCCESSFUL"));
      }catch (Exception e) {
          return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
                  new ResponseDTO(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value(), "FAILED"));
      }

    }
    @GetMapping( value = "/users")
    public ResponseEntity<ResponseDTO<?>> findAllUsers(){
      try {
          List<User> responseUserDTO = userService.findAllUsers();
          return ResponseEntity.status(HttpStatus.OK).body(
                  new ResponseDTO(responseUserDTO,HttpStatus.OK.value(), "SUCCESSFUL"));
      }catch (Exception e) {
          return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
                  new ResponseDTO(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value(), "FAILED"));
      }

    }
    @GetMapping( value = "/user/{id}")
    public ResponseEntity<ResponseDTO<?>> findById(@PathVariable(value = "id") Long id){
      try {
          User responseUserDTO = userService.findUser(id);
          return ResponseEntity.status(HttpStatus.OK).body(
                  new ResponseDTO(responseUserDTO,HttpStatus.OK.value(), "SUCCESSFUL"));
      }catch (NotFoundException e) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                  new ResponseDTO(e.getMessage(), HttpStatus.NOT_FOUND.value(), "FAILED"));
      }

    }
    @PutMapping( value = "/user")
    public ResponseEntity<ResponseDTO<?>> update(@RequestBody UserDTO userDTO){
        try {
            User responseUserDTO = userService.updateUser(userDTO);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDTO(responseUserDTO,HttpStatus.OK.value(), "SUCCESSFUL"));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
                    new ResponseDTO(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value(), "FAILED"));
        }

    }
    @DeleteMapping( value = "/user/{id}")
    public ResponseEntity<ResponseDTO<?>> deleteUser(@PathVariable(value = "id") Long id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDTO("User successfully deleted",HttpStatus.OK.value(), "SUCCESSFUL"));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
                    new ResponseDTO(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value(), "FAILED"));
        }

    }
}
