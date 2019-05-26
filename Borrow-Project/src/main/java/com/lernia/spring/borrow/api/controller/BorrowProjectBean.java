package com.lernia.spring.borrow.api.controller;

public class BorrowProjectBean {
	
	private Integer creditId;
	private Integer user_id; 	
	private Double inicial_amount;
	private Double current_amount;
	private Integer request_id;
	private Integer number_of_payments_left;
	private Double interest_rate;
	private Integer lenderOne;	
	private Integer lenderTwo;	
	private Integer lenderThree;	
	private Integer lenderFour;	
	private Integer lenderFive;	
	private Integer numberOfLenders;

	
	public Integer getCreditId() {
		return creditId;
	}


	public void setCreditId(Integer creditId) {
		this.creditId = creditId;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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
	


	public BorrowProjectBean(Integer creditId, Integer user_id, Double inicial_amount, Double current_amount,
			Integer request_id, Integer number_of_payments_left, Double interest_rate, Integer lenderOne,
			Integer lenderTwo, Integer lenderThree, Integer lenderFour, Integer lenderFive, Integer numberOfLenders) {
		super();
		this.creditId = creditId;
		this.user_id = user_id;
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
	}


	@Override
	public String toString() {
		return "BorrowProjectBean [creditId=" + creditId + ", user_id=" + user_id + ", inicial_amount=" + inicial_amount
				+ ", current_amount=" + current_amount + ", request_id=" + request_id + ", number_of_payments_left="
				+ number_of_payments_left + ", interest_rate=" + interest_rate + ", lenderOne=" + lenderOne
				+ ", lenderTwo=" + lenderTwo + ", lenderThree=" + lenderThree + ", lenderFour=" + lenderFour
				+ ", lenderFive=" + lenderFive + ", numberOfLenders=" + numberOfLenders + "]";
	}


	public BorrowProjectBean() {
		
	}
	
	
}
