package com.edureka.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="mobiles")
public class MobilePhone {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="id")
	private Integer Id;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="name")
	private String name;
	
	@Column(name="color")
	private String color;
	
	@Column(name="price")
	private Integer price;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "MobilePhone [Id=" + Id + ", manufacturer=" + manufacturer + ", name=" + name + ", color=" + color
				+ ", price=" + price + "]";
	}

}
