package com.example.library.service;

import java.util.List;

import com.example.library.dto.BookCreateRequest;
import com.example.library.dto.BookDto;
import com.example.library.dto.BookUpdateRequest;

public interface BookService {

    BookDto findById(Long id);

    List<BookDto> findAll();

     List<BookDto> searchBooks(String isbn, String title, String author);

    BookDto create(BookCreateRequest request);

    BookDto update(Long id, BookUpdateRequest request);

    void delete(Long id);
}
