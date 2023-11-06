package com.TaskBox.TaskBox.exception;

import com.TaskBox.TaskBox.entity.TaskEntity;
import org.springframework.beans.MethodInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
@ControllerAdvice
public class GlobalCustomizeEceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private Response response;


//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    public ResponseEntity<Object> exceptionHandler(MethodArgumentNotValidException e){
//        List<String> defalutMessage = e.getBindingResult().getFieldErrors().stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
//        String errorMessage = String.join(",", defalutMessage);
//
//        // customizing the response for the application i.e. Error Code / Status / Error Message.
//        response.setStatusCode("400");
//        response.setErrorCode(" Status : Falied");
//        response.setErrorMessage(errorMessage);
//        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
//    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            if (error instanceof FieldError) {
                String message = error.getDefaultMessage();
                errors.add(message);
            }
        });
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }

}
