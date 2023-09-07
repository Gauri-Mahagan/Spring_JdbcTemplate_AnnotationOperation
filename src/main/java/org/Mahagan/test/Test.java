package org.Mahagan.test;

import org.Mahagan.config.Applicationconfig;
import org.Mahagan.dao.IOTDevice;
import org.Mahagan.dao.IOTDeviceImpl;
import org.Mahagan.model.IOTdevice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Applicationconfig.class);
//        ApplicationContext context = new AnnotationConfigApplicationContext(Applicationconfig.class);
        IOTDevice iotDevice = context.getBean(IOTDeviceImpl.class);
        System.out.println("list of devicee is ::::::");


        for (IOTdevice i : iotDevice.getAllDevice()) {
            System.out.println(i);


        }
        System.out.println(" ");

        //==============================================================================================================


        System.out.println("Get deivice id 1 or 2");
        IOTdevice deviceById = iotDevice.getDeviceById(1L);
        System.out.println(deviceById);

        System.out.println(" ");
        //==============================================================================================================

        System.out.println("creating iot device is");
        IOTdevice device = new IOTdevice(2L, "Modbus", "pune", "Robatic");
        System.out.println(device);
        iotDevice.createIOTDevice(device);
        System.out.println("list of person is");

        for (IOTdevice i : iotDevice.getAllDevice()) {
            System.out.println(i);
        }
        System.out.println(" ");
        //================================================================================================================================


        System.out.println("/delete device with ID 3");
        iotDevice.deleteDevice(deviceById);
        System.out.println(" ");

        //========================================================================================================
        System.out.println("/update device with ID 3");
        IOTdevice d = iotDevice.getDeviceById(3L);
        d.setDeviceName("IOT");
        d.setDeviceFunction("modbus");
        d.setDeviceLocation("pune-1");
        iotDevice.updateDevice(d);
        System.out.println("update device");
        System.out.println(" ");



        //========================


        System.out.println("\n list of device is :");
        for (IOTdevice i : iotDevice.getAllDevice()) {
            System.out.println(i);
        }


        context.close();
    }


}







