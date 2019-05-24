package com.kenzanservice.main.db;

import java.text.SimpleDateFormat;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/*
 * The Employee entity for the Kenzan App
 */
@Entity
@Table(name = "employees")
public class Employee {
	@Transient
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
	@Transient
	private String deleteOp;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    
    private String middleInitial;
    
    private String lastName;
   
    private Date dateOfBirth;
   
    private Date dateOfEmployment;
    
    private String status;
    @Transient
    private String stringDateBirth;
    @Transient
    private String stringDateOfEmployment;
    
    public String getDeleteOp() {
		return deleteOp;
	}

	public void setDeleteOp(String deleteOp) {
		this.deleteOp = deleteOp;
	}

    public void setStringDateBirth(String stringDateBirth) {
		this.stringDateBirth = stringDateBirth;
	}

	public void setStringDateOfEmployment(String stringDateOfEmployment) {
		this.stringDateOfEmployment = stringDateOfEmployment;
	}

	public String getStringDateBirth() {
    	if(this.dateOfBirth!=null)
		 return format.format(this.dateOfBirth);
    	else
    	return stringDateBirth;
	}

	public String getStringDateOfEmployment() {
		if(this.dateOfEmployment!=null)
		return format.format(this.dateOfEmployment);
		else
		return stringDateOfEmployment;	
	}

	public Employee() {
    	
    }
    
 
    public Employee(String firstName, String middleInitial,String lastName,Date dateOfBirth, Date dateOfEmployment,String status) {
        this.firstName=firstName;
        this.middleInitial=middleInitial;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
        this.dateOfEmployment=dateOfEmployment;
        this.status=status;
      
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
  

    @Override
    public String toString() {
    	
    	return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + format.format(dateOfBirth) + '\'' +
                ", dateOfEmployment='" + format.format(dateOfEmployment) + '\'' +
                ", status=" + status +
                '}';
    }
    
}