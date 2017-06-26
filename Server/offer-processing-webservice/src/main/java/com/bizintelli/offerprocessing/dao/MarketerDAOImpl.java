package com.bizintelli.offerprocessing.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bizintelli.offerprocessing.entity.Marketer;
import com.bizintelli.offerprocessing.exception.DeleteFailedException;
import com.bizintelli.offerprocessing.exception.InsertFailedException;
import com.bizintelli.offerprocessing.exception.RetrieveFailedException;
import com.bizintelli.offerprocessing.exception.UpdateFailedException;
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
			
			StringWriter stack = new StringWriter();
			e.printStackTrace(new PrintWriter(stack));			
			LOG.error("Exception" +stack );
			throw new InsertFailedException("Failed to insert Marketer"+ e);
		}
		finally{
		}
		return marketer;		
	}

	@Transactional(readOnly=false)
	public Marketer updateMarketer(Marketer marketer) throws UpdateFailedException 
	{
		LOG.info("updating Marketers");
		try{
			entityManager.merge(marketer);
		}catch(Exception e){
			LOG.error("Exception" +e);
			throw new UpdateFailedException("Failed to Update Marketer"+ e);
		}
		finally{
		}
		return marketer;
	}

	@Transactional(readOnly=false)
	public void deleteMarketer(long marketerId) throws DeleteFailedException, RetrieveFailedException
	{
		LOG.info("Deleting Marketers");
		Marketer cusomer;
		
			cusomer = getMarketer(marketerId);
		
		try{
			entityManager.remove(cusomer);
		}catch(Exception e){
			LOG.error("Exception" +e);
			throw new DeleteFailedException("Failed to Delete Marketer"+ e);
			
		}
		
		LOG.info("Marketer Deleted");
	}

	@Transactional(readOnly=true)
	public Marketer getMarketer(long marketerId) throws RetrieveFailedException
	{
		String sql = "select marketer from Marketer marketer where marketer.id="+marketerId;
		try{
			return (Marketer) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
			LOG.error(e.getStackTrace().toString());
			LOG.error("Exception", e);
			throw new RetrieveFailedException("Failed to Retrieve Marketer"+ e);
		}
	}

	@Transactional(readOnly=true)
	public List<Marketer> getMarketers() {
		LOG.info("Getting Marketers");
		return entityManager.createQuery("select marketer from Marketer marketer").getResultList();
	}

}
