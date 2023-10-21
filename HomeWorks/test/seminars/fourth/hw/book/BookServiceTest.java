package seminars.fourth.hw.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;
import seminars.fourth.book.InMemoryBookRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class BookServiceTest {

    Book testBook;
    Book[] testBooksArray;

    @BeforeEach
    void setUp() {
        testBook = new Book("001", "Test Book", "Test Author");
        testBooksArray = new Book[]{
                new Book("123"),
                new Book("124"),
                new Book("125")
        };

    }

    @Test
    void testBookRepositoryInterface() {
        String testBookId = "123";

        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findById(testBookId)).thenReturn(new Book(testBookId));
        when(bookRepository.findAll()).thenReturn(Arrays.asList(testBooksArray));

        List<Book> allBooks = bookRepository.findAll();
        verify(bookRepository, times(1)).findAll();
        assertThat(allBooks)
                .isNotEmpty()
                .isEqualTo(Arrays.asList(testBooksArray));

        bookRepository.findById("123");
        verify(bookRepository, times(1)).findById(anyString());
    }


    @Test
    void testBookServiceFindAllBooks() {
        BookRepository mockBookRepository = mock(BookRepository.class);
        when(mockBookRepository.findAll()).thenReturn(Arrays.asList(testBooksArray));
        BookService bookService = new BookService(mockBookRepository);

        List<Book> actual = bookService.findAllBooks();

        verify(mockBookRepository, times(1)).findAll();
        assertEquals(Arrays.asList(testBooksArray), actual);
    }

    @Test
    void testBookServiceFindBookById() {
        BookRepository mockBookRepository = mock(BookRepository.class);
        when(mockBookRepository.findById("001")).thenReturn(testBook);
        BookService bookService = new BookService(mockBookRepository);

        Book actual = bookService.findBookById("001");

        verify(mockBookRepository, times(1)).findById("001");
        assertEquals(testBook, actual);
    }

    @Test
    void testBookServiceFindBookByIdFail() {
        BookRepository mockBookRepository = mock(BookRepository.class);
        when(mockBookRepository.findById(anyString())).thenReturn(null);
        BookService bookService = new BookService(mockBookRepository);

        Book actual = bookService.findBookById("no such book");

        verify(mockBookRepository, times(1)).findById("no such book");
        assertThat(actual).isNull();
    }



    @Test
    void testInMemoryBookRepositoryFindById() {
        InMemoryBookRepository imBookRepository = new InMemoryBookRepository();
        Book actual = imBookRepository.findById("1");
        assertThat(actual).isNotNull();
        assertEquals("1", actual.getId());
    }

    @Test
    void testInMemoryBookRepositoryFindByIdFail() {
        InMemoryBookRepository imBookRepository = new InMemoryBookRepository();
        Book actual = imBookRepository.findById("-1");
        assertThat(actual).isNull();
    }

    @Test
    void testInMemoryBookRepositoryFindAll() {
        InMemoryBookRepository imBookRepository = new InMemoryBookRepository();
        List<Book> actual = imBookRepository.findAll();
        assertThat(actual).isNotNull().hasSize(2);
    }

    @Test
    void testBookGetId() {
        String expected = "001";
        assertEquals(expected, testBook.getId());
    }

    @Test
    void testBookSetId() {
        String previous = "001";
        assertEquals(previous, testBook.getId());

        testBook.setId("100");
        assertEquals("100", testBook.getId());
    }

    @Test
    void testBookGetTitle() {
        String expected = "Test Book";
        assertEquals(expected, testBook.getTitle());
    }

    @Test
    void testBookSetTitle() {
        String previous = "Test Book";
        assertEquals(previous, testBook.getTitle());

        testBook.setTitle("Other Book");
        assertEquals("Other Book", testBook.getTitle());
    }

    @Test
    void testBookGetAuthor() {
        String expected = "Test Author";
        assertEquals(expected, testBook.getAuthor());
    }

    @Test
    void testBookSetAuthor() {
        String previous = "Test Author";
        assertEquals(previous, testBook.getAuthor());

        testBook.setAuthor("Other Author");
        assertEquals("Other Author", testBook.getAuthor());
    }

}