package pl.sda.ewidencja.domain.dto;

import pl.sda.ewidencja.domain.entity.NetDevice;
import pl.sda.ewidencja.domain.enums.DeviceType;

import java.awt.*;

public class NetDeviceDTO {
    private DeviceType typ;
    private String marka;
    private String serialNumber;
    private int numberOfPorts;

    public NetDeviceDTO(NetDevice netDevice) {
        this(netDevice.getTyp(),netDevice.getMarka(),netDevice.getSerialNumber(),netDevice.getNumberOfPorts());
    }

    public NetDeviceDTO(DeviceType typ, String marka, String serialNumber, int numberOfPorts) {
        this.typ = typ;
        this.marka = marka;
        this.serialNumber = serialNumber;
        this.numberOfPorts = numberOfPorts;
    }

    public NetDeviceDTO() {
    }

    public DeviceType getTyp() {
        return typ;
    }

    public void setTyp(DeviceType typ) {
        this.typ = typ;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }
}
