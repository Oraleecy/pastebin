package com.example.pastebin.repositories;

import com.example.pastebin.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
    Post findByContentUrl(String contentUrl);
}
