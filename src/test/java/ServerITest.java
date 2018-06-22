import com.babich.httpwebserver.Server;
import org.junit.Test;

import java.io.IOException;


public class ServerITest {
    @Test
    public void testServer() throws IOException {
        Server server = new Server();
        server.setPort(3000);
        server.setWebAppPath("src/main/resources/webapp");
        server.start();
    }
}
