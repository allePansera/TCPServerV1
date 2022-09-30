import Server.TCPserver;

import java.io.IOException;

public class EmulateServer {
    public static void main(String[] args) throws IOException {
        TCPserver server = new TCPserver();
        //RUNNING SERVER IN ORDER TO READ DATA
        server.run();
    }
}
