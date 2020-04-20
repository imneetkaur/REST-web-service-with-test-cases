package com.stackroute.controller;

import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> saveBlog(@RequestBody Blog blog) {
        ResponseEntity responseEntity;
        blogService.saveBlog(blog);
        responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlogs() {
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity<List<Blog>>((List<Blog>) blogService.getAllBlogs(), HttpStatus.FOUND);
        return responseEntity;
    }
}
