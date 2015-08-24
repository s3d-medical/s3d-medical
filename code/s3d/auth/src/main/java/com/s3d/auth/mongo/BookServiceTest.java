package com.s3d.auth.mongo;

import com.s3d.auth.mongo.entity.Author;
import com.s3d.auth.mongo.entity.Book;
import com.s3d.auth.mongo.entity.Location;
import com.s3d.auth.mongo.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by Wind.Chen on 2015/6/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/mongodb/applicationContext-mongodb.xml")
public class BookServiceTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void testSaveByDocument() {
        Book book = this.createOneDemo("chenzhigang" + System.currentTimeMillis(),
                System.currentTimeMillis(), "作者" + System.currentTimeMillis(), "上海" + System.currentTimeMillis());
        this.demoService.saveByDocument(book);
    }

    @Test
    public void testSave() {
        Book book = this.createOneDemo("wind.chen" + System.currentTimeMillis(),
                System.currentTimeMillis(), "author" + System.currentTimeMillis(), "苏州");
        this.demoService.save(book);
    }

    private Book createOneDemo(String name, Long length, String authorName,
                               String authorAddress) {
        return this.createOneDemo(name, length, authorName, authorAddress, 0.0, 0.0);
    }

    private Book createOneDemo(String name, Long length, String authorName,
                               String city, double longitude, double latitude) {
        Book book = new Book();
        book.setCity(city);
        book.setLength(length.intValue());
        book.setName(name);
        book.setCreatedDate(new Date());

        Location location = new Location();
        location.setType("Point");
        location.getCoordinates().add(longitude);
        location.getCoordinates().add(latitude);
        book.setLocation(location);

        Author author = new Author();
        author.setName(authorName);
        author.setAddress(city);
        book.setAuthor(author);

        return book;
    }

    private List<Book> createManyDemos(String name, Long length, String authorName, String authorAddress, int count) {
        return this.createManyDemos(name, length, authorName, authorAddress, count, 0.0, 0.0);
    }

    private List<Book> createManyDemos(String name, Long length, String authorName,
                                       String city, int count, double longitude, double latitude) {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < count; i++) {
            books.add(this.createOneDemo(name, length, authorName, city,
                    longitude + 0.0001 * i, latitude + 0.0001 * i));
        }
        return books;
    }

    @Test
    public void testSaveMany() {
        List<String> cities = this.getCityList();
        for (String city : cities) {
            String[] cityGeo = this.getCityGeo().get(city);
            List<Book> books = this.createManyDemos("book-" + System.currentTimeMillis(),
                    System.currentTimeMillis(),
                    "author-" + System.currentTimeMillis(),
                    city,
                    40000,
                    new Double(cityGeo[0]),
                    new Double(cityGeo[1]));
            this.demoService.saveManyByOriginObjects(books);
        }
    }

    @Test
    public void testSaveManyByDocuments() {
        List<Book> books = this.createManyDemos("XYZ" + System.currentTimeMillis(),
                System.currentTimeMillis(), "author" + System.currentTimeMillis(), "北京" + System.currentTimeMillis(), 15);
        this.demoService.saveManyByDocuments(books);
    }

    private List<String> getCityList() {
        this.init();
        return cityList;
    }

    public Map<String, String[]> getCityGeo() {
        this.init();
        return cityGeo;
    }

    private void init() {
        if (cityList == null || cityList.size() == 0
                || this.cityGeo == null || this.cityGeo.size() == 0) {
            try {
                InputStream in = this.getClass().getClassLoader().getResourceAsStream("mongodb/city_locations.properties");
                Properties p = new Properties();
                p.load(in);
                Set<Object> keys = p.keySet();
                for (Object key : keys) {
                    this.cityList.add(key.toString());
                    Object value = p.get(key);
                    if (value != null) {
                        cityGeo.put(key.toString(), value.toString().split(","));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private DemoService demoService;

    private List<String> cityList = new ArrayList<String>();

    private Map<String, String[]> cityGeo = new HashMap<String, String[]>();

    @Autowired
    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

}
