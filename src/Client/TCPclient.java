package Client;

import Requests.RequestData;
import Requests.ResponseData;
import Sensor.TemperatureDevice;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPclient {
    private int port;
    private String hostname;
    private Socket socket;

    public TCPclient() throws IOException {
        this.port = 4000;
        this.hostname = "127.0.0.1";
        this.socket = new Socket(hostname,port);
    }

    public TCPclient(int port, String hostname) throws IOException {
        this.port = port;
        this.hostname = hostname;
        this.socket = new Socket(hostname,port);
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int sendData(RequestData stringRequest){
        /**
         * From a given Json STRING create the request to send to the SERVER.
         * The return value is the number of sent Bytes.
         * @author: Alessandro Pansera
         * **/
        try {
            OutputStream os = this.socket.getOutputStream();
            byte[] payload = stringRequest.toString().getBytes();
            os.write(payload);
            System.out.println(String.format("Sending... %s",stringRequest.toString()));
            return payload.length;
        }catch (Exception e){
            return 0;
        }

    }
    public int readData(){
        /**
         * From a given Json STRING create the request to send to the SERVER
         * @author: Alessandro Pansera
         * **/
        try {
            Gson gson = new Gson();
            InputStream is = this.socket.getInputStream();
            byte[] payload = new byte[2000];
            int len;
            len = is.read(payload);
            ResponseData response = gson.fromJson(new String(payload,0,len),ResponseData.class);
            System.out.println(String.format("Output code: %s\nStatus: %s\nDescription: %s\nTemperature: %s\n",response.getCode(),response.getStatus(),response.getDescription(), response.getTemperature()));
            return len;
        }catch (Exception e){
            System.out.println("Error: "+e.toString());
            return 0;
        }

    }
}
