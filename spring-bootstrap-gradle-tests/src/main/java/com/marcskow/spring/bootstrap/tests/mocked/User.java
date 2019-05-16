package com.marcskow.spring.bootstrap.tests.mocked;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
        @NamedQuery(
                name = User.Q.findUserByName,
                query = "SELECT u FROM User u WHERE u.name = :name"
        )
})
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    public static class Q {
        public static final String findUserByName = "User.findUserByName";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "full_name", unique = true, length = 128, nullable = false)
    private String name;
}
