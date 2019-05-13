package com.marcskow.inheritance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(profiles = "test")
public class BookDAOTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private InhBookRepository inhBookRepository;

    private BookDAO bookDAO;

    @Before
    public void setUp() {
        bookDAO = new BookDAO(entityManager);
    }

    @Test
    public void insertBook() {
        InhBook inhBook = new InhBook();
        inhBook.setPublishingDate(new Date());
        inhBook.setTitle("Nowa ksiazka");
        inhBook.setVersion(3);
        inhBook.setPages(55);

        inhBookRepository.save(inhBook);

        bookDAO.getAllBooks().forEach(System.out::println);

        assertEquals(1, bookDAO.getAllBooks().size());
    }

    @Test
    public void getAllBooks() {
        // when
        List<InhBook> allBooks = bookDAO.getAllBooks();

        // then
        assertEquals(allBooks.size(), 0);
    }
}
