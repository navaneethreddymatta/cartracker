package io.nav.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.nav.entity.Reading;
import io.nav.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by navanee on 24-06-2017.
 */

@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    ReadingService readingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reading> getReadings() {
        return readingService.getReadings();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public List<Reading> getReadings(@PathVariable("vin") String vin) {
        return readingService.getReadingsByVehicle(vin);
    }

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = "http://mocker.egen.io")
    public void createReading(@RequestBody Reading reading) {
        // System.out.println(reading.toString());
        readingService.addReading(reading);
    }

}
