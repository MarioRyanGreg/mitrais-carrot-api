package com.mitrais.carrot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sharing_type", uniqueConstraints = { @UniqueConstraint(columnNames = { "sharing_type" }) })
@JsonIgnoreProperties(value = { "createdTime", "lastModifiedTime" }, allowGetters = true)
public class ShareType extends ModelAudit {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Size(max = 50)
	@Column(name = "sharing_type")
	private String sharingType;

	@NotNull
	private Integer carrot;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSharingType() {
		return sharingType;
	}

	public void setSharingType(String sharingType) {
		this.sharingType = sharingType;
	}

	public Integer getCarrot() {
		return carrot;
	}

	public void setCarrot(Integer carrot) {
		this.carrot = carrot;
	}
}