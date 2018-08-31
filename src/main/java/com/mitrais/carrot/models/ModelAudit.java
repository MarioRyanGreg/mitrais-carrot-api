package com.mitrais.carrot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdTime", "lastModifiedTime" }, allowGetters = true)
public abstract class ModelAudit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "is_deleted")
	private Integer isDeteled;

	@CreatedDate
	@Column(name = "created_time", nullable = false, updatable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date createdTime;

	@Column(name = "created_by")
	private Integer createdBy;

	@LastModifiedDate
	@Column(name = "last_modified_time", nullable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date lastModifiedTime;

	@Column(name = "last_modified_by")
	private Integer lastModifiedBy;

	public Integer getIsDeteled() {
		return isDeteled;
	}

	public void setIsDeteled(Integer isDeteled) {
		this.isDeteled = isDeteled;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public Integer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
}
