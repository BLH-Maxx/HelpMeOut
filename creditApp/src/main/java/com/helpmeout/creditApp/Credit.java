package com.helpmeout.creditApp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Credit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "credit_id")
	private Integer creditId;
	
	@Column(name = "user_id")
	private Integer userId; 
	
	private Double inicial_amount;
	private Double current_amount;
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
	public Integer getCredit_id() {
		return creditId;
	}
	public void setCredit_id(Integer credit_id) {
		this.creditId = credit_id;
	}
	public Integer getUser_id() {
		return userId;
	}
	public void setUser_id(Integer user_id) {
		this.userId = user_id;
	}
	public Double getInicial_amount() {
		return inicial_amount;
	}
	public void setInicial_amount(Double inicial_amount) {
		this.inicial_amount = inicial_amount;
	}
	public Double getCurrent_amount() {
		return current_amount;
	}
	public void setCurrent_amount(Double current_amount) {
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
	public Integer getLender_one() {
		return lenderOne;
	}
	public void setLender_one(Integer lender_one) {
		this.lenderOne = lender_one;
	}
	public Integer getLender_two() {
		return lenderTwo;
	}
	public void setLender_two(Integer lender_two) {
		this.lenderTwo = lender_two;
	}
	public Integer getLender_three() {
		return lenderThree;
	}
	public void setLender_three(Integer lender_three) {
		this.lenderThree = lender_three;
	}
	public Integer getLender_four() {
		return lenderFour;
	}
	public void setLender_four(Integer lender_four) {
		this.lenderFour = lender_four;
	}
	public Integer getLender_five() {
		return lenderFive;
	}
	public void setLender_five(Integer lender_five) {
		this.lenderFive = lender_five;
	}
	public Integer getNumber_of_lenders() {
		return numberOfLenders;
	}
	public void setNumber_of_lenders(Integer number_of_lenders) {
		this.numberOfLenders = number_of_lenders;
	}
	public Date getDate_of_deposite() {
		return date_of_deposite;
	}
	public void setDate_of_deposite(Date date_of_deposite) {
		this.date_of_deposite = date_of_deposite;
	}
	@Override
	public String toString() {
		return "credit [credit_id=" + creditId + ", user_id=" + userId + ", inicial_amount=" + inicial_amount
				+ ", current_amount=" + current_amount + ", request_id=" + request_id + ", number_of_payments_left="
				+ number_of_payments_left + ", interest_rate=" + interest_rate + ", lender_one=" + lenderOne
				+ ", lender_two=" + lenderTwo + ", lender_three=" + lenderThree + ", lender_four=" + lenderFour
				+ ", lender_five=" + lenderFive + ", number_of_lenders=" + numberOfLenders + ", date_of_deposite="
				+ date_of_deposite + "]";
	}
	public Credit(Integer credit_id, Integer user_id, Double inicial_amount, Double current_amount, Integer request_id,
			Integer number_of_payments_left, Double interest_rate, Integer lender_one, Integer lender_two,
			Integer lender_three, Integer lender_four, Integer lender_five, Integer number_of_lenders,
			Date date_of_deposite) {
		this.creditId = credit_id;
		this.userId = user_id;
		this.inicial_amount = inicial_amount;
		this.current_amount = current_amount;
		this.request_id = request_id;
		this.number_of_payments_left = number_of_payments_left;
		this.interest_rate = interest_rate;
		this.lenderOne = lender_one;
		this.lenderTwo = lender_two;
		this.lenderThree = lender_three;
		this.lenderFour = lender_four;
		this.lenderFive = lender_five;
		this.numberOfLenders = number_of_lenders;
		this.date_of_deposite = date_of_deposite;
	}
	
	public Credit() {
		
	}
	
}
