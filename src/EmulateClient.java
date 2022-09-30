import Client.TCPclient;
import Requests.RequestData;
import com.google.gson.Gson;

import java.io.IOException;

public class EmulateClient {
    public static void main(String[] args) throws IOException {
        //FIRST ATTEMPT OF SINGLE COMMUNICATION BETWEEN CLIENT AND SERVER
        TCPclient client = new TCPclient();
        //BUILDING UP-REQUEST - UNDER STRING FORMAT AND OBJECT FORMAT
        RequestData req = new RequestData("GET","OK","sensor_2");
        String reqString = new String("{type:'GET',status:'OK',sensorsId:'sensor_2'}");
        Gson gson = new Gson();
        RequestData reqV2 = gson.fromJson(reqString, RequestData.class);
        //SENDING SINGLE REQUEST TO CLIENT
        client.sendData(reqV2);
        //READING THE RESPONSE FROM THE SERVER
        client.readData();
    }
}
