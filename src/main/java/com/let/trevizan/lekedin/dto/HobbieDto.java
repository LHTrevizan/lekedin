package com.let.trevizan.lekedin.dto;

import com.let.trevizan.lekedin.models.Profile;

public class HobbieDto {

    private Long id;

    private String nameHobbie;

    private String description;

    private Long profileId;

    public HobbieDto() {
    }

    public HobbieDto(Long id, String nameHobbie, String description, Long profileId) {
        this.id = id;
        this.nameHobbie = nameHobbie;
        this.description = description;
        this.profileId = profileId;
    }

    public Long getId() {
        return id;
    }

    public String getNameHobbie() {
        return nameHobbie;
    }

    public String getDescription() {
        return description;
    }

    public Long getProfileId() {
        return profileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HobbieDto hobbieDto = (HobbieDto) o;

        if (getId() != null ? !getId().equals(hobbieDto.getId()) : hobbieDto.getId() != null) return false;
        if (!getNameHobbie().equals(hobbieDto.getNameHobbie())) return false;
        if (!getDescription().equals(hobbieDto.getDescription())) return false;
        return getProfileId().equals(hobbieDto.getProfileId());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getNameHobbie().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getProfileId().hashCode();
        return result;
    }
}
