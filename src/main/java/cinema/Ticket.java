package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Ticket {
    private Integer row;
    private Integer column;
    private Integer price;
    private boolean isBought;

    public Ticket() {
    }

    public Ticket(Integer row, Integer column, Integer price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }
    @JsonIgnore
    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return isBought == ticket.isBought && Objects.equals(row, ticket.row) && Objects.equals(column, ticket.column) && Objects.equals(price, ticket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, price, isBought);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "row=" + row +
                ", column=" + column +
                ", price=" + price +
                ", isBought=" + isBought +
                '}';
    }
}
