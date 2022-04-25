package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;
import Demo_2.Daos.StatementFunction;
import Demo_2.UI.Manager;
import Demo_2.UI.Screens.SelectionMenu;
import Demo_2.UI.Screens.UserInput;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Passenger implements DBTableObject{
    private int id;
    private int bookingId;
    private String givenName;
    private String familyName;
    private LocalDate dob;
    private String gender;
    private String address;

    public Passenger() {
        this.id = 0;
        this.bookingId = 0;
        this.givenName = null;
        this.familyName = null;
        this.dob = null;
        this.gender = null;
        this.address = null;
    }

    public Passenger(int id, int bookingId, String givenName, String familyName, LocalDate dob, String gender, String address) {
        this.id = id;
        this.bookingId = bookingId;
        this.givenName = givenName;
        this.familyName = familyName;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("Passenger: id: %d, booking id: %d, name: %s %s,\n" +
                "\tdob: %s, gender: %s, address %s", id, bookingId, givenName,
                familyName, dob.toString(), gender, address);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setInt(1, bookingId);
            stmt.setString(2, givenName);
            stmt.setString(3, familyName);
            stmt.setDate(4, Date.valueOf(dob));
            stmt.setString(5, gender);
            stmt.setString(6, address);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set booking_id = ?, given_name = ?, family_name = ?, " +
                "dob = ?, gender = ?, address = ?";
    }

    @Override
    public String updateQuery() {
        return "update " + defaultTableName() + " set booking_id = " + bookingId + ", given_name = " + givenName +
                ", family_name = " + familyName + ", dob = " + Date.valueOf(dob) + ", gender = " + gender +
                ", address = " + address + " where id = " + id;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where id = " + id;
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int id = rset.getInt("id");
            int bookingId = rset.getInt("booking_id");
            String givenName = rset.getString("given_name");
            String familyName = rset.getString("family_name");
            LocalDate dob = rset.getDate("dob").toLocalDate();
            String gender = rset.getString("gender");
            String address = rset.getString("address");
            list.add(new Passenger(id, bookingId, givenName, familyName, dob, gender, address));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "passenger";
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        Manager manager = new Manager();
        Booking booking = (Booking) manager.select(new Booking());
        int newBookingId = booking.getId();

        UserInput userInput = new UserInput("Enter given name:");
        userInput.draw();
        String newGivenName = in.next();

        userInput.updateMenuText("Enter family name:");
        userInput.draw();
        String newFamilyName = in.next();

        userInput.updateMenuText("Enter dob (YYYY-MM-DD):");
        userInput.draw();
        LocalDate newDob = LocalDate.parse(in.next());

        userInput.updateMenuText("Enter gender:");
        userInput.draw();
        String newGender = in.next();

        userInput.updateMenuText("Enter address:");
        userInput.draw();
        String newAddress = in.next();

        return new Passenger(0, newBookingId, newFamilyName, newGivenName, newDob, newGender, newAddress);
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit booking", "Edit given name", "Edit family name",
                "Edit dob", "Edit Gender", "Edit Address","Quit");

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
                    UserInput userInput = new UserInput("Enter new given name:");
                    userInput.draw();
                    this.givenName = in.next();
                    toReturn = this;
                }
                case 3 -> {
                    UserInput userInput = new UserInput("Enter new family name:");
                    userInput.draw();
                    this.familyName = in.next();
                    toReturn = this;
                }
                case 4 -> {
                    UserInput userInput = new UserInput("Enter new dob (YYYY-MM-DD):");
                    userInput.draw();
                    LocalDate newDob = LocalDate.parse(in.next());
                    toReturn = this;
                }
                case 5 -> {
                    UserInput userInput = new UserInput("Enter new gender:");
                    userInput.draw();
                    String newGender = in.next();
                    toReturn = this;
                }
                case 6 -> {
                    UserInput userInput = new UserInput("Enter new address:");
                    userInput.draw();
                    String newAddress = in.next();
                    toReturn = this;
                }
            }
        } finally {
            return toReturn;
        }

    }
}
