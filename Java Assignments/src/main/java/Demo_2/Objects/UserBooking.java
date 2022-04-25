package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserBooking implements DBViewObject {
    private int id;
    private boolean isActive;
    private String confirmationCode;
    private int userId;
    private int agentId;

    public UserBooking(int id, boolean isActive, String confirmationCode, int userId, int agentId) {
        this.id = id;
        this.isActive = isActive;
        this.confirmationCode = confirmationCode;
        this.userId = userId;
        this.agentId = agentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    @Override
    public String toString() {
        String status = "Cancelled";
        if (isActive) status = "Active";
        return String.format("Guest Booking: id: %d, user id: %d, agent id: %d, status: %s, confirmation code %s",
                id, userId, agentId, status, confirmationCode);
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int id = rset.getInt("id");
            boolean isActive = rset.getInt("is_active") == 1;
            String confirmationCode = rset.getString("confirmation_code");
            int userId = rset.getInt("user_id");
            int agentId = rset.getInt("agent_id");
            list.add(new UserBooking(id, isActive, confirmationCode, userId, agentId));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "user_booking";
    }
}
