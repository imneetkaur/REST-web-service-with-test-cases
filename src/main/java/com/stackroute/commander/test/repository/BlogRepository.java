package com.stackroute.commander.test.repository;

import com.stackroute.domain.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Blog,Integer>{
}
