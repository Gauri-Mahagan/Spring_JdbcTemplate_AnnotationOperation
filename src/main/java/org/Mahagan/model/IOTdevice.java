package org.Mahagan.model;

import java.util.Objects;

public class IOTdevice {
    private Long Id;
    private String deviceName;
    private String deviceLocation;
    private String  deviceFunction;

    public IOTdevice() {

   }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    public String getDeviceFunction() {
        return deviceFunction;
    }

    public void setDeviceFunction(String deviceFunction) {
        this.deviceFunction = deviceFunction;
    }

//    private String deviceFunction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IOTdevice)) return false;
        IOTdevice ioTdevice = (IOTdevice) o;
        return Id == ioTdevice.Id && deviceName.equals(ioTdevice.deviceName) && deviceLocation.equals(ioTdevice.deviceLocation) && deviceFunction.equals(ioTdevice.deviceFunction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, deviceName, deviceLocation, deviceFunction);
    }

    public IOTdevice(Long id, String deviceName, String deviceLocation, String deviceFunction) {
       this.Id = id;
        this.deviceName = deviceName;
        this.deviceLocation = deviceLocation;
        this.deviceFunction = deviceFunction;
    }

    @Override
    public String toString() {
        return "IOTdevice{" +
                "Id=" + Id +
                ", deviceName='" + deviceName + '\'' +
                ", deviceLocation='" + deviceLocation + '\'' +
                ", deviceFunction='" + deviceFunction + '\'' +
                '}';
    }
}
