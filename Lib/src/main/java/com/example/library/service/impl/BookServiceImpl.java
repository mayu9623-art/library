package com.example.library.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.dto.BookCreateRequest;
import com.example.library.dto.BookDto;
import com.example.library.dto.BookUpdateRequest;
import com.example.library.entity.Book;
import com.example.library.exception.BookAlreadyExistsException;
import com.example.library.exception.BookNotFoundException;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
public List<BookDto> searchBooks(String isbn, String title, String author) {
    return bookRepository.search(isbn, title, author)
            .stream()
            .map(this::toDto)
            .toList();
}

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id);

        if (book == null) {
            throw new BookNotFoundException(id);
        }

        return toDto(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    @Transactional
    public BookDto create(BookCreateRequest request) {

        Book exists = bookRepository.findByIsbn(request.isbn());
        if (exists != null) {
            throw new BookAlreadyExistsException(request.isbn());
        }

        Book book = new Book();
        book.setIsbn(request.isbn());
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setPublishedDate(request.publishedDate());

        bookRepository.insert(book);

        return toDto(book);
    }

    @Override
    @Transactional
    public BookDto update(Long id, BookUpdateRequest request) {

        Book book = bookRepository.findById(id);

        if (book == null) {
            throw new BookNotFoundException(id);
        }

        Book duplicate = bookRepository.findByIsbn(request.isbn());
        if (duplicate != null && !duplicate.getId().equals(id)) {
            throw new BookAlreadyExistsException(request.isbn());
        }

        book.setIsbn(request.isbn());
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setPublishedDate(request.publishedDate());

        bookRepository.update(book);

        return toDto(book);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Book book = bookRepository.findById(id);

        if (book == null) {
            throw new BookNotFoundException(id);
        }

        bookRepository.delete(id);
    }

    private BookDto toDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublishedDate()
        );
    }
}
