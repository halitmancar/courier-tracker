package com.halitmancar.couriertracker.service.abstracts;

import com.halitmancar.couriertracker.dto.RequestType;

public interface LocationTrackerService {
    boolean checkAllZones(RequestType request);
    Double calculateDistance(double lat1, double lng1, double lat2, double lng2);
}
