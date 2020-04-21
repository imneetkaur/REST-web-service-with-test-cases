package com.stackroute.commander.test.repository;

import com.stackroute.domain.Blog;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BlogRepositoryTest {

    @Autowired
    private BlogRepository blogRepository;
    private Blog blog;

    @BeforeEach
    void setUp() {
        blog = new Blog();
        blog.setBlogId(1);
        blog.setBlogTitle("Blog1");
        blog.setAuthorName("Imneet");
        blog.setBlogContent("Sample content");
        }


    @AfterEach
    void tearDown() {
    blogRepository.deleteAll();
    blog = null;
    }

    @Test
    void saveBlog(){
        blogRepository.save(blog);
        Blog fetchedBlog = blogRepository.findById(blog.getBlogId()).get();
        assertEquals(1, fetchedBlog.getBlogId());
}


}