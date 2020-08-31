package com.let.trevizan.lekedin.services;

import com.let.trevizan.lekedin.dto.ProfessionalInterestDto;
import com.let.trevizan.lekedin.exceptions.NotFoundException;
import com.let.trevizan.lekedin.models.ProfessionalInterest;
import com.let.trevizan.lekedin.models.Profile;
import com.let.trevizan.lekedin.repositories.ProfessionalInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProfessionalInterestService {

    private final ProfessionalInterestRepository professionalInterestRepository;

    private final ProfileService profileService;

    @Autowired
    public ProfessionalInterestService(ProfessionalInterestRepository professionalInterestRepository, ProfileService profileService) {
        this.professionalInterestRepository = professionalInterestRepository;
        this.profileService = profileService;
    }

    public ProfessionalInterest convert(ProfessionalInterestDto dto) {
        Profile profile = profileService.get(dto.getProfileId());
        return new ProfessionalInterest(dto.getId(), dto.getProfessional(), dto.getKnowledge(), profile);
    }

    public ProfessionalInterestDto convert(ProfessionalInterest professionalInterest) {

        return new ProfessionalInterestDto(professionalInterest.getId(),
                professionalInterest.getProfessional(),
                professionalInterest.getKnowledge(),
                null
        );

    }

    public ProfessionalInterestDto save(final ProfessionalInterestDto dto) {
        ProfessionalInterest professionalInterest = convert(dto);
        ProfessionalInterest storedProfessionalInterest = professionalInterestRepository.save(professionalInterest);
        return convert(storedProfessionalInterest);
    }

    public ProfessionalInterest get(Long id) {
        return professionalInterestRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public ProfessionalInterestDto getAndConvert(Long id) {
        return convert(get(id));
    }

    public List<ProfessionalInterestDto> getAll() {
        return professionalInterestRepository.findAll().stream()
                .map(this::convert).collect(toList());
    }

    public void delete(Long id) {
        ProfessionalInterest professionalInterest = professionalInterestRepository.findById(id).orElseThrow(NotFoundException::new);

        professionalInterestRepository.delete(professionalInterest);
    }

}
