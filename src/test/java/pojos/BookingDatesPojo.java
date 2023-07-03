package pojos;

public class BookingDatesPojo {

        private String checkin;
        private String checkout;

    public BookingDatesPojo() { // Using right-click and Generate default constructor
    }

    public BookingDatesPojo(String checkin, String checkout) { // Using right-click Generate parametrized constructor
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
