package com.let.trevizan.lekedin.controllers;

import com.let.trevizan.lekedin.dto.ExperienceDto;
import com.let.trevizan.lekedin.repositories.ExperienceRepository;
import com.let.trevizan.lekedin.services.ExperienceService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {

    private  final ExperienceService experienceService;

    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    public ExperienceController(ExperienceService experienceService) {this.experienceService = experienceService;}



    @GetMapping("/{id}")
    public ResponseEntity<ExperienceDto> get(@PathVariable Long id){

        ExperienceDto experienceDto = experienceService.getAndConvert(id);

        return ResponseEntity.ok(experienceDto);
    }

    @GetMapping
    public ResponseEntity <List<ExperienceDto>> getAll(){

        List<ExperienceDto> all = experienceService.getAll();

        return ResponseEntity.ok(all);
    }
    @PostMapping
    public ResponseEntity create(@RequestBody ExperienceDto experienceDto){

        ExperienceDto stored = experienceService.save(experienceDto);

        return ResponseEntity.ok(stored);
    }
    @DeleteMapping("{/id}")
    public ResponseEntity delete(@PathVariable Long id){

        experienceService.delete(id);

        return ResponseEntity.noContent().build();

    }
    /*@PutMapping
    public ResponseEntity edit(@RequestBody ExperienceDto experienceDto){
         return experienceRepository.save(edit(ResponseEntity));
    }*/
}
