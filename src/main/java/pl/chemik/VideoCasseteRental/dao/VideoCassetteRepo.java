package pl.chemik.VideoCasseteRental.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.chemik.VideoCasseteRental.dao.entity.VideoCassette;

/**
 * First parameter in CrudRepository: entity class
 * Second parameter in CrudRepository: type of id
 */
@Repository
public interface VideoCassetteRepo extends CrudRepository<VideoCassette, Long> {
}
