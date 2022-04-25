package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;
import Demo_2.Daos.StatementFunction;
import Demo_2.UI.Manager;
import Demo_2.UI.Screens.SelectionMenu;
import Demo_2.UI.Screens.UserInput;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Flight implements DBTableObject{
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

    public Flight() {
        this.id = 0;
        this.routeId = 0;
        this.airplaneId = 0;
        this.departureTime = LocalDateTime.now();
        this.reservedSeatsEconomy = 0;
        this.reservedSeatsBusiness = 0;
        this.reservedSeatsFirst = 0;
        this.seatPriceEconomy = 0;
        this.seatPriceBusiness = 0;
        this.seatPriceFirst = 0;
    }

    public Flight(int id, int routeId, int airplaneId, LocalDateTime departureTime, int reservedSeatsEconomy,
                  int reservedSeatsBusiness, int reservedSeatsFirst, float seatPriceEconomy, float seatPriceBusiness,
                  float seatPriceFirst) {
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

    @Override
    public String toString() {
        return String.format("Flight: id: %d, route id: %d, airplane id: %d, departure time: %s\n" +
                "\tReserved Seats: economy: %d, business %d, first: %d\n" +
                "\tSeat Price: economy $%.2f, business $%.2f, first $%.2f",
                id, routeId, airplaneId, departureTime.toString(), reservedSeatsEconomy, reservedSeatsBusiness,
                reservedSeatsFirst, seatPriceEconomy, seatPriceBusiness, seatPriceFirst);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setInt(1, routeId);
            stmt.setInt(2, airplaneId);
            stmt.setTimestamp(3, Timestamp.valueOf(departureTime));
            stmt.setInt(4, reservedSeatsEconomy);
            stmt.setInt(5, reservedSeatsBusiness);
            stmt.setInt(6, reservedSeatsFirst);
            stmt.setFloat(7, seatPriceEconomy);
            stmt.setFloat(8, seatPriceBusiness);
            stmt.setFloat(9, seatPriceFirst);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set route_id = ?, airplane_id = ?, departure_time = ?, " +
                "reserved_seats_economy = ?, reserved_seats_business = ?, reserved_seats_first = ?, " +
                "seat_price_economy = ?, seat_price_business = ?, seat_price_first = ?";
    }

    @Override
    public String updateQuery() {
        return "update " + defaultTableName() + " set route_id = " + routeId + ", airplane_id = " + airplaneId +
                ", departure_time = " + Timestamp.valueOf(departureTime) + ", reserved_seats_economy = " +
                reservedSeatsEconomy + ", reserved_seats_business = " + reservedSeatsBusiness + ", reserved_seats_first = " +
                reservedSeatsFirst + ", seat_price_economy = " + seatPriceEconomy + ", seat_price_business = " +
                seatPriceBusiness + ", seat_price_first = " + seatPriceFirst + " where id = " + id;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where id = " + id;
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
            list.add(new Flight(id, routeId, airplaneId, departureTime, reservedSeatsEconomy,
                    reservedSeatsBusiness, reservedSeatsFirst, seatPriceEconomy, seatPriceBusiness,
                    seatPriceFirst));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "flight";
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        Manager manager = new Manager();
        Route route = (Route) manager.select(new Route());
        int newRouteId = route.getId();

        Airplane airplane = (Airplane) manager.select(new Airplane());
        int newAirplaneId = airplane.getId();

        UserInput userInput = new UserInput("Enter the departure time (YYYY-MM-ddTHH:mm:ss):");
        userInput.draw();
        LocalDateTime newDepartureTime = LocalDateTime.parse(in.next());

        userInput.updateMenuText("Enter reserved economy seats:");
        userInput.draw();
        int newReservedEconomySeats = in.nextInt();

        userInput.updateMenuText("Enter reserved business seats:");
        userInput.draw();
        int newReservedBusinessSeats = in.nextInt();

        userInput.updateMenuText("Enter reserved first seats:");
        userInput.draw();
        int newReservedFirstSeats = in.nextInt();

        userInput.updateMenuText("Enter economy seat price:");
        userInput.draw();
        float newEconomySeatPrice = in.nextFloat();

        userInput.updateMenuText("Enter business seat price:");
        userInput.draw();
        float newBusinessSeatPrice = in.nextFloat();

        userInput.updateMenuText("Enter first seat price:");
        userInput.draw();
        float newFirstSeatPrice = in.nextFloat();

        return new Flight(0, newRouteId, newAirplaneId, newDepartureTime, newReservedEconomySeats, newReservedBusinessSeats,
                newReservedFirstSeats, newEconomySeatPrice, newBusinessSeatPrice, newFirstSeatPrice);
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit route", "Edit airplane", "Edit Departure Time", "Edit reserved economy seats",
                "Edit reserved business seats", "Edit reserved first class seats", "Edit economy seat price",
                "Edit business seat price", "Edit first class seat price", "Quit");

        SelectionMenu selectionMenu = new SelectionMenu("Please select a value to edit:", menuOptions);
        selectionMenu.draw();

        try {
            int selection = in.nextInt();

            switch (selection) {
                case 1 -> {
                    Manager manager = new Manager();
                    Route route = (Route) manager.select(new Route());
                    this.routeId = route.getId();
                    toReturn = this;
                }
                case 2 -> {
                    Manager manager = new Manager();
                    Airplane airplane = (Airplane) manager.select(new Airplane());
                    this.airplaneId = airplane.getId();
                    toReturn = this;
                }
                case 3 -> {
                    UserInput userInput = new UserInput("Enter the new departure time (YYYY-MM-ddTHH:mm:ss):");
                    userInput.draw();
                    this.departureTime = LocalDateTime.parse(in.next());
                    toReturn = this;
                }
                case 4 -> {
                    UserInput userInput = new UserInput("Enter reserved economy seats:");
                    userInput.draw();
                    this.reservedSeatsEconomy = in.nextInt();
                    toReturn = this;
                }
                case 5 -> {
                    UserInput userInput = new UserInput("Enter reserved business seats:");
                    userInput.draw();
                    this.reservedSeatsBusiness = in.nextInt();
                    toReturn = this;
                }
                case 6 -> {
                    UserInput userInput = new UserInput("Enter reserved first seats:");
                    userInput.draw();
                    this.reservedSeatsFirst = in.nextInt();
                    toReturn = this;
                }
                case 7 -> {
                    UserInput userInput = new UserInput("Enter economy seat price:");
                    userInput.draw();
                    this.seatPriceEconomy = in.nextFloat();
                    toReturn = this;
                }
                case 8 -> {
                    UserInput userInput = new UserInput("Enter business seat price:");
                    userInput.draw();
                    this.seatPriceBusiness = in.nextFloat();
                    toReturn = this;
                }
                case 9 -> {
                    UserInput userInput = new UserInput("Enter first class seat price:");
                    userInput.draw();
                    this.seatPriceFirst = in.nextFloat();
                    toReturn = this;
                }

            }
        } finally {
            return toReturn;
        }

    }
}
