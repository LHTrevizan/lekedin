package com.let.trevizan.lekedin.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProfileDto {

    private Long id;
    private
    String name;
    private
    String cargo;
    private
    String localidade;
    private
    String sobre;

    private List<ExperienceDto> experiences= new ArrayList<>();

    private List<ProfessionalInterestDto> professionalInterests = new ArrayList<>();

    private List<HobbieDto> hobbies= new ArrayList<>();

    private List<EducationalDto> educationals= new ArrayList<>();

    public ProfileDto() {
    }

    public ProfileDto(Long id, String name, String cargo, String localidade, String sobre, List<ExperienceDto> experiences, List<ProfessionalInterestDto> professionalInterests,
                      List<HobbieDto> hobbies, List<EducationalDto> educationals) {
        this.id = id;
        this.name = name;
        this.cargo = cargo;
        this.localidade = localidade;
        this.sobre = sobre;
        this.experiences = experiences;
        this.professionalInterests = professionalInterests;
        this.hobbies = hobbies;
        this.educationals = educationals;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCargo() {
        return cargo;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getSobre() {
        return sobre;
    }

    public List<ExperienceDto> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<ExperienceDto> experiences) {
        this.experiences = experiences;
    }

    public List<ProfessionalInterestDto> getProfessionalInterests() {
        return professionalInterests;
    }

    public void setProfessionalInterests(List<ProfessionalInterestDto> professionalInterests) {
        this.professionalInterests = professionalInterests;
    }

    public List<HobbieDto> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<HobbieDto> hobbies) {
        this.hobbies = hobbies;
    }

    public List<EducationalDto> getEducationals() {
        return educationals;
    }

    public void setEducationals(List<EducationalDto> educationals) {
        this.educationals = educationals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileDto that = (ProfileDto) o;
        return Objects.equals(id, that.id) &&
                name.equals(that.name) &&
                cargo.equals(that.cargo) &&
                localidade.equals(that.localidade) &&
                sobre.equals(that.sobre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cargo, localidade, sobre);
    }
}
