package com.bizintelli.offerprocessing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bizintelli.offerprocessing.entity.Marketer;
import com.bizintelli.offerprocessing.exception.InsertFailedException;
import com.bizintelli.offerprocessing.rest.conroller.MarketerController;

@Repository("marketerDAO")
@Transactional
public class MarketerDAOImpl implements MarketerDAO{
	
	Logger  LOG = Logger.getLogger(MarketerDAOImpl.class.getName());
	@PersistenceContext
	public EntityManager entityManager;

	@Transactional(readOnly=false)
	public Marketer addMarketer(Marketer marketer) throws InsertFailedException
	{
		LOG.info("Adding Marketers");
		try{
			entityManager.persist(marketer);
		}catch(Exception e){
			LOG.error("Exception" +e );
			throw new InsertFailedException("Failed to insert Marketer"+ e);
		}
		finally{
		}
		return marketer;		
	}

	@Transactional(readOnly=false)
	public Marketer updateMarketer(Marketer marketer) {
		LOG.info("updating Marketers");
		try{
			entityManager.merge(marketer);
		}catch(Exception e){
			LOG.error("Exception" +e);
		}
		finally{
		}
		return marketer;
	}

	@Transactional(readOnly=false)
	public void deleteMarketer(long marketerId) {
		LOG.info("Deleting Marketers");
		Marketer cusomer = getMarketer(marketerId);
		try{
			entityManager.remove(cusomer);
		}catch(Exception e){
			LOG.error("Exception" +e);
		}
		
		LOG.info("Marketer Deleted");
	}

	@Transactional(readOnly=true)
	public Marketer getMarketer(long marketerId) {
		String sql = "select marketer from Marketer marketer where marketer.id="+marketerId;
		try{
			return (Marketer) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
			LOG.error(e.getStackTrace().toString());
			LOG.error("Exception", e);
		}
		return null;
	}

	@Transactional(readOnly=true)
	public List<Marketer> getMarketers() {
		LOG.info("Getting Marketers");
		return entityManager.createQuery("select marketer from Marketer marketer").getResultList();
	}

}
