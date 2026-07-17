package com.example.library.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.library.exception.BookAlreadyExistsException;
import com.example.library.exception.BookNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public String handleNotFound(BookNotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    public String handleDuplicate(BookAlreadyExistsException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}