import org.junit.Assert;
import org.junit.Test;
import webserver.HttpRequest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HttpRequestTest {
    private String testDirectory = "./src/test/resources/";

    @Test
    public void request_GET() throws FileNotFoundException {
        InputStream in = new FileInputStream(testDirectory + "Http_GET.txt");
        HttpRequest request = new HttpRequest(in);

        Assert.assertEquals("GET",request.getMethod());
        Assert.assertEquals("/user/create",request.getPath());
        Assert.assertEquals("keep-alive",request.getHeader("Connection"));
        Assert.assertEquals("javajigi",request.getParameter("userId"));
    }
}
