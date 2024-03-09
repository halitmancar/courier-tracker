package com.halitmancar.couriertracker.service.concrete;

import com.halitmancar.couriertracker.dto.CourierLocationLogDto;
import com.halitmancar.couriertracker.mapping.ModelMapperManager;
import com.halitmancar.couriertracker.model.CourierLocationLog;
import com.halitmancar.couriertracker.repository.CourierLocationLogRepository;
import com.halitmancar.couriertracker.service.abstracts.CourierLocationLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourierLocationLogManager implements CourierLocationLogService {

    private CourierLocationLogRepository repository;

    public CourierLocationLogManager(CourierLocationLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(CourierLocationLog courierLocationLog){
        repository.save(courierLocationLog);
    }

    @Override
    public List<CourierLocationLogDto> getLogsByCourierID(Integer courierID) {
        List<CourierLocationLog> logList = repository.findAllByCourierId(courierID);
        return logList.stream().map(log -> ModelMapperManager.getMapper()
                .map(log, CourierLocationLogDto.class)).collect(Collectors.toList());
    }

}
