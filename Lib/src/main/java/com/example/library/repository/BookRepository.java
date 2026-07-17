package com.example.library.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.library.entity.Book;

/**
 * 図書Repository
 */
@Mapper
public interface BookRepository {

    /**
     * 全件取得
     *
     * @return 図書一覧
     */
    List<Book> findAll();

    /**
     * ID検索
     *
     * @param id 図書ID
     * @return 図書
     */
    Book findById(Long id);

    /**
     * ISBN検索
     *
     * @param isbn ISBN
     * @return 図書
     */
    Book findByIsbn(String isbn);

    /**
     * 登録
     *
     * @param book 図書
     * @return 登録件数
     */
    int insert(Book book);

    /**
     * 更新
     *
     * @param book 図書
     * @return 更新件数
     */
    int update(Book book);

    /**
     * 削除
     *
     * @param id 図書ID
     * @return 削除件数
     */
    int delete(Long id);
}