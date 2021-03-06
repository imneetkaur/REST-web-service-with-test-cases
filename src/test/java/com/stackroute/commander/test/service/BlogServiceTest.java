package com.stackroute.commander.test.service;

import com.stackroute.domain.Blog;

import com.stackroute.repository.BlogRepository;
import com.stackroute.service.BlogServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BlogServiceTest {
    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogServiceImpl blogService;
    private Blog blog;
    private List<Blog> blogList;
    private Optional optional;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        blog = new Blog(1, "SampleBlog", "Imneet", "SampleBlogforTesting");
        optional = Optional.of(blog);
    }

    @AfterEach
    public void tearDown() {
        blog = null;
    }

    @Test
    void saveBlog() {
        when(blogRepository.save(any())).thenReturn(blog);
        assertEquals(blog, blogService.saveBlog(blog));
        verify(blogRepository, times(1)).save(any());
    }

    @Test
    void getAllBlogs() {
        blogRepository.save(blog);
        //stubbing the mock to return specific data
        when(blogRepository.findAll()).thenReturn(blogList);
        List<Blog> blogList1 = blogService.getAllBlogs();
        assertEquals(blogList, blogList1);
        verify(blogRepository, times(1)).save(blog);
        verify(blogRepository, times(1)).findAll();
    }

    @Test
    void deleteBlog() {
        when(blogRepository.findById(blog.getBlogId())).thenReturn(optional);
        Blog deletedBlog = blogService.deleteBlog(1);
        assertEquals(1, deletedBlog.getBlogId());

        verify(blogRepository, times(2)).findById(blog.getBlogId());
        verify(blogRepository, times(1)).deleteById(blog.getBlogId());
    }

    @Test
    void deleteBlogFailure() {
        when(blogRepository.findById(blog.getBlogId())).thenReturn(Optional.empty());
        Blog deletedBlog = blogService.deleteBlog(1);
        verify(blogRepository, times(1)).findById(blog.getBlogId());
        //verify(blogRepository, times(1)).deleteById(blog.getBlogId());
    }

    @Test
    void updateBlog() {
        when(blogRepository.findById(blog.getBlogId())).thenReturn(optional);
        when(blogRepository.save(blog)).thenReturn(blog);
        blog.setBlogContent("SampleBlogforTesting");
        Blog blog1 = blogService.updateBlog(blog);
        assertEquals(blog1.getBlogContent(),"SampleBlogforTesting");
        verify(blogRepository, times(1)).save(blog);
        verify(blogRepository, times(2)).findById(blog.getBlogId());
    }
}