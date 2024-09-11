package com.udea.consulta.service;
import com.udea.consulta.model.Flight;
import com.udea.consulta.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findFlights(LocalDate startDate, LocalDate endDate, String origin, String
            destination, Double maxPrice, Integer maxPax, String clase, String baggage) {
        // Generar una clave de combinación de parámetros para usar en el switch
        String key = (origin != null ? "1" : "0") +
                (destination != null ? "1" : "0") +
                (maxPrice != null ? "1" : "0") +
                (maxPax != null ? "1" : "0") +
                (clase != null ? "1" : "0") +
                (baggage != null ? "1" : "0");

        switch (key) {
            case "111000": // origin, destination, maxPrice no son nulos
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, origin, destination, maxPrice);
            case "110000": // origin, destination no son nulos, maxPrice es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
                        startDate, endDate, origin, destination);
            case "101000": // origin y maxPrice no son nulos, destination es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, origin, maxPrice);
            case "011000": // destination y maxPrice no son nulos, origin es nulo
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, destination, maxPrice);
            case "100000": // solo origin no es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCase(startDate,
                        endDate, origin);
            case "010000": // solo destination no es nulo
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCase(startDate, endDate,
                        destination);
            case "001000": // solo maxPrice no es nulo
                return flightRepository.findByDateBetweenAndPriceLessThanEqual(startDate, endDate, maxPrice);
            case "000000": // todos son nulos
                return flightRepository.findByDateBetween(startDate, endDate);

            // Nuevos casos que incluyan maxPax, clase y baggage

            case "111100": // origin, destination, maxPrice, maxPax no son nulos
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqual(
                        startDate, endDate, origin, destination, maxPrice, maxPax);

            case "111110": // origin, destination, maxPrice, maxPax, clase no son nulos
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCase(
                        startDate, endDate, origin, destination, maxPrice, maxPax, clase);

            case "111111": // origin, destination, maxPrice, maxPax, clase, baggage no son nulos
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCaseAndBaggageContainingIgnoreCase(
                        startDate, endDate, origin, destination, maxPrice, maxPax, clase, baggage);

            case "111101": // origin, destination, maxPrice, maxPax, baggage no son nulos
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndBaggageContainingIgnoreCase(
                        startDate, endDate, origin, destination, maxPrice, maxPax, baggage);

            case "101100": // origin, maxPrice, maxPax no son nulos, destination es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqual(
                        startDate, endDate, origin, maxPrice, maxPax);

            case "101110": // origin, maxPrice, maxPax, clase no son nulos, destination es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCase(
                        startDate, endDate, origin, maxPrice, maxPax, clase);

            case "101111": // origin, maxPrice, maxPax, clase, baggage no son nulos, destination es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCaseAndBaggageContainingIgnoreCase(
                        startDate, endDate, origin, maxPrice, maxPax, clase, baggage);

            case "011100": // destination, maxPrice, maxPax no son nulos, origin es nulo
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqual(
                        startDate, endDate, destination, maxPrice, maxPax);

            case "011110": // destination, maxPrice, maxPax, clase no son nulos, origin es nulo
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCase(
                        startDate, endDate, destination, maxPrice, maxPax, clase);

            case "011111": // destination, maxPrice, maxPax, clase, baggage no son nulos, origin es nulo
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCaseAndBaggageContainingIgnoreCase(
                        startDate, endDate, destination, maxPrice, maxPax, clase, baggage);

            case "001100": // maxPrice, maxPax no son nulos
                return flightRepository.findByDateBetweenAndPriceLessThanEqualAndMaxPaxGreaterThanEqual(
                        startDate, endDate, maxPrice, maxPax);

            case "001110": // maxPrice, maxPax, clase no son nulos
                return flightRepository.findByDateBetweenAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCase(
                        startDate, endDate, maxPrice, maxPax, clase);

            case "001111": // maxPrice, maxPax, clase, baggage no son nulos
                return flightRepository.findByDateBetweenAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCaseAndBaggageContainingIgnoreCase(
                        startDate, endDate, maxPrice, maxPax, clase, baggage);

            case "000100": // solo maxPax no es nulo
                return flightRepository.findByDateBetweenAndMaxPaxGreaterThanEqual(
                        startDate, endDate, maxPax);

            case "000110": // maxPax y clase no son nulos
                return flightRepository.findByDateBetweenAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCase(
                        startDate, endDate, maxPax, clase);

            case "000111": // maxPax, clase y baggage no son nulos
                return flightRepository.findByDateBetweenAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCaseAndBaggageContainingIgnoreCase(
                        startDate, endDate, maxPax, clase, baggage);

            case "000010": // solo clase no es nulo
                return flightRepository.findByDateBetweenAndClaseContainingIgnoreCase(
                        startDate, endDate, clase);

            case "000011": // clase y baggage no son nulos
                return flightRepository.findByDateBetweenAndClaseContainingIgnoreCaseAndBaggageContainingIgnoreCase(
                        startDate, endDate, clase, baggage);

            case "000001": // solo baggage no es nulo
                return flightRepository.findByDateBetweenAndBaggageContainingIgnoreCase(
                        startDate, endDate, baggage);

            default: // Cualquier otra combinación no contemplada
                return flightRepository.findByDateBetween(startDate, endDate);
        }
    }
}