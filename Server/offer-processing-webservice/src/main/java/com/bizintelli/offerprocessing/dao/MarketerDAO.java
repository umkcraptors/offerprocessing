package com.bizintelli.offerprocessing.dao;

import java.util.List;

import com.bizintelli.offerprocessing.entity.Marketer;
import com.bizintelli.offerprocessing.exception.DeleteFailedException;
import com.bizintelli.offerprocessing.exception.InsertFailedException;
import com.bizintelli.offerprocessing.exception.RetrieveFailedException;
import com.bizintelli.offerprocessing.exception.UpdateFailedException;

public interface MarketerDAO {
	
	public Marketer addMarketer(Marketer marketer) throws InsertFailedException;
	public Marketer updateMarketer(Marketer marketer) throws UpdateFailedException;
	public void deleteMarketer(long marketerId) throws DeleteFailedException, RetrieveFailedException;
	public Marketer getMarketer(long marketerId) throws RetrieveFailedException;
	public List<Marketer> getMarketers();

}
