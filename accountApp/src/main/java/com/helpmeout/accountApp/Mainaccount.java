package com.helpmeout.accountApp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Mainaccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer transaction_id;
	private Integer transaction_user_id;
	private String transaction_type;
	private String amount;
	private Date transaction_date;
	private Integer credit_id;
	private Integer end_user_money;
	private Double current_amount;
	public Mainaccount() {
		
	}
	public Integer getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Integer getTransaction_user_id() {
		return transaction_user_id;
	}
	public void setTransaction_user_id(Integer transaction_user_id) {
		this.transaction_user_id = transaction_user_id;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	public Integer getCredit_id() {
		return credit_id;
	}
	public void setCredit_id(Integer credit_id) {
		this.credit_id = credit_id;
	}
	public Integer getEnd_user_money() {
		return end_user_money;
	}
	public void setEnd_user_money(Integer end_user_money) {
		this.end_user_money = end_user_money;
	}
	public Double getCurrent_amount() {
		return current_amount;
	}
	public void setCurrent_amount(Double current_amount) {
		this.current_amount = current_amount;
	}
	@Override
	public String toString() {
		return "Mainaccount [transaction_id=" + transaction_id + ", transaction_user_id=" + transaction_user_id
				+ ", transaction_type=" + transaction_type + ", amount=" + amount + ", transaction_date="
				+ transaction_date + ", credit_id=" + credit_id + ", end_user_money=" + end_user_money
				+ ", current_amount=" + current_amount + "]";
	}
	public Mainaccount(Integer transaction_id, Integer transaction_user_id, String transaction_type, String amount,
			Date transaction_date, Integer credit_id, Integer end_user_money, Double current_amount) {
		this.transaction_id = transaction_id;
		this.transaction_user_id = transaction_user_id;
		this.transaction_type = transaction_type;
		this.amount = amount;
		this.transaction_date = transaction_date;
		this.credit_id = credit_id;
		this.end_user_money = end_user_money;
		this.current_amount = current_amount;
	}

}
