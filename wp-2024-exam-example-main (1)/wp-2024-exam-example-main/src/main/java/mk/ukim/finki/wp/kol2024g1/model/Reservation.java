package mk.ukim.finki.wp.kol2024g1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Data
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guestName;

    private LocalDate dateCreated;

    private Integer daysOfStay;

    private RoomType roomType;

    @ManyToOne
    private Hotel hotel;

    public Reservation(String guestName, LocalDate dateCreated, Integer daysOfStay, RoomType roomType, Hotel hotel) {
        this.guestName = guestName;
        this.dateCreated = dateCreated;
        this.daysOfStay = daysOfStay;
        this.roomType = roomType;
        this.hotel = hotel;
    }
}
