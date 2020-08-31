package com.let.trevizan.lekedin.controllers;

import com.let.trevizan.lekedin.dto.ProfileDto;
import com.let.trevizan.lekedin.repositories.ProfileRepository;
import com.let.trevizan.lekedin.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    public ProfileController( ProfileService profileService) {
        this.profileService = profileService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> get(@PathVariable Long id) {

        ProfileDto profileDto = profileService.getAndConvert(id);

        return ResponseEntity.ok(profileDto);
    }

    @GetMapping
    public ResponseEntity<List<ProfileDto>> getAll() {

        List<ProfileDto> all = profileService.getAll();

        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ProfileDto profileDto) {

        ProfileDto stored = profileService.save(profileDto);

        return ResponseEntity.ok(stored);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        profileService.delete(id);

        return ResponseEntity.noContent().build();
    }


}
