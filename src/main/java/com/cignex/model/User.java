package com.cignex.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "User")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String positionApplyFor;
	private String referenceName;
	private String referenceMobileNumber;
	private String email;
	private String mobileNumber;
	private String noticePeriod;
	private double ctc;
	private double ectc;
	private String reasonForChange;
	private String password;
	@OneToMany(mappedBy="user")
	private List<ResultQuiz> quizs=new ArrayList<ResultQuiz>();
	
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the positionApplyFor
	 */
	public String getPositionApplyFor() {
		return positionApplyFor;
	}
	/**
	 * @param positionApplyFor the positionApplyFor to set
	 */
	public void setPositionApplyFor(String positionApplyFor) {
		this.positionApplyFor = positionApplyFor;
	}
	/**
	 * @return the referenceName
	 */
	public String getReferenceName() {
		return referenceName;
	}
	/**
	 * @param referenceName the referenceName to set
	 */
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	/**
	 * @return the referenceMobileNumber
	 */
	public String getReferenceMobileNumber() {
		return referenceMobileNumber;
	}
	/**
	 * @param referenceMobileNumber the referenceMobileNumber to set
	 */
	public void setReferenceMobileNumber(String referenceMobileNumber) {
		this.referenceMobileNumber = referenceMobileNumber;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the noticePeriod
	 */
	public String getNoticePeriod() {
		return noticePeriod;
	}
	/**
	 * @param noticePeriod the noticePeriod to set
	 */
	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	/**
	 * @return the ctc
	 */
	public double getCtc() {
		return ctc;
	}
	/**
	 * @param ctc the ctc to set
	 */
	public void setCtc(double ctc) {
		this.ctc = ctc;
	}
	/**
	 * @return the ectc
	 */
	public double getEctc() {
		return ectc;
	}
	/**
	 * @param ectc the ectc to set
	 */
	public void setEctc(double ectc) {
		this.ectc = ectc;
	}
	/**
	 * @return the reasonForChange
	 */
	public String getReasonForChange() {
		return reasonForChange;
	}
	/**
	 * @param reasonForChange the reasonForChange to set
	 */
	public void setReasonForChange(String reasonForChange) {
		this.reasonForChange = reasonForChange;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", positionApplyFor="
				+ positionApplyFor + ", referenceName=" + referenceName + ", referenceMobileNumber="
				+ referenceMobileNumber + ", email=" + email + ", mobileNumber=" + mobileNumber + ", noticePeriod="
				+ noticePeriod + ", ctc=" + ctc + ", ectc=" + ectc + ", reasonForChange=" + reasonForChange + "]";
	}
	
	

}
