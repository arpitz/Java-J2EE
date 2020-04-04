package com.edureka.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edureka.DAO.MobilePhoneDAO;
import com.edureka.Model.MobilePhone;

@Service("mobileService")
public class MobilePhoneService {

	private MobilePhoneDAO mobilePhoneDAO;

	@Autowired
	public void setMobilePhoneDAO(MobilePhoneDAO mobilePhoneDAO) {
		this.mobilePhoneDAO = mobilePhoneDAO;
	}
	
	public void saveMobile(MobilePhone m){
		mobilePhoneDAO.saveMobile(m);
	}
	
	public void updateMobileById(Integer price, Integer id){
		mobilePhoneDAO.updateMobileById(price, id);
	}
	
	public void deleteMobileById(Integer id){
		mobilePhoneDAO.deleteMobileById(id);
	}
	
	
}
