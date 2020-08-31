package com.let.trevizan.lekedin.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROFILE")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String cargo;

    private String localidade;

    private String sobre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Experience> experiences = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ProfessionalInterest> professionalInterests = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Hobbie> hobbies = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Educational> educationals = new HashSet<>();

    public Profile(Long id, String name, String cargo, String localidade, String sobre) {
        this.id = id;
        this.name = name;
        this.cargo = cargo;
        this.localidade = localidade;
        this.sobre = sobre;
    }

    public Profile() {
    }

    public Profile(Long id, String name, String cargo, String localidade, String sobre,
                   Set<Experience> experiences, Set<ProfessionalInterest> professionalInterests,
                   Set<Hobbie> hobbies, Set<Educational> educationals) {
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

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public Set<ProfessionalInterest> getProfessionalInterests() {
        return professionalInterests;
    }

    public void setProfessionalInterests(Set<ProfessionalInterest> professionalInterests) {
        this.professionalInterests = professionalInterests;
    }

    public Set<Hobbie> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobbie> hobbies) {
        this.hobbies = hobbies;
    }

    public Set<Educational> getEducationals() {
        return educationals;
    }

    public void setEducationals(Set<Educational> educationals) {
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


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

}
