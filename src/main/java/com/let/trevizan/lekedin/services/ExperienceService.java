package com.let.trevizan.lekedin.services;

import com.let.trevizan.lekedin.dto.ExperienceDto;
import com.let.trevizan.lekedin.exceptions.NotFoundException;
import com.let.trevizan.lekedin.models.Experience;
import com.let.trevizan.lekedin.models.Profile;
import com.let.trevizan.lekedin.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ExperienceService {
    private  final ProfileService profileService;
    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ProfileService profileService, ExperienceRepository experienceRepository) {
        this.profileService = profileService;
        this.experienceRepository = experienceRepository;
    }

    private Experience convert(ExperienceDto dto) {
        Profile profile = profileService.get(dto.getProfileId());

        return new Experience(dto.getId(), dto.getNameEmpresa(), dto.getCargoEmpresa(),
                dto.getDescricao(), dto.getInicio(), dto.getFim(), profile);
    }

    public ExperienceDto convert(Experience experience) {

        return new ExperienceDto(experience.getId(),
                experience.getNameEmpresa(),
                experience.getCargoEmpresa(),
                experience.getDescricao(),
                experience.getInicio(),
                experience.getFim(),
                null
        );
    }

    public ExperienceDto save(final ExperienceDto dto) {
        Experience experience = convert(dto);
        Experience storedExperience = experienceRepository.save(experience);
        return convert(storedExperience);
    }

    public Experience get(Long id) {
        return experienceRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public ExperienceDto getAndConvert(Long id) {
        return convert(get(id));
    }

    public List<ExperienceDto> getAll() {
        return experienceRepository.findAll().stream().map(this::convert).collect(toList());
    }

    public void delete(Long id) {
        Experience experience = experienceRepository.findById(id).orElseThrow(NotFoundException::new);

        experienceRepository.delete(experience);
    }

}
