package org.Mahagan.dao;

import org.Mahagan.model.IOTdevice;

import java.util.List;

public interface IOTDevice {
    IOTdevice getDeviceById(Long id);
    List<IOTdevice> getAllDevice();
    boolean deleteDevice(IOTdevice ioTdevice);
    boolean updateDevice(IOTdevice ioTdevice);
    boolean createIOTDevice(IOTdevice ioTdevice);

}
