package com.let.trevizan.lekedin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ExperienceDto {

    private Long id;

    private String nameEmpresa;

    private String cargoEmpresa;

    private String descricao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private
    Date inicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private
    Date fim;

    private Long profileId;

    public ExperienceDto(Long id, String nameEmpresa, String cargoEmpresa, String descricao, Date inicio, Date fim, Long profileId) {
        this.id = id;
        this.nameEmpresa = nameEmpresa;
        this.cargoEmpresa = cargoEmpresa;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.profileId = profileId;
    }

    public ExperienceDto() {
    }

    public Long getId() {
        return id;
    }

    public String getNameEmpresa() {
        return nameEmpresa;
    }

    public String getCargoEmpresa() {
        return cargoEmpresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFim() {
        return fim;
    }

    public Long getProfileId() {
        return profileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperienceDto that = (ExperienceDto) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (!getNameEmpresa().equals(that.getNameEmpresa())) return false;
        if (!getCargoEmpresa().equals(that.getCargoEmpresa())) return false;
        if (!getDescricao().equals(that.getDescricao())) return false;
        if (!getInicio().equals(that.getInicio())) return false;
        if (!getFim().equals(that.getFim())) return false;
        return getProfileId().equals(that.getProfileId());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getNameEmpresa().hashCode();
        result = 31 * result + getCargoEmpresa().hashCode();
        result = 31 * result + getDescricao().hashCode();
        result = 31 * result + getInicio().hashCode();
        result = 31 * result + getFim().hashCode();
        result = 31 * result + getProfileId().hashCode();
        return result;
    }
}

