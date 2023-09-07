package org.Mahagan.dao;

import org.Mahagan.model.IOTdevice;

import org.Mahagan.model.IOTDeviceMapper;
import org.Mahagan.model.IOTdevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class IOTDeviceImpl implements IOTDevice {

    JdbcTemplate jdbcTemplate;
    private final String SQL_Find_Device = "select * from newdevice1  where id= ?";
    private final String SQL_Delete_Device = "delete from newdevice1 where id= ?";
    private final String SQL_Update_Device = "update newdevice1 set deviceName= ?,deviceLocation= ?,deviceFunction= ? where id= ?";
    private final String SQL_Get_All_Device = "select * from newdevice1";
    private final String SQL_Insert_Device = "insert into newdevice1(id,deviceName,deviceLocation,deviceFunction) values(?,?,?,?)";

// public IOTDeviceImpl(JdbcTemplate jdbcTemplate) {
//     this.jdbcTemplate = jdbcTemplate;
//  }

    /**
     *
     * @param dataSource
     */
    @Autowired
    public IOTDeviceImpl( DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * This is to execute logic of by Id in database, and it will get the respective id records for user
     *
     * @param id
     * @return jdbctemplate
     */
    public IOTdevice getDeviceById(Long id) {
        return jdbcTemplate.queryForObject(SQL_Find_Device, new Object[]{id}, new IOTDeviceMapper());
    }


//    @Override
//    public IOTdevice getDeviceById(int id) {
//        return null;
//    }

//    @Override
//    public IOTdevice getDeviceById(Long id) {
//        return jdbcTemplate.query( SQL_Find_Device, new Object[]{id}, new IOTDeviceMapper());
//    }

    /**
     * this is the method use to get all the device from Db
     *
     * @return jdbc Template
     */
    public List<IOTdevice> getAllDevice() {
        return jdbcTemplate.query(SQL_Get_All_Device, new IOTDeviceMapper());

    }


    /**
     * @param iotDevice iotDevice
     * @return jdbcTemplate
     */
    public boolean deleteDevice(IOTdevice iotDevice) {
        return jdbcTemplate.update(SQL_Delete_Device, iotDevice.getId()) > 0;
    }


    public boolean updateDevice(IOTdevice ioTdevice) {
        return jdbcTemplate.update(SQL_Update_Device, ioTdevice.getDeviceName(),ioTdevice.getDeviceFunction(),ioTdevice.getDeviceLocation(),ioTdevice.getId())>0 ;
    }

    /**
     * @param iotdevice iotdevice
     * @return jdbcTemplate
     */


    /**
     * crate iot device
     *
     * @param ioTdevice
     * @return
     */
    public boolean createIOTDevice(IOTdevice ioTdevice) {
        return jdbcTemplate.update(SQL_Insert_Device, ioTdevice.getId(),ioTdevice.getDeviceName(), ioTdevice.getDeviceLocation(), ioTdevice.getDeviceFunction()) > 0;
    }


}
