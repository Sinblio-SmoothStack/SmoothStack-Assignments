package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;
import Demo_2.Daos.StatementFunction;
import Demo_2.UI.Manager;
import Demo_2.UI.Screens.SelectionMenu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookingUser implements DBTableObject{
    private int bookingId;
    private int userId;

    public BookingUser() {
        this.bookingId = 0;
        this.userId = 0;
    }

    public BookingUser (int bookingId, int userId) {
        this.bookingId = bookingId;
        this.userId = userId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("Booking Agent: booking id: %d, user id: %d", bookingId, userId);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setInt(1, bookingId);
            stmt.setInt(2, userId);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set booking_id = ?, user_id = ?";
    }

    @Override
    public String updateQuery() {
        return "update " + defaultTableName() + " set user_id = " + userId + "where booking_id = " + bookingId;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where booking_id = " + bookingId;
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int bookingId = rset.getInt("booking_id");
            int agentId = rset.getInt("user_id");
            list.add(new BookingUser(bookingId, agentId));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "booking_user";
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        Manager manager = new Manager();
        Booking booking = (Booking) manager.select(new Booking());
        int newBookingId = booking.getId();

        User user = (User) manager.select(new User());
        int newUserId = user.getId();

        return new BookingUser(newBookingId, newUserId);
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit booking", "Edit stripe id", "Edit refunded", "Quit");

        SelectionMenu selectionMenu = new SelectionMenu("Please select a value to edit:", menuOptions);
        selectionMenu.draw();

        try {
            int selection = in.nextInt();

            switch (selection) {
                case 1 -> {
                    Manager manager = new Manager();
                    Booking booking = (Booking) manager.select(new Booking());
                    this.bookingId = booking.getId();
                    toReturn = this;
                }
                case 2 -> {
                    Manager manager = new Manager();
                    User user = (User) manager.select(new User());
                    this.userId = user.getId();
                    toReturn = this;
                }
            }
        } finally {
            return toReturn;
        }

    }
}
