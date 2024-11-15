package ee.ivkhkdev.apphelpers;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Author;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

public class AuthorAppHelperTest {

    private AuthorAppHelper authorAppHelper;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        authorAppHelper = new AuthorAppHelper();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCreate() {
        // Мокируем методы ввода
        AuthorAppHelper spyHelper = Mockito.spy(authorAppHelper);
        doReturn("ИмяТест","ФамилияТест").when(spyHelper).getString();

        Author author = spyHelper.create();

        assertNotNull(author);
        assertEquals("ИмяТест", author.getAuthorName());
        assertEquals("ФамилияТест", author.getAuthorSurname());
    }
    @Test
    public void testUpdateSuccessfull(){
        Input mockedInput = Mockito.mock(Input.class);
        authorAppHelper = new AuthorAppHelper() {
            @Override
            public String getString() {
                return mockedInput.getString();
            }
        };
        Mockito.when(mockedInput.getString()).thenReturn("1","y", "NewName","y","NewSurname");
        List<Author> authors = List.of(new Author("Lev","Tolstoy"));
        List<Author> modifedAuthors = authorAppHelper.update(authors);
        assertEquals("NewName", modifedAuthors.get(0).getAuthorName());
        assertEquals("NewSurname", modifedAuthors.get(0).getAuthorSurname());
    }
    @Test
    void testUpdate_NameNotChanged() {
        Input mockedInput = Mockito.mock(Input.class);
        authorAppHelper = new AuthorAppHelper() {
            @Override
            public String getString() {
                return mockedInput.getString();
            }
        };
        Mockito.when(mockedInput.getString()).thenReturn("1","n","y","Trotsky");
        List<Author> authors = List.of(new Author("Lev","Tolstoy"));
        List<Author> modifedAuthors = authorAppHelper.update(authors);
        assertEquals("Lev", modifedAuthors.get(0).getAuthorName());
        assertEquals("Trotsky", modifedAuthors.get(0).getAuthorSurname());
    }
    @Test
    void testUpdate_InvalidInputAuthor() {
        Input mockedInput = Mockito.mock(Input.class);
        authorAppHelper = new AuthorAppHelper() {
            @Override
            public String getString() {
                return mockedInput.getString();
            }
        };
        Mockito.when(mockedInput.getString()).thenReturn("2","y","НовоеИмя","y","Trotsky");
        List<Author> authors = List.of(new Author("Lev","Tolstoy"));
        List<Author> modifedAuthors = authorAppHelper.update(authors);
        assertNull(modifedAuthors);

    }

    @Test
    public void testPrintList() {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Имя1", "Фамилия1"));
        authors.add(new Author("Имя2", "Фамилия2"));

        authorAppHelper.printList(authors);

        String expectedOutput1 = "1. Имя1 Фамилия1";
        String expectedOutput2 = "2. Имя2 Фамилия2";

        assertTrue(outContent.toString().contains(expectedOutput1));
        assertTrue(outContent.toString().contains(expectedOutput2));
    }

    @Test
    public void testCreateHandlesError() {
        // Мокируем, чтобы getString выбрасывал исключение
        AuthorAppHelper spyHelper = Mockito.spy(authorAppHelper);
        doThrow(new RuntimeException("Test exception")).when(spyHelper).getString();

        Author author = spyHelper.create();

        assertNull(author);
        assertTrue(outContent.toString().contains("Error: Test exception"));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        outContent.reset();
    }
}
