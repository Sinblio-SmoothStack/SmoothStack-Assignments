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

public class BookingPayment implements DBTableObject{
    private int bookingId;
    private int stripeId;
    private boolean refunded;

    public BookingPayment() {
        this.bookingId = 0;
        this.stripeId = 0;
        this.refunded = false;
    }

    public BookingPayment(int bookingId, int stripeId, boolean refunded) {
        this.bookingId = bookingId;
        this.stripeId = stripeId;
        this.refunded = refunded;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getStripeId() {
        return stripeId;
    }

    public void setStripeId(int stripeId) {
        this.stripeId = stripeId;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;
    }

    @Override
    public String toString() {
        String refundedString = "false";
        if (refunded) refundedString = "true";
        return String.format("Booking Payment: booking id: %d, stripe id: %d, refunded: %s", bookingId, stripeId, refundedString);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setInt(1, bookingId);
            stmt.setInt(2, stripeId);
            int refundedInt = 0;
            if (refunded) refundedInt = 1;
            stmt.setInt(3, refundedInt);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set booking_id = ?, stripe_id = ?, refunded = ?";
    }

    @Override
    public String updateQuery() {
        int refundedInt = 0;
        if (refunded) refundedInt = 1;
        return "update " + defaultTableName() + " set stripe_id = " + stripeId + ", refunded = " +
                refundedInt + "where booking_id = " + bookingId;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where booking_id = " + bookingId;
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int bookingId = rset.getInt("booking_id");
            int stripeId = rset.getInt("stripe_id");
            boolean refunded = rset.getInt("refunded") == 1;
            list.add(new BookingPayment(bookingId, stripeId, refunded));;
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "booking_payment";
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        Manager manager = new Manager();
        Booking booking = (Booking) manager.select(new Booking());
        int newBookingId = booking.getId();

        UserInput userInput = new UserInput("Enter the stripe id:");
        userInput.draw();
        int newStripeId = in.nextInt();

        userInput.updateMenuText("Enter refunded status (y/n):");
        userInput.draw();
        boolean newRefunded = in.next().equals("y");

        return new BookingPayment(newBookingId, newStripeId, newRefunded);
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
                    UserInput userInput = new UserInput("Enter the new stripe id:");
                    userInput.draw();
                    this.stripeId = in.nextInt();
                    toReturn = this;
                }
                case 3 -> {
                    UserInput userInput = new UserInput("Enter the new refunded status (y/n):");
                    userInput.draw();
                    refunded = in.next().equals("y");
                    toReturn = this;
                }
            }
        } finally {
            return toReturn;
        }

    }
}
