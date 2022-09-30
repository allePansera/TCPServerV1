package Requests;

import Sensor.DeviceGeneric;

public class Payload {
    private DeviceGeneric device;
    private float measurement;

    public Payload(DeviceGeneric device, float measurement) {
        this.device = device;
        this.measurement = measurement;
    }

    public DeviceGeneric getDevice() {
        return device;
    }

    public void setDevice(DeviceGeneric device) {
        this.device = device;
    }

    public float getMeasurement() {
        return measurement;
    }

    public void setMeasurement(float measurement) {
        this.measurement = measurement;
    }

    @Override
    public String toString() {
        return "{" +
                "device:" + device +
                ", measurement:" + measurement +
                '}';
    }
}
