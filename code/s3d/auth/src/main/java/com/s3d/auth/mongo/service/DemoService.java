package com.s3d.auth.mongo.service;


import com.s3d.auth.mongo.entity.Book;

import java.util.List;

/**
 * @author Wind.Chen
 * @since 2015/6/30.
 */
public interface DemoService {

    public void save(Book book);
    public void saveByDocument(Book book);
    public void saveByJson(String dataInJson);

    public void saveManyByOriginObjects(List<Book> bookList);
    public void saveManyByDocuments(List<Book> bookList);
    public void saveManyByJson(List<String> demoList);

    public List<Book> findAll();
    public List<Book> find(String name, String length);
    public List<Book> findByNameAndLength(String name, String length);

}
