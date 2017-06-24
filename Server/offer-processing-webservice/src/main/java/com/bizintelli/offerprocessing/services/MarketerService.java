package com.bizintelli.offerprocessing.services;

import java.util.Date;
import java.util.List;

import com.bizintelli.offerprocessing.entity.Marketer;
import com.bizintelli.offerprocessing.exception.InsertFailedException;

public interface MarketerService {
	
	public Marketer addMarketer(Marketer marketer) throws InsertFailedException;
	public Marketer updateMarketer(Marketer marketer);
	public Marketer getMarketer(long marketerId);
	public List<Marketer> getAllMarketers();
	public  void deleteMarketer(long marketerId);
}
