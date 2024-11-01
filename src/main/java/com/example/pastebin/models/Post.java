package com.example.pastebin.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column(name = "content_url")
    private String contentUrl;

    @Column(name = "title")
    private String title;


    @Column(name = "date_of_publication")
    private LocalDateTime dateOfPublication;
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "category")
    public String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public LocalDateTime getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDateTime dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Post{" +
                "contentUrl='" + contentUrl + '\'' +
                ", title='" + title + '\'' +
                ", dateOfPublication=" + dateOfPublication +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
