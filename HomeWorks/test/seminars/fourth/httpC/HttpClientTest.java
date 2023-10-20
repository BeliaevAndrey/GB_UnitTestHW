package seminars.fourth.httpC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class HttpClientTest {

    @Test
    void testHttpClientGet() {
        String expected = "some site";
        HttpClient hc = mock(HttpClient.class);
        WebService ws = new WebService(hc);
        when(hc.get(anyString())).thenReturn("some site");

        String result = ws.callGet(anyString());

        verify(hc, times(1)).get(anyString());
        assertEquals(expected, result);
    }
}