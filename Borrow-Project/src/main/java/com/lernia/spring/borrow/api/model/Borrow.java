package com.lernia.spring.borrow.api.model;

import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "borrow_requests")
@DynamicUpdate
public class Borrow {

	@Id
	@Column(name = "borrow_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int borrowId;

	// @NotNull
	@Column(name = "user_id")
	private int userId;

	@NotNull
	@Column(name = "user_name")
	private String userName;

	@NotNull
	@Column(name = "requested_amount")
	private int requestedAmount;
	
	@NotNull
	@Column(name = "remaining_amount")
	private int remainingAmount;

	@NotNull
	@Column(name = "period")
	private int period;

	@NotNull
	@Column(name = "requested_date")
	private LocalDate requestedDate;

	@NotNull
	@Column(name = "requested_time")
	private Instant requestedTime;

	@NotNull
	@Column(name = "eligible")
	private Boolean eligible;

	@NotNull
	@Column(name = "reason")
	private String reason;

	public enum Status {
		PENDING, REJECTED, APPROVED
	}

	@NotNull
	@Column(name = "status")
	private String status;
	
	@Column(name = "lender_one")
	private Integer lenderOneId;
	
	@Column(name = "lender_two")
	private Integer lenderTwoId;
	
	@Column(name = "lender_three")
	private Integer lenderThreeId;
	
	@Column(name = "lender_four")
	private Integer lenderFourId;
	
	@Column(name = "lender_five")
	private Integer lenderFiveId;
	
	@Column(name = "number_of_lenders")
	private Integer numberOfLenders;

	public Borrow(@NotNull int requested_amount, @NotNull int period, @NotNull String reason) {
		super();
		this.requestedAmount = requested_amount;
		this.period = period;
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Borrow [borrow_id=" + borrowId + ", user_id=" + userId + ", user_name=" + userName
				+ ", requested_amount=" + requestedAmount + ", period=" + period + ", requested_date=" + requestedDate
				+ ", requested_time=" + requestedTime + ", eligible=" + eligible + ", reason=" + reason + ", status="
				+ status + "]";
	}


	
	public int getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(int requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	public int getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public LocalDate getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(LocalDate requestedDate) {
		this.requestedDate = requestedDate;
	}

	public Instant getRequestedTime() {
		return requestedTime;
	}

	public void setRequestedTime(Instant requestedTime) {
		this.requestedTime = requestedTime;
	}

	public Boolean getEligible() {
		return eligible;
	}

	public void setEligible(Boolean eligible) {
		this.eligible = eligible;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getLenderOneId() {
		return lenderOneId;
	}

	public void setLenderOneId(Integer lenderOneId) {
		this.lenderOneId = lenderOneId;
	}

	public Integer getLenderTwoId() {
		return lenderTwoId;
	}

	public void setLenderTwoId(Integer lenderTwoId) {
		this.lenderTwoId = lenderTwoId;
	}

	public Integer getLenderThreeId() {
		return lenderThreeId;
	}

	public void setLenderThreeId(Integer lenderThreeId) {
		this.lenderThreeId = lenderThreeId;
	}

	public Integer getLenderFourId() {
		return lenderFourId;
	}

	public void setLenderFourId(Integer lenderFourId) {
		this.lenderFourId = lenderFourId;
	}

	public Integer getLenderFiveId() {
		return lenderFiveId;
	}

	public void setLenderFiveId(Integer lenderFiveId) {
		this.lenderFiveId = lenderFiveId;
	}

	public Integer getNumberOfLenders() {
		return numberOfLenders;
	}

	public void setNumberOfLenders(Integer numberOfLenders) {
		this.numberOfLenders = numberOfLenders;
	}

	public Borrow() {
		
	}
	

}
