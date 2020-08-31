package com.let.trevizan.lekedin.dto;

public class ProfessionalInterestDto {


    private 
 Long id;

    private 
 String professional;

    private 
 String knowledge;

    private 
 Long profileId;

    public ProfessionalInterestDto() {
    }

    public ProfessionalInterestDto(Long id, String professional, String knowledge, Long profileId) {
        this.id = id;
        this.professional = professional;
        this.knowledge = knowledge;
        this.profileId = profileId;
    }

    public Long getId() {
        return id;
    }

    public String getProfessional() {
        return professional;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public Long getProfileId() {
        return profileId;
    }
}
