package com.halitmancar.couriertracker.service.abstracts;

import com.halitmancar.couriertracker.dto.CourierLocationLogDto;
import com.halitmancar.couriertracker.model.CourierLocationLog;

import java.util.List;

public interface CourierLocationLogService {
    void save(CourierLocationLog courierLocationLog);
    List<CourierLocationLogDto> getLogsByCourierID(Integer courierID);
}
