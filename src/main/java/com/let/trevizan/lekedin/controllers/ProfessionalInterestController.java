package com.let.trevizan.lekedin.controllers;

import com.let.trevizan.lekedin.dto.EducationalDto;
import com.let.trevizan.lekedin.dto.ProfessionalInterestDto;
import com.let.trevizan.lekedin.services.EducationalService;
import com.let.trevizan.lekedin.services.ProfessionalInterestService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interests")
public class ProfessionalInterestController {

    private final ProfessionalInterestService professionalInterestService;

    @Autowired
    public ProfessionalInterestController( ProfessionalInterestService professionalInterestService) {
        this.professionalInterestService = professionalInterestService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalInterestDto> get(@PathVariable Long id) {

        ProfessionalInterestDto professionalInterestDto = professionalInterestService.getAndConvert(id);

        return ResponseEntity.ok(professionalInterestDto);
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalInterestDto>> getAll() {

        List<ProfessionalInterestDto> all = professionalInterestService.getAll();

        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ProfessionalInterestDto professionalInterestDto) {

        ProfessionalInterestDto stored = professionalInterestService.save(professionalInterestDto);

        return ResponseEntity.ok(stored);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        professionalInterestService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
