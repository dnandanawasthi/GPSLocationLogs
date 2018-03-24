package com.assesment.repository;

import com.assesment.model.GPSLogDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface GPSLocationLogsRepository extends JpaRepository<GPSLogDetail, Long> {

    @Query("SELECT g FROM GPSLogDetail g where g.gpsSerialId = :gpsSerialId")
    List<GPSLogDetail> findByGpsSerialId(@Param("gpsSerialId") Long gpsSerialId);
}

