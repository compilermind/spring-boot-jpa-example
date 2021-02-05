package com.compilermind.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class UserDTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
}
