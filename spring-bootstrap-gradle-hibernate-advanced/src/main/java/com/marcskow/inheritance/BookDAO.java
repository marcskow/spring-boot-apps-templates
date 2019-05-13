package com.marcskow.inheritance;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@AllArgsConstructor
@Repository
public class BookDAO {

    private EntityManager em;

    public List<InhBook> getAllBooks() {
        return em.createQuery("SELECT b FROM InhBook b", InhBook.class).getResultList();
    }
}
