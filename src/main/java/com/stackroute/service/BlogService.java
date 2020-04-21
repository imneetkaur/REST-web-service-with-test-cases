package com.stackroute.service;
import com.stackroute.domain.Blog;
import java.util.List;

public interface BlogService {
    public Blog saveBlog(Blog blog);
    public List<Blog> getAllBlogs();
    public Blog deleteBlog(int id);
   public Blog updateBlog(Blog blog);
}
