package com.assesment.controller;

import com.assesment.repository.GPSLocationLogsRepository;
import com.assesment.model.GPSLogDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/service")
public class GPSLocationLogController {

    @Autowired
    GPSLocationLogsRepository gpsLocationLogsRepository;

    @GetMapping("/logs")
    public List<GPSLogDetail> getAllGpsLogs() {
        return gpsLocationLogsRepository.findAll();
    }

    @GetMapping("/logs/{id}")
    public ResponseEntity<GPSLogDetail> getGpsLogsRecordId(@PathVariable(value = "id") Long id) {
        GPSLogDetail gpsLogDetail = gpsLocationLogsRepository.findOne(id);
        if(gpsLogDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(gpsLogDetail);
    }

    @GetMapping("/gpslogs/{id}")
    public ResponseEntity<List<GPSLogDetail>> getGpsLogsId(@PathVariable(value = "id") Long id) {
        List<GPSLogDetail> gpsLogDetail = gpsLocationLogsRepository.findByGpsSerialId(id);
        if(gpsLogDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(gpsLogDetail);
    }

    @PostMapping("/logs")
    public GPSLogDetail createGpsLogs(@Valid @RequestBody GPSLogDetail gpsLogDetail) {
        return gpsLocationLogsRepository.save(gpsLogDetail);
    }

    @DeleteMapping("/logs/{id}")
    public ResponseEntity<GPSLogDetail> deleteGpsLogs(@PathVariable(value = "id") Long id) {
        GPSLogDetail gpsLogDetail = gpsLocationLogsRepository.findOne(id);
        if(gpsLogDetail == null) {
            return ResponseEntity.notFound().build();
        }

        gpsLocationLogsRepository.delete(gpsLogDetail);
        return ResponseEntity.ok().build();
    }
}
