package com.jbrkan.lowflightcostapp.Controllers;

import com.jbrkan.lowflightcostapp.Exceptions.TokenNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value
            = {TokenNotFoundException.class})
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    protected ResponseEntity<Object> handleConflict(
            TokenNotFoundException ex, WebRequest request) {
        String string = "Token not found";
        return handleExceptionInternal(ex,string,new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }
}
