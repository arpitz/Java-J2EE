package com.edureka.DAO;

import java.util.List;

import com.edureka.Model.Record;

public interface RecordDAO {
	
	public abstract List<Record> fetchAllRecords(String fromDate, String toDate);

}
