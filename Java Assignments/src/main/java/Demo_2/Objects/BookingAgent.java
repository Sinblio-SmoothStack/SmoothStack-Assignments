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

public class BookingAgent implements DBTableObject{
    private int bookingId;
    private int agentId;

    public BookingAgent() {
        this.bookingId = 0;
        this.agentId = 0;
    }

    public BookingAgent(int bookingId, int agentId) {
        this.bookingId = bookingId;
        this.agentId = agentId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    @Override
    public String toString() {
        return String.format("Booking Agent: booking id: %d, agent id: %d", bookingId, agentId);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setInt(1, bookingId);
            stmt.setInt(2, agentId);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set booking_id = ?, agent_id = ?";
    }

    @Override
    public String updateQuery() {
        return "update " + defaultTableName() + " set agent_id = " + agentId + "where booking_id = " + bookingId;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where booking_id = " + bookingId;
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int bookingId = rset.getInt("booking_id");
            int agentId = rset.getInt("agent_id");
            list.add(new BookingAgent(bookingId, agentId));
        };
        return resultSetFunction;
    }

    @Override
    public DBTableObject createNew() {
        Manager manager = new Manager();
        Booking booking = (Booking) manager.select(new Booking());
        int newBookingId = booking.getId();

        User user = (User) manager.select(new User());
        int newAgentId = user.getId();

        return new BookingAgent(newBookingId, newAgentId);
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit booking id", "Edit agent id", "Quit");

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
                    this.agentId = user.getId();
                    toReturn = this;
                }
            }
        } finally {
            return toReturn;
        }

    }

    @Override
    public String defaultTableName() {
        return "booking_agent";
    }
}
