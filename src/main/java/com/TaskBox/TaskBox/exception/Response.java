package com.TaskBox.TaskBox.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import org.springframework.stereotype.Component;

@Component
@Data
@Schema(name = "ErrorResponse")
public class Response {

    private String statusCode;
    private String errorMessage;
    private String errorCode;

}
