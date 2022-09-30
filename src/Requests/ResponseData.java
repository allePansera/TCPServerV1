package Requests;

public class ResponseData {
    private String code;
    private String status;
    private String description;

    private float temperature;
    //PAYLOAD SHOULD BE IN A JSON FORMAT IN ORDER TO USE CLASS SERIALIZATION

    public ResponseData(String code, String status, String description,float temperature) {
        this.code = code;
        this.status = status;
        this.description = description;
        this.temperature = temperature;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                "code:'" + code + '\'' +
                ", status:'" + status + '\'' +
                ", description:'" + description + '\'' +
                ", temperature:'" +  temperature + '\'' +
                '}';
    }
}
