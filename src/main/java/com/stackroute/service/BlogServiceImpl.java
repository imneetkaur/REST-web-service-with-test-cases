package com.stackroute.service;

import com.stackroute.domain.Blog;

import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        Blog savedBlog = blogRepository.save(blog);
        return savedBlog;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog deleteBlog(int id) {

        Blog blog = null;
        Optional optional = blogRepository.findById(id);
        if (optional.isPresent()) {
            blog = blogRepository.findById(id).get();
            blogRepository.deleteById(id);
        }
        return blog;
    }

    public Blog updateBlog(Blog blog) {
        Blog updatedBlog = null;
        Optional optional = blogRepository.findById(blog.getBlogId());
        if (optional.isPresent()) {
            Blog getBlog = blogRepository.findById(blog.getBlogId()).get();
            getBlog.setBlogContent(blog.getBlogContent());
            updatedBlog = saveBlog(getBlog);
            System.out.println(updatedBlog);
        }
        return updatedBlog;
    }
}

