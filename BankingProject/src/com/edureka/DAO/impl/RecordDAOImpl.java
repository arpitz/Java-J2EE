package com.edureka.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.edureka.DAO.RecordDAO;
import com.edureka.Model.Record;

@Repository
public class RecordDAOImpl implements RecordDAO {

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public List<Record> fetchAllRecords(String fromDate, String toDate){		
		@SuppressWarnings("unchecked")
		List<Record> recordsList = (List<Record>) hibernateTemplate.
			find("from Record where trans_date BETWEEN ? AND ? order by trans_date", fromDate, toDate);		
		return recordsList;
	}
}
