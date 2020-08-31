package com.let.trevizan.lekedin.services;

import com.let.trevizan.lekedin.dto.EducationalDto;
import com.let.trevizan.lekedin.exceptions.NotFoundException;
import com.let.trevizan.lekedin.models.Educational;
import com.let.trevizan.lekedin.models.Profile;
import com.let.trevizan.lekedin.repositories.EducationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class EducationalService {

    private final EducationalRepository educationalRepository;
    private final ProfileService profileService;


    @Autowired
    public EducationalService(EducationalRepository educationalRepository, ProfileService profileService) {
        this.educationalRepository = educationalRepository;
        this.profileService = profileService;
    }

    public Educational convert(EducationalDto dto) {
        Profile profile = profileService.get(dto.getProfileId());
        return new Educational(dto.getId(), dto.getSchool(), dto.getDegree(), dto.getTempo(), profile);
    }

    public EducationalDto convert(Educational educational) {
        return new EducationalDto(educational.getId(),
                educational.getSchool(),
                educational.getDegree(),
                educational.getTempo(),
                null);

    }

    public EducationalDto save(final EducationalDto dto) {
        Educational educational = convert(dto);
        Educational storedEducational = educationalRepository.save(educational);
        return convert(storedEducational);
    }

    public Educational get(Long id) {
        return educationalRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public EducationalDto getAndConvert(Long id) {
        return convert(get(id));
    }

    public List<EducationalDto> getAll() {
        return educationalRepository.findAll().stream().map(this::convert).collect(toList());
    }

    public void delete(Long id) {
        Educational educational = educationalRepository.findById(id).orElseThrow(NotFoundException::new);

        educationalRepository.delete(educational);
    }

}
