package Requests;

public class RequestData {
    private String type;
    private String status;
    private String sensorId;

    public RequestData(String type, String status, String sensorId) {
        this.type = type;
        this.status = status;
        this.sensorId = sensorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public String toString() {
        return "{" +
                "type:'" + type + '\'' +
                ", status:'" + status + '\'' +
                ", sensorId:'" + sensorId + '\'' +
                '}';
    }
}
