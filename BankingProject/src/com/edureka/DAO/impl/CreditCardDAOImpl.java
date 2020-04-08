package com.edureka.DAO.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.edureka.DAO.CreditCardDAO;
import com.edureka.Model.CreditCard;

@Repository
public class CreditCardDAOImpl implements CreditCardDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public CreditCard authorizeCardDetails(CreditCard creditCard) {
		
		String cardNumber = creditCard.getCardNumber();
		
		DetachedCriteria criteria = DetachedCriteria.forClass(CreditCard.class);
		@SuppressWarnings("unchecked")
		List<CreditCard> cardList = (List<CreditCard>) hibernateTemplate.findByCriteria(criteria);
		
		for (CreditCard cCard : cardList) {
			if(cardNumber.equals(cCard.getCardNumber())){
				return cCard;
			}
		}
		return null;

	}

}
