package com.let.trevizan.lekedin.services;

import com.let.trevizan.lekedin.dto.ProfileDto;
import com.let.trevizan.lekedin.models.Profile;
import com.let.trevizan.lekedin.repositories.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProfileServiceTest {
    @Autowired
    private ProfileService profileService;

    @MockBean
    private ProfileRepository profileRepository;

    @Test
    void save() {

        ProfileDto profileDto = new ProfileDto(null, "Guilherme", "engineer",
                "uruguai", "manja muito", emptyList(),
                emptyList(), emptyList(), emptyList());

        Mockito.when(profileRepository.save(Mockito.any()))
                .thenReturn(profileService.convert(profileDto));

        ProfileDto storaged = profileService.save(profileDto);

        assertThat(storaged).isEqualTo(profileDto);

        Mockito.verify(profileRepository, Mockito.times(1))
                .save(Mockito.any(Profile.class));

    }

    @Test
    void getAll() {
    }

    @Test
    void delete() {
    }
}