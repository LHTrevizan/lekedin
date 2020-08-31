package com.let.trevizan.lekedin.models;

import javax.persistence.*;

@Entity
@Table(name = "EDUCATIONAL")
public class Educational {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    private final String school;

    private final String degree;

    private final Long tempo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileId")
    private Profile profile;

    public Educational(Long id, String school, String degree, Long tempo, Profile profile) {
        this.id = id;
        this.school = school;
        this.degree = degree;
        this.tempo = tempo;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public String getSchool() {
        return school;
    }

    public String getDegree() {
        return degree;
    }

    public Long getTempo() {
        return tempo;
    }

    public Profile getProfiles() {
        return profile;
    }

    public void setProfiles(Profile profiles) {
        this.profile = profiles;
    }
}
