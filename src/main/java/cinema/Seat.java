package cinema;

import java.util.Objects;
import java.util.UUID;

public class Seat {
    private UUID token;
    private Ticket ticket;

    public Seat() {
    }

    public Seat(UUID token, Ticket ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(token, seat.token) && Objects.equals(ticket, seat.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, ticket);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "token=" + token +
                ", ticket=" + ticket +
                '}';
    }
}
