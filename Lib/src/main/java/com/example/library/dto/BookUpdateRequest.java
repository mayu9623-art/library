package com.example.library.dto;

import java.time.LocalDate;

public record BookUpdateRequest(
        String isbn,
        String title,
        String author,
        LocalDate publishedDate
) {
}