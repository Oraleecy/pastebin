package com.example.pastebin.controllers;


import com.example.pastebin.CloudStorage.CloudStorageManager;
import com.example.pastebin.CloudStorage.ShortUrlGenerator;
import com.example.pastebin.models.Content;
import com.example.pastebin.models.Post;
import com.example.pastebin.repositories.PostRepository;
import com.example.pastebin.repositories.ShortUrlGeneratorSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;



@Controller
class PostController {
    private final PostRepository postRepository;
    private final CloudStorageManager cloudStorageManager;
    private final ShortUrlGenerator shortUrlGenerator;
    private final ShortUrlGeneratorSequenceRepository shortUrlGeneratorSequenceRepository;

    @Autowired
    public PostController(PostRepository postRepository, CloudStorageManager cloudStorageManager,
                          ShortUrlGenerator shortUrlGenerator,
                          ShortUrlGeneratorSequenceRepository shortUrlGeneratorSequenceRepository) {
        this.postRepository = postRepository;
        this.cloudStorageManager = cloudStorageManager;
        this.shortUrlGenerator = shortUrlGenerator;
        this.shortUrlGeneratorSequenceRepository = shortUrlGeneratorSequenceRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        Post post = new Post();
        Content content = new Content();
        model.addAttribute("post", post);
        model.addAttribute("content", content);
        return "index";
    }

    @GetMapping("/favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
        // Этот метод просто возвращает пустое тело ответа, что указывает браузеру, что иконка не предоставляется.
    }
    @PostMapping("/create_paste")
    public String createPost(@ModelAttribute("post") Post post,
                             @ModelAttribute("content") Content content,
//                             @RequestParam("expriationDateOpt") String s,
                             Model model) {
        model.addAttribute("post", post);
        model.addAttribute("content", content);
        long nextValue = shortUrlGeneratorSequenceRepository.getNextValue();
        String url = shortUrlGenerator.generateUrlFromLong(nextValue);
        post.setContentUrl(url);


        LocalDateTime timeNow = LocalDateTime.now();
        post.setDateOfPublication(timeNow);
        cloudStorageManager.writeFile(url, content.getValue());
        postRepository.save(post);
        return "redirect:/" + url;
    }


    @GetMapping("/{generatedUrl}")
    public String showPost(@PathVariable String generatedUrl, Model model) throws IOException {
        model.addAttribute("post", postRepository.findByContentUrl(generatedUrl));
        model.addAttribute("content", cloudStorageManager.readFile(generatedUrl));
        return "post_view";
    }
}

