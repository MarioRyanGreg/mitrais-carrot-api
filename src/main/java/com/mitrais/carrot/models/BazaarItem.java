package com.mitrais.carrot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item")
@JsonIgnoreProperties(
        value = {"createdTime", "lastModifiedTime"},
        allowGetters = true
)
public class BazaarItem extends ModelAudit {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    private String picture;

    @Column(name = "exchange_rate")
    private Float exchangeRate;

    @Column(name = "total_item")
    private Integer totalItem;

    @Column(name = "auto_approve_transactions")
    private Integer autoApproveTransactions;

    @Column(name = "item_on_sale")
    private Integer itemOnSale;

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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Float getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Integer getAutoApproveTransactions() {
        return autoApproveTransactions;
    }

    public void setAutoApproveTransactions(Integer autoApproveTransactions) {
        this.autoApproveTransactions = autoApproveTransactions;
    }

    public Integer getItemOnSale() {
        return itemOnSale;
    }

    public void setItemOnSale(Integer itemOnSale) {
        this.itemOnSale = itemOnSale;
    }
}