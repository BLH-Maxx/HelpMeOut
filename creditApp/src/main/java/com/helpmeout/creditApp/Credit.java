package com.helpmeout.creditApp;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Credit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "credit_id")
	private Integer creditId;

	@Column(name = "user_id")
	private Integer userId;
	private BigDecimal inicial_amount;
	private BigDecimal current_amount;
	private Integer request_id;
	private Integer number_of_payments_left;
	private Double interest_rate;
	@Column(name = "lender_one")
	private Integer lenderOne;

	@Column(name = "lender_two")
	private Integer lenderTwo;

	@Column(name = "lender_three")
	private Integer lenderThree;

	@Column(name = "lender_four")
	private Integer lenderFour;

	@Column(name = "lender_five")
	private Integer lenderFive;

	@Column(name = "number_of_lenders")
	private Integer numberOfLenders;

	private Date date_of_deposite;
	private Double next_payment;

	public Credit(Integer creditId, Integer userId, BigDecimal inicial_amount, BigDecimal current_amount,
			Integer request_id, Integer number_of_payments_left, Double interest_rate, Integer lenderOne,
			Integer lenderTwo, Integer lenderThree, Integer lenderFour, Integer lenderFive, Integer numberOfLenders,
			Date date_of_deposite, Double next_payment) {
		super();
		this.creditId = creditId;
		this.userId = userId;
		this.inicial_amount = inicial_amount;
		this.current_amount = current_amount;
		this.request_id = request_id;
		this.number_of_payments_left = number_of_payments_left;
		this.interest_rate = interest_rate;
		this.lenderOne = lenderOne;
		this.lenderTwo = lenderTwo;
		this.lenderThree = lenderThree;
		this.lenderFour = lenderFour;
		this.lenderFive = lenderFive;
		this.numberOfLenders = numberOfLenders;
		this.date_of_deposite = date_of_deposite;
		this.next_payment = next_payment;
	}

	@Override
	public String toString() {
		return "Credit [creditId=" + creditId + ", userId=" + userId + ", inicial_amount=" + inicial_amount
				+ ", current_amount=" + current_amount + ", request_id=" + request_id + ", number_of_payments_left="
				+ number_of_payments_left + ", interest_rate=" + interest_rate + ", lenderOne=" + lenderOne
				+ ", lenderTwo=" + lenderTwo + ", lenderThree=" + lenderThree + ", lenderFour=" + lenderFour
				+ ", lenderFive=" + lenderFive + ", numberOfLenders=" + numberOfLenders + ", date_of_deposite="
				+ date_of_deposite + ", next_payment=" + next_payment + "]";
	}

	public Integer getCreditId() {
		return creditId;
	}

	public void setCreditId(Integer creditId) {
		this.creditId = creditId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getInicial_amount() {
		return inicial_amount;
	}

	public void setInicial_amount(BigDecimal inicial_amount) {
		this.inicial_amount = inicial_amount;
	}

	public BigDecimal getCurrent_amount() {
		return current_amount;
	}

	public void setCurrent_amount(BigDecimal current_amount) {
		this.current_amount = current_amount;
	}

	public Integer getRequest_id() {
		return request_id;
	}

	public void setRequest_id(Integer request_id) {
		this.request_id = request_id;
	}

	public Integer getNumber_of_payments_left() {
		return number_of_payments_left;
	}

	public void setNumber_of_payments_left(Integer number_of_payments_left) {
		this.number_of_payments_left = number_of_payments_left;
	}

	public Double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(Double interest_rate) {
		this.interest_rate = interest_rate;
	}

	public Integer getLenderOne() {
		return lenderOne;
	}

	public void setLenderOne(Integer lenderOne) {
		this.lenderOne = lenderOne;
	}

	public Integer getLenderTwo() {
		return lenderTwo;
	}

	public void setLenderTwo(Integer lenderTwo) {
		this.lenderTwo = lenderTwo;
	}

	public Integer getLenderThree() {
		return lenderThree;
	}

	public void setLenderThree(Integer lenderThree) {
		this.lenderThree = lenderThree;
	}

	public Integer getLenderFour() {
		return lenderFour;
	}

	public void setLenderFour(Integer lenderFour) {
		this.lenderFour = lenderFour;
	}

	public Integer getLenderFive() {
		return lenderFive;
	}

	public void setLenderFive(Integer lenderFive) {
		this.lenderFive = lenderFive;
	}

	public Integer getNumberOfLenders() {
		return numberOfLenders;
	}

	public void setNumberOfLenders(Integer numberOfLenders) {
		this.numberOfLenders = numberOfLenders;
	}

	public Date getDate_of_deposite() {
		return date_of_deposite;
	}

	public void setDate_of_deposite(Date date_of_deposite) {
		this.date_of_deposite = date_of_deposite;
	}

	public Double getNext_payment() {
		return next_payment;
	}

	public void setNext_payment(Double next_payment) {
		this.next_payment = next_payment;
	}

	public Credit() {

	}

}
