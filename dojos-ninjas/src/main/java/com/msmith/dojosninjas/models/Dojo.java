package com.msmith.dojosninjas.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="dojos")
public class Dojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment id
	private Long id;
	
	// camel case variables
	@NotNull(message ="Cannot be empty")
	@Size(min=1, message="May not be left blank")
	private String name;
	
	@OneToMany(mappedBy="dojo", fetch=FetchType.LAZY) // mappedBy matches foreign key variable
	private List<Ninja> assignedNinjas;
	
	
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
    public Dojo() {}
    
    // Maybe overloaded constructor if we need it (really don't with data-binding)
    	
    // Getters Setters
    public Long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public List<Ninja> getAssignedNinjas() {
    	return assignedNinjas;
    }
    public void setAssignedNinjas(List<Ninja> assignedNinjas) {
    	this.assignedNinjas = assignedNinjas;
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
    
}
