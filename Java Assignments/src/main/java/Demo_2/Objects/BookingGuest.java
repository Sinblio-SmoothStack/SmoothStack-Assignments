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

public class BookingGuest implements DBTableObject{
    private int bookingId;
    private String contactEmail;
    private String contactPhone;

    public BookingGuest() {
        this.bookingId = 0;
        this.contactEmail = null;
        this.contactPhone = null;
    }

    public BookingGuest(int bookingId, String contactEmail, String contactPhone) {
        this.bookingId = bookingId;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public String toString() {
        return String.format("Booking Guest: booking id: %d, email: %s, phone: %s", bookingId, contactEmail, contactPhone);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setInt(1, bookingId);
            stmt.setString(2, contactEmail);
            stmt.setString(3, contactPhone);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set booking_id = ?, contact_email = ?, contact_phone = ?";
    }

    @Override
    public String updateQuery() {
        return "update " + defaultTableName() + " set contact_email = " + contactEmail + ", contact_phone = " +
                contactPhone + "where booking_id = " + bookingId;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where booking_id = " + bookingId;
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int bookingId = rset.getInt("booking_id");
            String contactEmail = rset.getString("contact_email");
            String contactPhone = rset.getString("contact_phone");
            list.add(new BookingGuest(bookingId, contactEmail, contactPhone));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "booking_guest";
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        Manager manager = new Manager();
        Booking booking = (Booking) manager.select(new Booking());
        int newBookingId = booking.getId();

        UserInput userInput = new UserInput("Enter contact email:");
        userInput.draw();
        String newContactEmail = in.next();

        userInput.updateMenuText("Enter contact phone:");
        userInput.draw();
        String newContactPhone = in.next();

        return new BookingGuest(newBookingId, newContactEmail, newContactPhone);
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit booking", "Edit contact email", "Edit contact phone", "Quit");

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
                    UserInput userInput = new UserInput("Enter the new contact email:");
                    userInput.draw();
                    this.contactEmail = in.next();
                    toReturn = this;
                }
                case 3 -> {
                    UserInput userInput = new UserInput("Enter the new contact phone:");
                    userInput.draw();
                    this.contactPhone = in.next();
                    toReturn = this;
                }
            }
        } finally {
            return toReturn;
        }

    }
}
