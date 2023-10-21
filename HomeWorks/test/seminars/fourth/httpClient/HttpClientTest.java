package seminars.fourth.httpClient;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class HttpClientTest {

    @Test
    void testHttpClientGet() {
        String expected = "some site";
        HttpClient mockHttpClient = mock(HttpClient.class);
        WebService webService = new WebService(mockHttpClient);
        when(mockHttpClient.get(anyString())).thenReturn("some site");

        String result = webService.callGet(anyString());

        verify(mockHttpClient, times(1)).get(anyString());
        assertEquals(expected, result);
    }
}