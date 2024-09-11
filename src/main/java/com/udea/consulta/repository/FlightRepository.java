package com.udea.consulta.repository;
import com.udea.consulta.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Métodos previamente definidos
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String destination);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate, String origin, double maxPrice);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate, String destination, double maxPrice);

    List<Flight> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCase(LocalDate startDate,
                                                                LocalDate endDate, String origin);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCase(LocalDate startDate,
                                                                     LocalDate endDate, String destination);

    List<Flight> findByDateBetweenAndPriceLessThanEqual(LocalDate startDate, LocalDate endDate,
                                                        double maxPrice);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice);

    List<Flight> findByDateBetweenAndMaxPaxGreaterThanEqual(
            LocalDate startDate, LocalDate endDate, int maxPax);

    List<Flight> findByDateBetweenAndClaseContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String clase);

    List<Flight> findByDateBetweenAndBaggageContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String baggage);

    List<Flight> findByDateBetweenAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCaseAndBaggageContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, int maxPax, String clase, String baggage);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqual(
            LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice, int maxPax);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice, int maxPax, String clase);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCaseAndBaggageContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice, int maxPax, String clase, String baggage);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndBaggageContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice, int maxPax, String baggage);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqual(
            LocalDate startDate, LocalDate endDate, String origin, double maxPrice, int maxPax);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, double maxPrice, int maxPax, String clase);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCaseAndBaggageContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, double maxPrice, int maxPax, String clase, String baggage);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqual(
            LocalDate startDate, LocalDate endDate, String destination, double maxPrice, int maxPax);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String destination, double maxPrice, int maxPax, String clase);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCaseAndBaggageContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String destination, double maxPrice, int maxPax, String clase, String baggage);

    List<Flight> findByDateBetweenAndPriceLessThanEqualAndMaxPaxGreaterThanEqual(
            LocalDate startDate, LocalDate endDate, double maxPrice, int maxPax);

    List<Flight> findByDateBetweenAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, double maxPrice, int maxPax, String clase);

    List<Flight> findByDateBetweenAndPriceLessThanEqualAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCaseAndBaggageContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, double maxPrice, int maxPax, String clase, String baggage);

    List<Flight> findByDateBetweenAndMaxPaxGreaterThanEqualAndClaseContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, int maxPax, String clase);

    List<Flight> findByDateBetweenAndClaseContainingIgnoreCaseAndBaggageContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String clase, String baggage);

}

