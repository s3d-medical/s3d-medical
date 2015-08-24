package com.s3d.auth.mongo.service;

import com.s3d.auth.mongo.dao.DemoDao;
import com.s3d.auth.mongo.entity.Author;
import com.s3d.auth.mongo.entity.Book;
import com.s3d.tech.utils.JacksonParser;
import org.bson.Document;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author * Wind.Chen
 * @Date 2015/6/30.
 */
@Service
@Transactional
public class MongoServiceImpl implements DemoService {
    private final String collectionName = "Book";

    @Override
    public void save(Book book) {
        if (book == null) {
            return;
        }
        this.demoDao.insertOneByJson(collectionName, JacksonParser.convertToJSONString(book));
    }

    /**
     * Not flexible.
     *
     * @param book
     */
    @Override
    public void saveByDocument(Book book) {
        if (book == null) {
            return;
        }
        Document doc = this.convertToDocument(book);
        this.demoDao.insertOneByDocument(collectionName, doc);
    }

    private Document convertToDocument(Book book) {
        Document doc = new Document();
        doc.put("name", book.getName());
        doc.put("length", book.getLength());
        doc.put("createdDate", new Date());
        Author author = book.getAuthor();
        if (author != null) {
            Document authorDoc = new Document();
            authorDoc.put("name", author.getName());
            authorDoc.put("address", author.getAddress());
            doc.put("author", authorDoc);
        } else {
            doc.put("author", null);
        }
        return doc;
    }

    @Override
    public void saveByJson(String dataInJson) {
        this.demoDao.insertOneByJson(collectionName, dataInJson);
    }

    @Override
    public void saveManyByDocuments(List<Book> bookList) {
        if (CollectionUtils.isEmpty(bookList)) {
            return;
        }
        List<Document> docs = new ArrayList<Document>();
        for (Book book : bookList) {
            docs.add(this.convertToDocument(book));
        }
        this.demoDao.insertManyByDocument(this.collectionName, docs);
    }

    @Override
    public void saveManyByOriginObjects(List<Book> bookList) {
        if(CollectionUtils.isEmpty(bookList)){
            return ;
        }
        List<Object> docs = new ArrayList<Object>();
        docs.addAll(bookList);
        this.demoDao.insertManyByObject(this.collectionName, docs);
    }

    @Override
    public void saveManyByJson(List<String> demoList) {
        if(CollectionUtils.isEmpty(demoList)){
            return ;
        }
        this.demoDao.insertManyByJson(this.collectionName, demoList);
    }

    @Override
    public List<Book> findAll() {

        return null;
    }

    @Override
    public List<Book> find(String name, String length) {
        return null;
    }

    @Override
    public List<Book> findByNameAndLength(String name, String length) {
        return null;
    }

    @Resource
    private DemoDao demoDao;

}
