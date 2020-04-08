package com.edureka.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="transactions_record")
public class Record implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="id")
	private int id;
	
	@Column(name="trans_date")
	private String trans_date;
	
	@Column(name="description")
	private String description;
	
	@Column(name="cheque_no")
	private Integer cheque_no;
	
	@Column(name="withdraw")
	private Integer withdraw;
	
	@Column(name="deposit")
	private Integer deposit;
	
	@Column(name="balance")
	private int balance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCheque_no() {
		return cheque_no;
	}

	public void setCheque_no(Integer cheque_no) {
		this.cheque_no = cheque_no;
	}

	public Integer getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Integer withdraw) {
		this.withdraw = withdraw;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", trans_date=" + trans_date + ", description=" + description + ", cheque_no="
				+ cheque_no + ", withdraw=" + withdraw + ", deposit=" + deposit + ", balance=" + balance + "]";
	}

	
}
