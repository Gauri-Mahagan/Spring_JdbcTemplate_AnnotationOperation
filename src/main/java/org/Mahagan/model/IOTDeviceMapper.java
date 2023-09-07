package org.Mahagan.model;

import org.Mahagan.model.IOTdevice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IOTDeviceMapper implements RowMapper<IOTdevice> {

    @Override
    public IOTdevice mapRow(ResultSet rs, int rowNum) throws SQLException {
        IOTdevice iotDevice =new IOTdevice();
        iotDevice.setId(rs.getLong("id"));
        iotDevice.setDeviceName(rs.getString("deviceName"));
        iotDevice.setDeviceLocation(rs.getString("deviceLocation"));
        iotDevice.setDeviceFunction(rs.getString("deviceFunction"));
        return iotDevice;

    }
}
