package mk.ukim.finki.wp.kol2024g1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.kol2024g1.model.Hotel;
import mk.ukim.finki.wp.kol2024g1.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotels;

    public HotelServiceImpl(HotelRepository hotels) {
        this.hotels = hotels;
    }

    @Override
    public Hotel findById(Long id) {
        return this.hotels.findById(id).get();
    }

    @Override
    public List<Hotel> listAll() {
        return this.hotels.findAll();
    }

    @Override
    public Hotel create(String name) {
        return this.hotels.save(new Hotel(name));
    }

}
