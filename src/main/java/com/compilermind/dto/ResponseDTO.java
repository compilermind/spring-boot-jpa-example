package com.compilermind.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created by compilermind on 22/12/2020.
 */
@Getter
@Setter
public class ResponseDTO<T> implements Serializable {

    private T response;
    private int statusCode;
    private String resultStatus;

    public ResponseDTO(T response, int statusCode, String resultStatus) {
        this.response = response;
        this.statusCode = statusCode;
        this.resultStatus = resultStatus;
    }
}
