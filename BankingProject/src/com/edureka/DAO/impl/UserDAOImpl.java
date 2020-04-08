package com.edureka.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.edureka.DAO.UserDAO;
import com.edureka.Model.User;

@Repository
public class UserDAOImpl implements UserDAO {

private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public User getUserById(int userId) {
		User user = hibernateTemplate.get(User.class, userId);
		return user;
	}

}
