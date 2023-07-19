package com.msmith.travels.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="costs")
public class Travel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment id
	private Long id;
	// camel case variables
	@NotNull(message ="Cannot be empty")
	@Size(min=1, message="May not be left blank")
	private String expense;
	
	@NotNull(message ="Cannot be empty")
	@Size(min=1, message="May not be left blank")
	private String vendor;
	
	@NotNull(message ="Cannot be empty")
	@Size(min=1, message="May not be left blank")
	private String description;
	
	@NotNull(message ="Cannot be empty")
	@Min(0)
	private Double amount;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // Methods for auto-create created/updated\at
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    // Zero-Argument constructor
    public Travel() {}
    
    // Maybe overloaded constructor if we need it
    public Travel(String expense, String vendor, Double amount, String description) {
    	this.expense = expense;
    	this.vendor = vendor;
    	this.amount = amount;
    	this.description = description;
    }
    // Getter Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
