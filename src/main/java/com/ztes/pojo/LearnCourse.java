package com.ztes.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "learn_course")
public class LearnCourse implements Serializable{

    private static final long serialVersionUID = -5267677469642240915L;

    @Id
    @Column(name="id")
    private int id;
    @Column(name="author")
    private String author;
    @Column(name="title")
    private String title;
    @Column(name="url")
    private String url;

    public LearnCourse() {
    }

    public LearnCourse(String author, String title, String url) {
        this.author = author;
        this.title = title;
        this.url = url;
    }

    public LearnCourse(int id, String author, String title, String url) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    @Override
    public String toString() {
        return "LearnCourse{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}