package ru.unn.internetveshey.services;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;
import ru.unn.internetveshey.dto.RideDto;
import ru.unn.internetveshey.dto.enums.Currency;
import ru.unn.internetveshey.jpa.model.Ride;
import ru.unn.internetveshey.jpa.model.payment.Invoice;
import ru.unn.internetveshey.jpa.repository.RideRepository;
import ru.unn.internetveshey.jpa.repository.UserRepository;
import ru.unn.internetveshey.mapper.CarMapper;
import ru.unn.internetveshey.mapper.RideMapper;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RequestRideService {
    private final UserRepository userRepository;
    private final RideRepository rideRepository;
    private final CarMapper carMapper;
    private final RideMapper rideMapper;

    public void requestRide(RideDto rideDto) {
        Ride ride = new Ride();
        ride.setUser(userRepository.findFirstByLoginSafe(rideDto.getUser().getLogin()));
        ride.setCar(carMapper.toCar(rideDto.getCar()));
        ride.setStartTime(LocalDateTime.now());

        rideRepository.save(ride);
    }

    public void endRide(String login) {
        Invoice invoice = new Invoice();
        Ride ride = rideRepository.findFirstByUser_LoginAndEndTimeIsNull(login);
        ride.setEndTime(LocalDateTime.now());
        ride.setDistance(calculateDistance(ride.getUser().getLogin()));

        invoice.setRide(ride);
        invoice.setCurrency(Currency.RUB);
        invoice.setAmount(ride.getCar().getCarTariff().calculatePrice(ride));
        invoice.setName("Ride for %s from %s to %s".formatted(ride.getUser().getLogin(), ride.getStartTime(), ride.getEndTime()));

        ride.setInvoice(invoice);

        rideRepository.save(ride);
    }

    public RideDto getCurrentRide(String login) {
        return rideMapper.fromRide(rideRepository.findFirstByUser_LoginAndEndTimeIsNull(login));
    }

    public double calculateDistance(String login) {
        Ride ride = rideRepository.findFirstByUser_LoginAndEndTimeIsNull(login);

        return distance(ride.getCar().getStartLocation().getLatitude(),
                ride.getCar().getEndLocation().getLatitude(),
                ride.getCar().getStartLocation().getLongitude(),
                ride.getCar().getEndLocation().getLongitude(),
                0, 0);
    }


    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     * @returns Distance in Meters
     */
    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

}
