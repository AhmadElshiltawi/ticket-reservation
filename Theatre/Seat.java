package Theatre;

public class Seat {
    // Fields
    private String id;
    private boolean memberOnly;
    private boolean isBooked;

    // Constructor
    public Seat(String id, boolean memberOnly, boolean isBooked){
        this.id = id;
        this.memberOnly = memberOnly;
        this.isBooked= isBooked;
    }

    // Methods
    

    // Getters Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public boolean getIsMemberOnly() {
        return memberOnly;
    }
    public void setMemberOnly(boolean memberOnly) {
        this.memberOnly = memberOnly;
    }
    public boolean getIsBooked() {
        return isBooked;
    }
    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    // Overloaded operations
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Seat)) return false;
        Seat seat = (Seat) obj;
        if (seat.id.compareTo(this.id) == 0)
            return true;
        return false;
    }
    @Override
    public int hashCode() {
        int result=17;
        result=31*result+(id!=null ? id.hashCode():0);
        return result;
    }
}
