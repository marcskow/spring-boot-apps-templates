package com.marcskow.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "InhBlogPost")
public class InhBlogPost extends Publication {

    @Column
    private String url;

}
