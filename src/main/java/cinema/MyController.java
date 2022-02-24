package cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
public class MyController {

    private final Cinema cinema;
    private final Statistic statistic;

    @Autowired
    public MyController(Cinema cinema, Statistic statistic) {
        this.cinema = cinema;
        this.statistic = statistic;
    }

    @GetMapping("/seats")
    public ResponseEntity<Cinema> getCinema() {
        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> buySeat(@RequestBody Ticket ticket) {
        List<Seat> list = cinema.getFull();
        Optional<Seat> seat1 = list.stream()
                .filter((seat2 -> seat2.getTicket().getRow()
                        .equals(ticket.getRow()) && seat2.getTicket().getColumn().equals(ticket.getColumn())))
                .findAny();
        if (!seat1.isPresent()) {
            throw new MyException("The number of a row or a column is out of bounds!");
        } else if (seat1.get().getTicket().isBought() == true) {
            throw new MyException("The ticket has been already purchased!");
        }
        seat1.get().getTicket().setBought(true);
        statistic.addNewTicket(seat1.get());
        return new ResponseEntity<>(seat1, HttpStatus.OK);

    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody Seat seat) {
        Optional<Seat> seat1 = cinema.getFull().stream()
                .filter((seat2 -> seat2.getToken().toString().equals(seat.getToken().toString()))).findAny();
        if (!seat1.isPresent()) {
            throw new MyException("Wrong token!");
        }
        seat1.get().getTicket().setBought(false);
        statistic.returnTicket(seat1.get());
        return new ResponseEntity<>(Map.of("returned_ticket", seat1.get().getTicket()), HttpStatus.OK);
    }

    @PostMapping("/stats")
    public ResponseEntity<?> getStats(@RequestParam(value = "password", required = false) String key) {
        if (Objects.isNull(key) || !key.equals("super_secret")) {
            throw new AuthException("The password is wrong!");
        }
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }
}
