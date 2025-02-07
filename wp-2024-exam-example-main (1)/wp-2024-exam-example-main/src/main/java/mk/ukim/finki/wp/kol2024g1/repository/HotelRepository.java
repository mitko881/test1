package mk.ukim.finki.wp.kol2024g1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.wp.kol2024g1.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
