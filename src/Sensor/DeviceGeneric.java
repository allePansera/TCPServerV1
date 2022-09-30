package Sensor;

public class DeviceGeneric {
    private String id;
    private String name;
    private String producer;
    private String version;


    public DeviceGeneric(String id, String name, String producer, String version) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.version = version;
    }
    public DeviceGeneric(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "id:'" + id + '\'' +
                ", name:'" + name + '\'' +
                ", producer:'" + producer + '\'' +
                ", version:'" + version + '\'' +
                '}';
    }
}
