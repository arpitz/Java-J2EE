package com.edureka.Client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edureka.Model.MobilePhone;
import com.edureka.Service.MobilePhoneService;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		MobilePhoneService mobileService = ctx.getBean("mobileService", MobilePhoneService.class);
		
		// insertMobiles(mobileService);
		
		// updateMobile(mobileService);
		
		deleteMobile(mobileService);
		
		ctx.close();

	}
	
	private static void insertMobiles(MobilePhoneService mobileService){
		MobilePhone m1 = new MobilePhone();
		m1.setName("Iphone 7");
		m1.setManufacturer("Apple");
		m1.setPrice(50000);
		m1.setColor("Black");
		mobileService.saveMobile(m1);
		
		MobilePhone m2 = new MobilePhone();
		m2.setName("Galaxy");
		m2.setManufacturer("Samsung");
		m2.setPrice(43000);
		m2.setColor("Silver");
		mobileService.saveMobile(m2);
		
		MobilePhone m3 = new MobilePhone();
		m3.setName("Zenfone 2");
		m3.setManufacturer("Asus");
		m3.setPrice(30000);
		m3.setColor("Golden");
		mobileService.saveMobile(m3);
		
		MobilePhone m4 = new MobilePhone();
		m4.setName("Iphone X");
		m4.setManufacturer("Apple");
		m4.setPrice(88000);
		m4.setColor("Black");
		mobileService.saveMobile(m4);
		
		MobilePhone m5 = new MobilePhone();
		m5.setName("E6");
		m5.setManufacturer("Nokia");
		m5.setPrice(33000);
		m5.setColor("Blue");
		mobileService.saveMobile(m5);
	}

	private static void updateMobile(MobilePhoneService mobileService){
		mobileService.updateMobileById(99000, 4);
	}
	
	private static void deleteMobile(MobilePhoneService mobileService){
		mobileService.deleteMobileById(5);
	}
}
