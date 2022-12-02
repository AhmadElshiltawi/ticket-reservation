package Theatre;

public class Seat {
    private int row, col;
    private boolean memberOnly, booked;

    public Seat(int row, int col, boolean memberOnly, boolean booked) {
        this.row = row;
        this.col = col;
        this.memberOnly = memberOnly;
        this.booked  = booked;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isMemberOnly() {
        return memberOnly;
    }

    public void setMemberOnly(boolean memberOnly) {
        this.memberOnly = memberOnly;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
