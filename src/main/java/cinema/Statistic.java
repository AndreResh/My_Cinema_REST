package cinema;

public class Statistic {
    private Long current_income;
    private Long number_of_available_seats;
    private Long number_of_purchased_tickets;

    public Statistic() {
        this.current_income=0L;
        this.number_of_available_seats=81L;
        this.number_of_purchased_tickets=0L;
    }
    public void addNewTicket(Seat seat){
        this.setCurrent_income(this.getCurrent_income()+seat.getTicket().getPrice());
        this.setNumber_of_available_seats(this.getNumber_of_available_seats()-1);
        this.setNumber_of_purchased_tickets(this.getNumber_of_purchased_tickets()+1);
    }
    public void returnTicket(Seat seat){
        this.setCurrent_income(this.getCurrent_income()-seat.getTicket().getPrice());
        this.setNumber_of_available_seats(this.getNumber_of_available_seats()+1);
        this.setNumber_of_purchased_tickets(this.getNumber_of_purchased_tickets()-1);
    }

    public Long getCurrent_income() {
        return current_income;
    }

    public void setCurrent_income(Long current_income) {
        this.current_income = current_income;
    }

    public Long getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public void setNumber_of_available_seats(Long number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }

    public Long getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }

    public void setNumber_of_purchased_tickets(Long number_of_purchased_tickets) {
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "current_income=" + current_income +
                ", number_of_available_seats=" + number_of_available_seats +
                ", number_of_purchased_tickets=" + number_of_purchased_tickets +
                '}';
    }
}
