package com.example.library.dto;

import java.time.LocalDate;

public record BookCreateRequest(
        String isbn,
        String title,
        String author,
        LocalDate publishedDate
) {
}