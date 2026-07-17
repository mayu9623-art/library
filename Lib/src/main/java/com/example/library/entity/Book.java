package com.example.library.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 図書エンティティ
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    /**
     * 図書ID
     */
    private Long id;

    /**
     * ISBN
     */
    private String isbn;

    /**
     * 書籍タイトル
     */
    private String title;

    /**
     * 著者
     */
    private String author;

    /**
     * 出版日
     */
    private LocalDate publishedDate;
}