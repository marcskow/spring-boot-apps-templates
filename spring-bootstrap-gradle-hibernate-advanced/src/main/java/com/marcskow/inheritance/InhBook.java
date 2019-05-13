package com.marcskow.inheritance;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@ToString
@Entity(name = "InhBook")
public class InhBook extends Publication {

    @Column
    private int pages;

}
