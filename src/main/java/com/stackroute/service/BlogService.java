package com.stackroute.service;
import com.stackroute.domain.Blog;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BlogService {
    public Blog saveBlog(Blog blog);
    public List<Blog> getAllBlogs();
    public Blog deleteBlog(int id);
//    public Blog updateBlog(int id);
}
