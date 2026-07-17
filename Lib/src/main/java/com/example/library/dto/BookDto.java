package com.example.library.dto;

import java.time.LocalDate;

public record BookDto(
        Long id,
        String isbn,
        String title,
        String author,
        LocalDate publishedDate
) {
}
