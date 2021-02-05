package com.compilermind.service;

import com.compilermind.dto.UserDTO;
import com.compilermind.model.User;
import com.compilermind.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(UserDTO userDTO) throws BeansException{
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return userRepository.save(user);
    }
    @Override
    public User updateUser(UserDTO userDTO) throws BeansException,NotFoundException {
        userRepository.findById(userDTO.getId()).orElseThrow(
                () -> new NotFoundException("User id not found:::"+userDTO.getId()));
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {

         userRepository.deleteById(id);
    }

    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User findUser(Long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User id not found:::"+id)
        );
    }
}
