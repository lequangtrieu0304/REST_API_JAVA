package com.quangtrieu.restapi.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorMessage {
    private Date timeStamp;
    private int statusCode;
    private String error;
    private String message;
}
