package com.snack.service;

import com.snack.pojo.domain.DoRecord;

import java.util.List;

public interface AdminPieMapService {
    List<DoRecord> selectGroupBytype(String startDate, String endDate);
}
