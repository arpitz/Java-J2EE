package com.edureka.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	@Column(name="basic")
	private Integer basic;
	@Column(name="hra")
	private Integer hra;
	@Column(name="da")
	private Integer da;
	@Column(name="deductions")
	private Integer deductions;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBasic() {
		return basic;
	}
	public void setBasic(Integer basic) {
		this.basic = basic;
	}
	public Integer getHra() {
		return hra;
	}
	public void setHra(Integer hra) {
		this.hra = hra;
	}
	public Integer getDa() {
		return da;
	}
	public void setDa(Integer da) {
		this.da = da;
	}
	public Integer getDeductions() {
		return deductions;
	}
	public void setDeductions(Integer deductions) {
		this.deductions = deductions;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", basic=" + basic + ", hra=" + hra + ", da=" + da
				+ ", deductions=" + deductions + "]";
	}
}
