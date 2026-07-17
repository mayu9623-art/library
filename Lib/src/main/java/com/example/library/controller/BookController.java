package com.example.library.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.library.dto.BookCreateRequest;
import com.example.library.dto.BookUpdateRequest;
import com.example.library.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("book", new BookCreateRequest(
                "", "", "", null));
        return "books/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("book") BookCreateRequest request) {
        bookService.create(request);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        var book = bookService.findById(id);

        model.addAttribute("book", new BookUpdateRequest(
                book.isbn(),
                book.title(),
                book.author(),
                book.publishedDate()
        ));

        model.addAttribute("bookId", id);

        return "books/form";
    }

    @PostMapping("/{id}")
    public String update(
            @PathVariable Long id,
            @Valid @ModelAttribute("book") BookUpdateRequest request) {

        bookService.update(id, request);
        return "redirect:/books";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}