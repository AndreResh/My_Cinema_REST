package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cinema {
    private Integer total_rows;
    private Integer total_columns;
    private List<Seat> full;
    private List<Ticket> available_seats;

    public Cinema() {
        this.total_rows = 9;
        this.total_columns = 9;
        this.full = new ArrayList<>();
        for (int i = 0; i < total_rows; i++) {
            int price = i <= 4 ? 10 : 8;
            for (int j = 0; j < total_columns; j++) {
                full.add(new Seat(UUID.randomUUID(), new Ticket(i + 1, j + 1, price)));
            }
        }
        this.available_seats = new ArrayList<>();
        full.stream().forEach(o -> available_seats.add(o.getTicket()));
    }

    public Integer getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(Integer total_rows) {
        this.total_rows = total_rows;
    }

    public Integer getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(Integer total_columns) {
        this.total_columns = total_columns;
    }

    @JsonIgnore
    public List<Seat> getFull() {
        return full;
    }


    public void setFull(List<Seat> full) {
        this.full = full;
    }

    public List<Ticket> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Ticket> available_seats) {
        this.available_seats = available_seats;
    }
}
