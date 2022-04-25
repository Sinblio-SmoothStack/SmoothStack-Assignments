package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;

import java.sql.ResultSet;
import java.util.List;

public class FlightPassenger implements DBViewObject{
    private int flightId;
    private int bookingId;
    private String seatClass;
    private int passengerId;

    public FlightPassenger(int flightId, int bookingId, String seatClass, int passengerId) {
        this.flightId = flightId;
        this.bookingId = bookingId;
        this.seatClass = seatClass;
        this.passengerId = passengerId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    @Override
    public String toString() {
        return String.format("Flight Passenger: flight id: %d, booking id: %d, passenger id: %d, class: %s",
                flightId, bookingId, passengerId, seatClass);
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int flightId = rset.getInt("flight_id");
            int bookingId = rset.getInt("booking_id");
            String seatClass = rset.getString("class");
            int passengerId = rset.getInt("passenger_id");
            list.add(new FlightPassenger(flightId, bookingId, seatClass, passengerId));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "flight_passengers";
    }
}
