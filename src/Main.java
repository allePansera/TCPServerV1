import Sensor.DeviceGeneric;
import Sensor.TemperatureDevice;
import com.google.gson.Gson;


public class Main {
    public static void main(String[] args) {
        //BUILD THE INSTANCE OF Gson
        Gson gson = new Gson();
        //TEST N.1 -> CREATE A GENERIC SENSOR
        DeviceGeneric dG1 = new DeviceGeneric();
        System.out.println(String.format("Generic sensor n.1: %s",dG1.toString()));

        //TEST N.2 -> CREATE A GENERIC SENSOR
        DeviceGeneric dG2 = new DeviceGeneric("sensor_2","LightReceiver","Texas Instrument","1.0.0");
        System.out.println(String.format("Generic sensor n.2: %s",dG2.toString()));

        //TEST DE-SERIALIZATION OF GENERIC SENSOR N.2
        DeviceGeneric dG2DeSerialized = gson.fromJson(dG2.toString(), DeviceGeneric.class);
        System.out.println(String.format("Generic sensor de-serialized n.2: %s",dG2DeSerialized.toString()));

        //TEST N.3 -> CREATE A SPECIFIC TEMPERATURE SENSOR
        TemperatureDevice tD3 = new TemperatureDevice("sensor_3","TempeReader","Texas Instrument","1.5.0");
        System.out.println(String.format("Temperature Device n.3: %s",tD3.toString()));
    }
}