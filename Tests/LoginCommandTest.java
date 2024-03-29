import Mail.Command;
import Mail.LoginRequest;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class LoginCommandTest {

    @Test
    public void parsePacket1() throws IOException, InterruptedException {
        String username = "Melina";
        String password = "1234";

        String s = LoginRequest.createPacket(username, password);

        InputStream stream = new ByteArrayInputStream(s.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));

        LoginRequest c = (LoginRequest) Command.parse(br);

        assertEquals(c.getUsername(), username);
        assertEquals(c.getPassword(), password);

    }
}