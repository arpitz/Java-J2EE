package com.edureka.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.edureka.Model.MobilePhone;

@Repository
public class MobilePhoneDAO {
	
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void saveMobile(MobilePhone m){
		hibernateTemplate.setCheckWriteOperations(false);
		hibernateTemplate.save(m);
	}
	
	public void updateMobileById(Integer price, Integer id){
		MobilePhone m = hibernateTemplate.get(MobilePhone.class, id);
		m.setPrice(price);
		hibernateTemplate.setCheckWriteOperations(false);
		hibernateTemplate.update(m);
	}
	
	public void deleteMobileById(Integer id){
		MobilePhone m = new MobilePhone();
		m.setId(id);
		hibernateTemplate.setCheckWriteOperations(false);
		hibernateTemplate.delete(m);
	}

}
