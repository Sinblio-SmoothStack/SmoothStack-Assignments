package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;

import java.sql.ResultSet;
import java.util.List;

public class GuestBooking implements DBViewObject{
    private int id;
    private boolean isActive;
    private String confirmationCode;
    private String contactEmail;
    private String contactPhone;
    private int agentId;

    public GuestBooking(int id, boolean isActive, String confirmationCode, String contactEmail, String contactPhone, int agentId) {
        this.id = id;
        this.isActive = isActive;
        this.confirmationCode = confirmationCode;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
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
        return String.format("Guest Booking: id: %d, status: %s, confirmation code %s\n" +
                "\temail: %s, contact phone: %s, agent id: %d", id, status, confirmationCode, contactEmail,
                contactPhone, agentId);
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int id = rset.getInt("id");
            boolean isActive = rset.getInt("is_active") == 1;
            String confirmationCode = rset.getString("confirmation_code");
            String contactEmail = rset.getString("contact_email");
            String contactPhone = rset.getString("contact_phone");
            int agentId = rset.getInt("agent_id");
            list.add(new GuestBooking(id, isActive, confirmationCode, contactEmail, contactPhone,
                    agentId));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "guest_booking";
    }
}
