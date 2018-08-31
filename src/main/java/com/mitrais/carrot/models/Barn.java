package com.mitrais.carrot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "barn", uniqueConstraints = { @UniqueConstraint(columnNames = { "role_name" }) })
@JsonIgnoreProperties(value = { "createdTime", "lastModifiedTime" }, allowGetters = true)
public class Barn extends ModelAudit {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(max = 50)
	@Column(name = "role_name")
	private String name;

	@Column(name = "start_periode")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date startPeriode;

	@Column(name = "end_periode")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date endPeriode;

	private String owner;

	@Column(name = "carrot_per_employee")
	private Integer carrotPerEmployee;

	@Column(name = "total_carrot")
	private Integer totalCarrot;

	private Integer status;

	@Column(name = "is_released")
	private Integer isReleased;

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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Integer getCarrotPerEmployee() {
		return carrotPerEmployee;
	}

	public void setCarrotPerEmployee(Integer carrotPerEmployee) {
		this.carrotPerEmployee = carrotPerEmployee;
	}

	public Integer getTotalCarrot() {
		return totalCarrot;
	}

	public void setTotalCarrot(Integer totalCarrot) {
		this.totalCarrot = totalCarrot;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsReleased() {
		return isReleased;
	}

	public void setIsReleased(Integer isReleased) {
		this.isReleased = isReleased;
	}
}