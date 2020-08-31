package com.let.trevizan.lekedin.services;

import com.let.trevizan.lekedin.dto.HobbieDto;
import com.let.trevizan.lekedin.exceptions.NotFoundException;
import com.let.trevizan.lekedin.models.Hobbie;
import com.let.trevizan.lekedin.models.Profile;
import com.let.trevizan.lekedin.repositories.HobbieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class HobbieService {
    private final ProfileService profileService;
    private final HobbieRepository hobbieRepository;

    @Autowired
    public HobbieService(ProfileService profileService, HobbieRepository hobbieRepository) {
        this.profileService = profileService;
        this.hobbieRepository = hobbieRepository;
    }

    private Hobbie convert(HobbieDto dto) {
        Profile profile = profileService.get(dto.getProfileId());

        return new Hobbie(dto.getId(), dto.getNameHobbie(), dto.getDescription(), profile);
    }

    public HobbieDto convert(Hobbie hobbie) {
        return new HobbieDto(hobbie.getId(),
                hobbie.getNameHobbie(),
                hobbie.getDescription(),
                null);
    }

    public HobbieDto save(final HobbieDto dto) {

        Hobbie hobbie = convert(dto);
        Hobbie storedHobbie = hobbieRepository.save(hobbie);
        return convert(storedHobbie);
    }


    public Hobbie get(Long id) {
        return hobbieRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public HobbieDto getAndConvert(Long id) {
        return convert(get(id));
    }

    public List<HobbieDto> getAll() {

        return hobbieRepository.findAll().stream().map(this::convert).collect(toList());
    }

    public void delete(Long id) {

        Hobbie hobbie = hobbieRepository.findById(id).orElseThrow(NotFoundException::new);

        hobbieRepository.delete(hobbie);
    }
}
