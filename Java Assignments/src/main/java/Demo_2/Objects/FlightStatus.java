package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class FlightStatus implements DBViewObject{
    private int id;
    private int routeId;
    private int airplaneId;
    private LocalDateTime departureTime;
    private int reservedSeatsEconomy;
    private int reservedSeatsBusiness;
    private int reservedSeatsFirst;
    private float seatPriceEconomy;
    private float seatPriceBusiness;
    private float seatPriceFirst;
    private int maxCapacityEconomy;
    private int maxCapacityBusiness;
    private int maxCapacityFirst;
    private int passengerCountEconomy;
    private int passengerCountBusiness;
    private int passengerCountFirst;
    private int availableSeatsEconomy;
    private int availableSeatsBusiness;
    private int availableSeatsFirst;

    public FlightStatus(int id, int routeId, int airplaneId, LocalDateTime departureTime, int reservedSeatsEconomy,
                        int reservedSeatsBusiness, int reservedSeatsFirst, float seatPriceEconomy,
                        float seatPriceBusiness, float seatPriceFirst, int maxCapacityEconomy, int maxCapacityBusiness,
                        int maxCapacityFirst, int passengerCountEconomy, int passengerCountBusiness,
                        int passengerCountFirst, int availableSeatsEconomy, int availableSeatsBusiness,
                        int availableSeatsFirst) {
        this.id = id;
        this.routeId = routeId;
        this.airplaneId = airplaneId;
        this.departureTime = departureTime;
        this.reservedSeatsEconomy = reservedSeatsEconomy;
        this.reservedSeatsBusiness = reservedSeatsBusiness;
        this.reservedSeatsFirst = reservedSeatsFirst;
        this.seatPriceEconomy = seatPriceEconomy;
        this.seatPriceBusiness = seatPriceBusiness;
        this.seatPriceFirst = seatPriceFirst;
        this.maxCapacityEconomy = maxCapacityEconomy;
        this.maxCapacityBusiness = maxCapacityBusiness;
        this.maxCapacityFirst = maxCapacityFirst;
        this.passengerCountEconomy = passengerCountEconomy;
        this.passengerCountBusiness = passengerCountBusiness;
        this.passengerCountFirst = passengerCountFirst;
        this.availableSeatsEconomy = availableSeatsEconomy;
        this.availableSeatsBusiness = availableSeatsBusiness;
        this.availableSeatsFirst = availableSeatsFirst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public int getReservedSeatsEconomy() {
        return reservedSeatsEconomy;
    }

    public void setReservedSeatsEconomy(int reservedSeatsEconomy) {
        this.reservedSeatsEconomy = reservedSeatsEconomy;
    }

    public int getReservedSeatsBusiness() {
        return reservedSeatsBusiness;
    }

    public void setReservedSeatsBusiness(int reservedSeatsBusiness) {
        this.reservedSeatsBusiness = reservedSeatsBusiness;
    }

    public int getReservedSeatsFirst() {
        return reservedSeatsFirst;
    }

    public void setReservedSeatsFirst(int reservedSeatsFirst) {
        this.reservedSeatsFirst = reservedSeatsFirst;
    }

    public float getSeatPriceEconomy() {
        return seatPriceEconomy;
    }

    public void setSeatPriceEconomy(float seatPriceEconomy) {
        this.seatPriceEconomy = seatPriceEconomy;
    }

    public float getSeatPriceBusiness() {
        return seatPriceBusiness;
    }

    public void setSeatPriceBusiness(float seatPriceBusiness) {
        this.seatPriceBusiness = seatPriceBusiness;
    }

    public float getSeatPriceFirst() {
        return seatPriceFirst;
    }

    public void setSeatPriceFirst(float seatPriceFirst) {
        this.seatPriceFirst = seatPriceFirst;
    }

    public int getMaxCapacityEconomy() {
        return maxCapacityEconomy;
    }

    public void setMaxCapacityEconomy(int maxCapacityEconomy) {
        this.maxCapacityEconomy = maxCapacityEconomy;
    }

    public int getMaxCapacityBusiness() {
        return maxCapacityBusiness;
    }

    public void setMaxCapacityBusiness(int maxCapacityBusiness) {
        this.maxCapacityBusiness = maxCapacityBusiness;
    }

    public int getMaxCapacityFirst() {
        return maxCapacityFirst;
    }

    public void setMaxCapacityFirst(int maxCapacityFirst) {
        this.maxCapacityFirst = maxCapacityFirst;
    }

    public int getPassengerCountEconomy() {
        return passengerCountEconomy;
    }

    public void setPassengerCountEconomy(int passengerCountEconomy) {
        this.passengerCountEconomy = passengerCountEconomy;
    }

    public int getPassengerCountBusiness() {
        return passengerCountBusiness;
    }

    public void setPassengerCountBusiness(int passengerCountBusiness) {
        this.passengerCountBusiness = passengerCountBusiness;
    }

    public int getPassengerCountFirst() {
        return passengerCountFirst;
    }

    public void setPassengerCountFirst(int passengerCountFirst) {
        this.passengerCountFirst = passengerCountFirst;
    }

    public int getAvailableSeatsEconomy() {
        return availableSeatsEconomy;
    }

    public void setAvailableSeatsEconomy(int availableSeatsEconomy) {
        this.availableSeatsEconomy = availableSeatsEconomy;
    }

    public int getAvailableSeatsBusiness() {
        return availableSeatsBusiness;
    }

    public void setAvailableSeatsBusiness(int availableSeatsBusiness) {
        this.availableSeatsBusiness = availableSeatsBusiness;
    }

    public int getAvailableSeatsFirst() {
        return availableSeatsFirst;
    }

    public void setAvailableSeatsFirst(int availableSeatsFirst) {
        this.availableSeatsFirst = availableSeatsFirst;
    }

    @Override
    public String toString() {
        return String.format("Flight: id: %d, route id: %d, airplane id: %d, departure time: %s\n" +
                        "\tReserved Seats: economy: %d, business %d, first: %d\n" +
                        "\tPassenger Count: economy: %d, business %d, first: %d\n" +
                        "\tMax Capacity: economy: %d, business %d, first: %d\n" +
                        "\tAvailable: economy: %d, business %d, first: %d\n" +
                        "\tSeat Price: economy $%.2f, business $%.2f, first $%.2f",
                id, routeId, airplaneId, departureTime.toString(), reservedSeatsEconomy, reservedSeatsBusiness,
                reservedSeatsFirst, passengerCountEconomy, passengerCountBusiness, passengerCountFirst,
                maxCapacityEconomy, maxCapacityBusiness, maxCapacityFirst, availableSeatsEconomy, availableSeatsBusiness,
                availableSeatsFirst, seatPriceEconomy, seatPriceBusiness, seatPriceFirst);
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int id = rset.getInt("id");
            int routeId = rset.getInt("route_id");
            int airplaneId = rset.getInt("airplane_id");
            LocalDateTime departureTime = rset.getTimestamp("departure_time").toLocalDateTime();
            int reservedSeatsEconomy = rset.getInt("reserved_seats_economy");
            int reservedSeatsBusiness = rset.getInt("reserved_seats_business");
            int reservedSeatsFirst = rset.getInt("reserved_seats_first");
            float seatPriceEconomy = rset.getFloat("seat_price_economy");
            float seatPriceBusiness = rset.getFloat("seat_price_business");
            float seatPriceFirst = rset.getFloat("seat_price_first");
            int maxCapacityEconomy = rset.getInt("max_capacity_economy");
            int maxCapacityBusiness = rset.getInt("max_capacity_business");
            int maxCapacityFirst = rset.getInt("max_capacity_first");
            int passengerCountEconomy = rset.getInt("passenger_count_economy");
            int passengerCountBusiness = rset.getInt("passenger_count_business");
            int passengerCountFirst = rset.getInt("passenger_count_first");
            int availableSeatsEconomy = rset.getInt("available_seats_economy");
            int availableSeatsBusiness = rset.getInt("available_seats_business");
            int availableSeatsFirst = rset.getInt("available_seats_first");
            list.add(new FlightStatus(id, routeId, airplaneId, departureTime, reservedSeatsEconomy,
                    reservedSeatsBusiness, reservedSeatsFirst, seatPriceEconomy, seatPriceBusiness,
                    seatPriceFirst, maxCapacityEconomy, maxCapacityBusiness, maxCapacityFirst,
                    passengerCountEconomy, passengerCountBusiness, passengerCountFirst,
                    availableSeatsEconomy, availableSeatsBusiness, availableSeatsFirst));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "flight_status";
    }
}
