package com.udea.consulta.controller;
import com.udea.consulta.model.Flight;
import com.udea.consulta.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/api/flights")

@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam("startDate") String startDate,
                                      @RequestParam("endDate") String endDate,
                                      @RequestParam(value = "origin", required = false) String origin,
                                      @RequestParam(value = "destination", required = false) String destination,
                                      @RequestParam(value = "maxPrice", required = false) Double maxPrice,
                                      @RequestParam(value = "maxPax", required = false) Integer maxPax,
                                      @RequestParam(value = "clase", required = false) String clase,
                                      @RequestParam(value = "baggage", required = false) String baggage){
        return flightService.findFlights(LocalDate.parse(startDate),
                LocalDate.parse(endDate), origin, destination, maxPrice, maxPax, clase, baggage );
    }
}
