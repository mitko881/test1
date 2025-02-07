package mk.ukim.finki.wp.kol2024g1.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.kol2024g1.model.Hotel;
import mk.ukim.finki.wp.kol2024g1.model.Reservation;
import mk.ukim.finki.wp.kol2024g1.model.RoomType;
import mk.ukim.finki.wp.kol2024g1.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservations;
    private final HotelService hotels;

    public ReservationServiceImpl(ReservationRepository reservations, HotelService hotels) {
        this.reservations = reservations;
        this.hotels = hotels;
    }

    @Override
    public List<Reservation> listAll() {
        return this.reservations.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return this.reservations.findById(id).get();
    }

    @Override
    public Reservation create(String guestName, LocalDate dateCreated, Integer daysOfStay, RoomType roomType,
            Long hotelId) {
        Hotel h = this.hotels.findById(hotelId);
        return this.reservations.save(new Reservation(guestName, dateCreated, daysOfStay, roomType, h));
    }

    @Override
    public Reservation update(Long id, String guestName, LocalDate dateCreated, Integer daysOfStay, RoomType roomType,
            Long hotelId) {
        Reservation r = this.reservations.findById(id).get();
        r.setGuestName(guestName);
        r.setDateCreated(dateCreated);
        r.setDaysOfStay(daysOfStay);
        r.setRoomType(roomType);
        Hotel h = this.hotels.findById(hotelId);
        r.setHotel(h);

        return this.reservations.save(r);

    }

    @Override
    public Reservation delete(Long id) {
        Reservation r = this.reservations.findById(id).get();
        this.reservations.delete(r);
        return r;
    }

    @Override
    public Reservation extendStay(Long id) {
        Reservation r = this.reservations.findById(id).get();
        r.setDaysOfStay(r.getDaysOfStay() + 1);
        return this.reservations.save(r);
    }

    @Override
    public Page<Reservation> findPage(String guestName, RoomType roomType, Long hotel, int pageNum, int pageSize) {
        return null;
    }

}
