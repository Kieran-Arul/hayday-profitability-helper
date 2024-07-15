package com.kieran.projects.haydayhelper.api.advice;

import com.kieran.projects.haydayhelper.api.exception.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ItemNotFoundHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String itemNotFound(ItemNotFoundException exception) {
        return exception.getMessage();
    }

}
