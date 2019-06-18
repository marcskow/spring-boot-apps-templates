package com.marcskow.spring.bootstrap.tests.mocked;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQueries({
        @NamedQuery(
                name = Config.Q.findAllConfigs,
                query = "SELECT new com.marcskow.spring.bootstrap.tests.mocked.ConfigDto(c.id, c.name, c.department.name) "
                        + "FROM Config c"
        )
})
@Getter
@Setter
@Entity
@Table(name = "configs")
public class Config {

    public static class Q {
        public static final String findAllConfigs = "Config.findAllConfigs";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
