package com.let.trevizan.lekedin.models;

import javax.persistence.*;

@Entity
@Table(name = "HOBBIE")
public class Hobbie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameHobbie;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileId")
    private Profile profile;

    public Hobbie(Long id, String nameHobbie, String description, Profile profile) {
        this.id = id;
        this.nameHobbie = nameHobbie;
        this.description = description;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameHobbie() {
        return nameHobbie;
    }

    public void setNameHobbie(String nameHobbie) {
        this.nameHobbie = nameHobbie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
