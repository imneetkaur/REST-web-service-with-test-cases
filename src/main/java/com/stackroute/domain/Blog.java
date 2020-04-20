package com.stackroute.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Blog {
    @Id
    private int blogId;
    private String blogTitle;
    private String authorName;
    private String blogContent;
}
