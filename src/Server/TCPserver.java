package Server;

import Requests.Payload;
import Requests.RequestData;
import Requests.ResponseData;
import Sensor.TemperatureDevice;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPserver{
    private int port;
    private ServerSocket serverSocket;
    private Socket socket;

    public TCPserver() throws IOException {
        this.port = 4000;
        this.serverSocket = new ServerSocket(this.port);
    }

    public TCPserver(int port) throws IOException{
        this.port = port;
        this.serverSocket = new ServerSocket(this.port);
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void serveRequest(Socket socket){
        /**
         * This method serves, server side, each client request WITHOUT echo mode.
         * @author: Alessandro Pansera
         * **/
        try{
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            byte[] payload = new byte[2000];
            int len;
            while((len = is.read(payload))>0) {
                System.out.println(String.format("Received %s\tFrom: %s", new String(payload, 0, len), socket.getRemoteSocketAddress()));
                //HANDLING OF REQUEST
                Gson gson = new Gson();
                RequestData request = gson.fromJson(new String(payload, 0, len),RequestData.class);
                //CREATING TEST SENSOR IN ORDER TO RETURN DATA
                TemperatureDevice tD1 = new TemperatureDevice("sensor_1","Dallas Temperature","Bosch","1.5.0");
                TemperatureDevice tD2 = new TemperatureDevice("sensor_2","Temperature VGX2","Texas Instrument","2.3.1");
                TemperatureDevice tD3 = new TemperatureDevice("sensor_3","TMax Reader","Denso","15.1.4");
                ArrayList<TemperatureDevice> listOfDevice = new ArrayList<>(List.of(tD1,tD2,tD3));
                if(request.getType().compareTo("GET")==0){
                    //CHECKING IF SENSOR IS EXISTING
                    boolean find = false;
                    int findIndex = 0;
                    for(int index = 0; index < listOfDevice.size(); index++){
                        if(listOfDevice.get(index).getId().compareTo(request.getSensorId())==0){
                            find = true;
                            findIndex = index;
                        }
                    }
                    //IF EXISTING RETURN LAST MEASURED TEMPERATURE
                    if(find){
                        ResponseData response = new ResponseData("200","OK","",listOfDevice.get(findIndex).getTemperature());
                        //SENDING THE RESPONSE TO THE CLIENT
                        System.out.println(response.toString());
                        os.write(response.toString().getBytes(),0,response.toString().getBytes().length);

                    }else{
                        ResponseData response = new ResponseData("400","ERROR","Device not Found",0);
                        //SENDING THE RESPONSE TO THE CLIENT
                        os.write(response.toString().getBytes(),0,response.toString().getBytes().length);
                    }
                }
                else{
                    ResponseData response = new ResponseData("400","ERROR","Invalid request type",0);
                    //SENDING THE RESPONSE TO THE CLIENT
                    os.write(response.toString().getBytes(),0,response.toString().getBytes().length);
                }
            }
        } catch (IOException e){}
    }

    public void run() throws IOException{
        /**
         * This method wait for all possible connection and serve them.
         * @author: Alessandro Pansera.
         * **/
        while (true){
            Socket socket = this.serverSocket.accept();
            new Thread(() -> this.serveRequest(socket)).start();
        }
    }
}
