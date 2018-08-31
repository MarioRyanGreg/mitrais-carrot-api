package com.mitrais.carrot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bazaar")
@JsonIgnoreProperties(
        value = {"createdTime", "lastModifiedTime"},
        allowGetters = true
)
public class Bazaar extends ModelAudit {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotNull
    @Size(max = 50)
    @Column(name = "bazar_name")
    private String bazarName;

    @Column(name = "start_period")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startPeriode;

    @Column(name = "end_period")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endPeriode;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    private Integer status;

    @OneToOne
    private BazaarItem bazaarItem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBazarName() {
        return bazarName;
    }

    public void setBazarName(String bazarName) {
        this.bazarName = bazarName;
    }

    public Date getStartPeriode() {
        return startPeriode;
    }

    public void setStartPeriode(Date startPeriode) {
        this.startPeriode = startPeriode;
    }

    public Date getEndPeriode() {
        return endPeriode;
    }

    public void setEndPeriode(Date endPeriode) {
        this.endPeriode = endPeriode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}