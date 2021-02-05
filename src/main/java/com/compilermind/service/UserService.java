package com.compilermind.service;

import com.compilermind.dto.UserDTO;
import com.compilermind.model.User;
import javassist.NotFoundException;
import org.springframework.beans.BeansException;

import java.util.List;



public interface UserService {

    public User addUser(UserDTO userDTO) throws BeansException;

    public User updateUser(UserDTO userDTO) throws NotFoundException, BeansException;

    public void deleteUser(Long id);

    public List<User> findAllUsers();

    public User findUser(Long id) throws NotFoundException;
}
