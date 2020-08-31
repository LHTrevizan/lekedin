package com.let.trevizan.lekedin.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EXPERIENCE")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameEmpresa;

    private String cargoEmpresa;

    private String descricao;

    private Date inicio;

    private Date fim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileId")
    private Profile profile;

    public Experience() {
    }

    public Experience(Long id, String nameEmpresa, String cargoEmpresa, String descricao, Date inicio, Date fim, Profile profile) {
        this.id = id;
        this.nameEmpresa = nameEmpresa;
        this.cargoEmpresa = cargoEmpresa;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEmpresa() {
        return nameEmpresa;
    }

    public void setNameEmpresa(String nameEmpresa) {
        this.nameEmpresa = nameEmpresa;
    }

    public String getCargoEmpresa() {
        return cargoEmpresa;
    }

    public void setCargoEmpresa(String cargoEmpresa) {
        this.cargoEmpresa = cargoEmpresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Profile getProfiles() {
        return profile;
    }

    public void setProfiles(Profile profiles) {
        this.profile = profile;
    }
}
