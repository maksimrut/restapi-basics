package com.epam.esm.controller;

import com.epam.esm.exception.CustomError;
import com.epam.esm.exception.CustomNotFoundException;
import com.epam.esm.exception.ResourceDuplicateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The type Exception controller.
 */
@RestControllerAdvice
public class ExceptionController {

    /**
     * Internal error custom error.
     *
     * @param e the exception
     * @return the custom error
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomError internalError(Exception e) {
        return new CustomError(50001, "Error happened. The problem is on solving stage." + e.getMessage());
    }

    /**
     * Not found custom error.
     *
     * @param e the exception
     * @return the custom error
     */
    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomError notFound(CustomNotFoundException e) {
        return new CustomError(40401, e.getMessage());
    }

    /**
     * Bad request custom error.
     *
     * @param e the exception
     * @return the custom error
     */
    @ExceptionHandler(ResourceDuplicateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomError badRequest(ResourceDuplicateException e) {
        return new CustomError(40001, String.format(
                "The resource with %s %s already exists", e.getUniqueField(), e.getUniqueFieldValue()));
    }
}
