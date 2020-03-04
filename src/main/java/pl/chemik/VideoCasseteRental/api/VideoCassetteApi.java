package pl.chemik.VideoCasseteRental.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.chemik.VideoCasseteRental.dao.entity.VideoCassette;
import pl.chemik.VideoCasseteRental.manager.VideoCassetteManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCassetteApi {

    private VideoCassetteManager videoCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassetteManager videoCassettes) {
        this.videoCassettes = videoCassettes;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassettes.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index) {
        return videoCassettes.findAllById(index);
    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index) {
        videoCassettes.deleteById(index);
    }

}

