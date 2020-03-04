package pl.chemik.VideoCasseteRental.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.chemik.VideoCasseteRental.dao.VideoCassetteRepo;
import pl.chemik.VideoCasseteRental.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {

    private VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    /**
     *
     * @param id
     * @return information about VideoCassete with id = param id
     */
    public Optional<VideoCassette> findAllById(Long id){
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll(){
        return videoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette){
        return videoCassetteRepo.save(videoCassette);
    }

    public void deleteById(Long id){
        videoCassetteRepo.deleteById(id);
    }

    /**
     * Add to database specific records.
     * EventListener activate this method when application starts (parameter of the adnotation)
     */
    @EventListener(ApplicationReadyEvent.class)
    public void fillDataBase(){
        save(new VideoCassette( 1L,"Titanic", LocalDate.of(1995,1,1)));
        save(new VideoCassette( 2L,"Pulp Fiction", LocalDate.of(1990,2,2)));
    }

}
