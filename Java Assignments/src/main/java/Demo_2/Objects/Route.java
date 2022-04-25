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

public class Route implements DBTableObject{
    private int id;
    private String originId;
    private String destinationId;

    public Route() {
        this.id = 0;
        this.originId = null;
        this.destinationId = null;
    }

    public Route(int id, String originId, String destinationId) {
        this.id = id;
        this.originId = originId;
        this.destinationId = destinationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    @Override
    public String toString() {
        return String.format("Route: id: %d, From: %s, To: %s", id, originId, destinationId);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setString(1, originId);
            stmt.setString(2, destinationId);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set origin_id = ?, destination_id = ?";
    }

    @Override
    public String updateQuery() {
        return "update " + defaultTableName() + " set origin_id = " + originId + ", destination_id = " +
                destinationId + " where id = " + id;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where id = " + id;
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int id = rset.getInt("id");
            String originId = rset.getString("origin_id");
            String destinationId = rset.getString("destination_id");
            list.add(new Route(id, originId, destinationId));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "route";
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        Manager manager = new Manager();
        Airport airport1 = (Airport) manager.select(new Airport());
        String newOriginAirport = airport1.getIataId();

        Airport airport2 = (Airport) manager.select(new Airport());
        String newDestinationAirport = airport2.getIataId();


        return new Route(0, newOriginAirport, newDestinationAirport);
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit origin airport", "Edit destination airport", "Quit");

        SelectionMenu selectionMenu = new SelectionMenu("Please select a value to edit:", menuOptions);
        selectionMenu.draw();

        try {
            int selection = in.nextInt();

            switch (selection) {
                case 1 -> {
                    Manager manager = new Manager();
                    Airport airport = (Airport) manager.select(new Airport());
                    originId = airport.getIataId();
                    toReturn = this;
                }
                case 2 -> {
                    Manager manager = new Manager();
                    Airport airport = (Airport) manager.select(new Airport());
                    destinationId = airport.getIataId();
                    toReturn = this;
                }
            }
        } finally {
            return toReturn;
        }
    }
}
