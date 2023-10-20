package seminars.fourth.hw.book;

import org.junit.jupiter.api.Test;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.*;

class BookServiceTest {
    @Test
    void testBookService() {
        String testBookId = "123";
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findById(testBookId)).thenReturn(new Book(testBookId));
        when(bookRepository.findAll()).thenReturn(new ArrayList<>(){{
            add(new Book("123"));
            add(new Book("124"));
            add(new Book("125"));
        }});
        bookRepository.findAll();
        verify(bookRepository, times(1)).findAll();
        bookRepository.findById("123");
        verify(bookRepository, times(1)).findById(anyString());


    }
}