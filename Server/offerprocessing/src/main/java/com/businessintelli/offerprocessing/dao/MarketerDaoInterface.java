package com.businessintelli.offerprocessing.dao;

import java.io.Serializable;
import java.util.List;
import com.businessintelli.offerprocessing.model.*;

public interface MarketerDaoInterface<Marketer, Id extends Serializable> {

	public   void persist(Marketer entity);

	public void update(Marketer entity);
	

	public Marketer findById(Id id);

	public void delete(Marketer entity);

	public List<Marketer> findAll();

	public void deleteAll();

}
