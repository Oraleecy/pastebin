package com.example.pastebin.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;
//    @OneToMany(mappedBy = "user")
//    private Set<Post> posts;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Set<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(Set<Post> posts) {
//        this.posts = posts;
//    }
}
