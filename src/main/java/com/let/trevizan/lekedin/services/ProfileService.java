package com.let.trevizan.lekedin.services;

import com.let.trevizan.lekedin.dto.ProfileDto;
import com.let.trevizan.lekedin.exceptions.NotFoundException;
import com.let.trevizan.lekedin.models.Profile;
import com.let.trevizan.lekedin.repositories.ProfileRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProfileService {

    private final EducationalService educationalService;
    private final ProfessionalInterestService professionalInterestService;
    private final ExperienceService experienceService;
    private final HobbieService hobbieService;
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(@Lazy EducationalService educationalService,
                          @Lazy ProfessionalInterestService professionalInterestService,
                          @Lazy ExperienceService experienceService,
                          @Lazy HobbieService hobbieService,
                          ProfileRepository profileRepository) {
        this.educationalService = educationalService;
        this.professionalInterestService = professionalInterestService;
        this.experienceService = experienceService;
        this.hobbieService = hobbieService;
        this.profileRepository = profileRepository;
    }

    public Profile convert(ProfileDto dto) {
        return new Profile(dto.getId(), dto.getName(), dto.getCargo(), dto.getLocalidade(), dto.getSobre());
    }

    public ProfileDto convert(Profile profile) {

        return new ProfileDto(profile.getId(),
                profile.getName(),
                profile.getCargo(),
                profile.getLocalidade(),
                profile.getSobre(),
                profile.getExperiences().stream()
                        .map(experienceService::convert)
                        .collect(toList()),
                profile.getProfessionalInterests().stream()
                        .map(professionalInterestService::convert)
                        .collect(toList()),
                profile.getHobbies().stream()
                        .map(hobbieService::convert)
                        .collect(toList()),
                profile.getEducationals().stream()
                        .map(educationalService::convert)
                        .collect(toList())
        );
    }

    public ProfileDto save(final ProfileDto dto) {
        Profile profile = convert(dto);
        Profile storedProfile = profileRepository.save(profile);
        return convert(storedProfile);
    }

    public Profile get(Long id) {
        return profileRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public ProfileDto getAndConvert(Long id) {
        return convert(get(id));
    }

    public List<ProfileDto> getAll() {
        return profileRepository.findAll().stream().map(this::convert).collect(toList());
    }

    public void delete(Long id) {

        Profile profile = profileRepository.findById(id).orElseThrow(NotFoundException::new);

        profileRepository.delete(profile);
    }

}
