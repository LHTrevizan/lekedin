package com.let.trevizan.lekedin.controllers;

import java.util.List;

import com.let.trevizan.lekedin.dto.EducationalDto;
import com.let.trevizan.lekedin.services.EducationalService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.let.trevizan.lekedin.dto.ProfileDto;
import com.let.trevizan.lekedin.services.ProfileService;

@RestController
@RequestMapping("/educationals")
public class EducationalController {

    private final EducationalService educationalService;

    @Autowired
    public EducationalController( EducationalService educationalService) {
        this.educationalService = educationalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationalDto> get(@PathVariable Long id) {

        EducationalDto educationalDto = educationalService.getAndConvert(id);

        return ResponseEntity.ok(educationalDto);
    }

    @GetMapping
    public ResponseEntity<List<EducationalDto>> getAll() {

        List<EducationalDto> all = educationalService.getAll();

        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody EducationalDto educationalDto) {

        EducationalDto stored = educationalService.save(educationalDto);

        return ResponseEntity.ok(stored);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        educationalService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
