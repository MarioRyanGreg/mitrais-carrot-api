package com.mitrais.carrot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "barn_setting", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "role_name"
    })
})
@JsonIgnoreProperties(
        value = {"createdTime", "lastModifiedTime"},
        allowGetters = true
)
public class BarnSetting extends ModelAudit {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "role_name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    private Integer carrot;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    @Column(name = "is_released")
    private Integer isReleased;

    @OneToOne
    private Barn barn;

    @OneToOne
    private Rewards rewards;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCarrot() {
        return carrot;
    }

    public void setCarrot(Integer carrot) {
        this.carrot = carrot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIsReleased() {
        return isReleased;
    }

    public void setIsReleased(Integer isReleased) {
        this.isReleased = isReleased;
    }

    public Barn getBarn() {
        return barn;
    }

    public void setBarn(Barn barn) {
        this.barn = barn;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public void setRewards(Rewards rewards) {
        this.rewards = rewards;
    }
}