package com.bizintelli.offerprocessing.dao;

import java.util.List;

import com.bizintelli.offerprocessing.entity.Marketer;
import com.bizintelli.offerprocessing.exception.InsertFailedException;

public interface MarketerDAO {
	
	public Marketer addMarketer(Marketer marketer) throws InsertFailedException;
	public Marketer updateMarketer(Marketer marketer);
	public void deleteMarketer(long marketerId);
	public Marketer getMarketer(long marketerId);
	public List<Marketer> getMarketers();

}
