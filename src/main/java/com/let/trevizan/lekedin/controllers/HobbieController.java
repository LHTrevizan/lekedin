package com.let.trevizan.lekedin.controllers;

import com.let.trevizan.lekedin.dto.HobbieDto;
import com.let.trevizan.lekedin.repositories.HobbieRepository;
import com.let.trevizan.lekedin.services.HobbieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hobbies")
public class HobbieController {

    private final HobbieService hobbieService;

    @Autowired
    public HobbieRepository hobbieRepository;

    @Autowired
    public HobbieController( HobbieService hobbieService) {
        this.hobbieService = hobbieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HobbieDto> get(@PathVariable Long id) {

        HobbieDto hobbieDto = hobbieService.getAndConvert(id);

        return ResponseEntity.ok(hobbieDto);
    }
    @GetMapping
    public  ResponseEntity<List<HobbieDto>> getAll(){

        List<HobbieDto> all = hobbieService.getAll();

        return ResponseEntity.ok(all);


    }
    @PostMapping
    public ResponseEntity create(@RequestBody HobbieDto hobbieDto) {

        HobbieDto stored = hobbieService.save(hobbieDto);

        return ResponseEntity.ok(stored);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        hobbieService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
