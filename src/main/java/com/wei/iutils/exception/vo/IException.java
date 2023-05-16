package com.wei.iutils.exception.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
public class IException extends RuntimeException{

    private String message;

    private HashMap<String,Object> params;

    public IException(String message) {
        super(message);
        this.message = message;
    }
}
