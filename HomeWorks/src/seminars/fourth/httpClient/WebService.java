package seminars.fourth.httpClient;

public class WebService {

    HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String callGet(String url) {
        return httpClient.get(url);
    }
}
