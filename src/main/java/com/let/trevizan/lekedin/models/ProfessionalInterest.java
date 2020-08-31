package com.let.trevizan.lekedin.models;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Entity
@Table(name = "PROFESSIONAL_INTEREST")
public class ProfessionalInterest {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String professional;

    private String knowledge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileId")
    private Profile profile;

    public ProfessionalInterest(Long id, String professional, String knowledge, Profile profiles) {
        this.id = id;
        this.professional = professional;
        this.knowledge = knowledge;
        this.profile = profiles;
    }

    public ProfessionalInterest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public Profile getProfiles() {
        return profile;
    }

    public void setProfiles(Profile profiles) {
        this.profile = profiles;
    }
}
