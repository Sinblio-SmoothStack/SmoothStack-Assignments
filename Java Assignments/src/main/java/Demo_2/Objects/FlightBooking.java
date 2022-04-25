package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;
import Demo_2.Daos.StatementFunction;
import Demo_2.UI.Manager;
import Demo_2.UI.Screens.SelectionMenu;
import Demo_2.UI.Screens.UserInput;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FlightBooking implements DBTableObject{
    private int flightId;
    private int bookingId;
    private String seatClass;

    public FlightBooking() {
        this.flightId = 0;
        this.bookingId = 0;
        this.seatClass = null;
    }

    public FlightBooking(int flightId, int bookingId, String seatClass) {
        this.flightId = flightId;
        this.bookingId = bookingId;
        this.seatClass = seatClass;
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

    @Override
    public String toString() {
        return String.format("Flight Booking: flight id: %d, booking id: %d, class: %s", flightId, bookingId, seatClass);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setInt(1, flightId);
            stmt.setInt(2, bookingId);
            stmt.setString(3, seatClass);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set flight_id = ?, booking_id = ?, class = ?";
    }

    @Override
    public String updateQuery() {
        return "update " + defaultTableName() + " set flight_id = " + flightId + ", class = " + seatClass +
                " where booking_id = " + bookingId;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where booking_id = " + bookingId;
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int flightId = rset.getInt("flight_id");
            int bookingId = rset.getInt("booking_id");
            String seatClass = rset.getString("class");
            list.add(new FlightBooking(flightId, bookingId, seatClass));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "flight_bookings";
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        Manager manager = new Manager();
        Flight flight = (Flight) manager.select(new Flight());
        int newFlightId = flight.getId();

        Booking booking = (Booking) manager.select(new Booking());
        int newBookingId = booking.getId();

        UserInput userInput = new UserInput("Enter seat class:");
        userInput.draw();
        String newSeatClass = in.next();

        return new FlightBooking(newFlightId, newBookingId, newSeatClass);
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit flight", "Edit booking", "Edit class", "Quit");

        SelectionMenu selectionMenu = new SelectionMenu("Please select a value to edit:", menuOptions);
        selectionMenu.draw();

        try {
            int selection = in.nextInt();

            switch (selection) {
                case 1 -> {
                    Manager manager = new Manager();
                    Flight flight = (Flight) manager.select(new Flight());
                    this.flightId = flight.getId();
                    toReturn = this;
                }
                case 2 -> {
                    Manager manager = new Manager();
                    Booking booking = (Booking) manager.select(new Booking());
                    this.bookingId = booking.getId();
                    toReturn = this;
                }
                case 3 -> {
                    UserInput userInput = new UserInput("Enter seat class:");
                    userInput.draw();
                    seatClass = in.next();
                    toReturn = this;
                }
            }
        } finally {
            return toReturn;
        }

    }
}
