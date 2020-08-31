package com.let.trevizan.lekedin.dto;

public class EducationalDto {

    private Long id;

    private String school;

    private String degree;

    private Long tempo;

    private Long profileId;


    public EducationalDto(Long id, String school, String degree, Long tempo, Long profileId) {
        this.id = id;
        this.school = school;
        this.degree = degree;
        this.tempo = tempo;
        this.profileId = profileId;
    }

    public EducationalDto() {
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

    public Long getProfileId() {
        return profileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EducationalDto that = (EducationalDto) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (!getSchool().equals(that.getSchool())) return false;
        if (!getDegree().equals(that.getDegree())) return false;
        if (!getTempo().equals(that.getTempo())) return false;
        return getProfileId().equals(that.getProfileId());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getSchool().hashCode();
        result = 31 * result + getDegree().hashCode();
        result = 31 * result + getTempo().hashCode();
        result = 31 * result + getProfileId().hashCode();
        return result;
    }
}

