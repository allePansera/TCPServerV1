package Sensor;

public class TemperatureDevice extends DeviceGeneric{
    private final String UoMeasurement = "CELSIUS";
    private float temperature;
    TemperatureDevice(){}

    public TemperatureDevice(String id, String name, String producer, String version, float temperature) {
        super(id,name, producer, version);
        this.temperature = temperature;
    }

    public TemperatureDevice(String id,String name, String producer, String version) {
        super(id, name, producer, version);
        //ACCEPTING A TEMPERATURE BETWEEN -30 C° AND +30 C°
        float max = 30;
        float min = -30;
        float range = max - min + 1;
        //RANDOM GENERATION OF TEMP. INSIDE SPECIFIC RANGE
        this.temperature = (float)(Math.random() * range) + min;
    }

    public TemperatureDevice(float temperature) {
        this.temperature = temperature;
    }

    public String getUoMeasurement() {
        return UoMeasurement;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "{" +
                "UoMeasurement:'" + UoMeasurement + '\'' +
                ", temperature:" + temperature +
                ", id:'" + super.getId() + '\'' +
                ", name:'" + super.getName() + '\'' +
                ", producer:'" + super.getProducer() + '\'' +
                ", version:'" + super.getVersion() + '\'' +
                '}';
    }
}
