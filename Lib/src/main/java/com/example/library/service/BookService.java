package com.example.library.service;

import java.util.List;

import com.example.library.dto.BookCreateRequest;
import com.example.library.dto.BookDto;
import com.example.library.dto.BookUpdateRequest;

public interface BookService {

    BookDto findById(Long id);

    List<BookDto> findAll();

    BookDto create(BookCreateRequest request);

    BookDto update(Long id, BookUpdateRequest request);

    void delete(Long id);
}