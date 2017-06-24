package com.bizintelli.offerprocessing.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bizintelli.offerprocessing.dao.MarketerDAO;
import com.bizintelli.offerprocessing.dao.MarketerDAOImpl;
import com.bizintelli.offerprocessing.entity.Marketer;
import com.bizintelli.offerprocessing.exception.InsertFailedException;

@Service("marketerService")
@Transactional
public class MarketerServiceImpl implements MarketerService {

	Logger  LOG = Logger.getLogger(MarketerServiceImpl.class.getName());
	@Autowired(required=true)
	@Qualifier("marketerDAO")
	private MarketerDAO marketerDAO;
	
	@Transactional
	public Marketer addMarketer(Marketer marketer) throws  InsertFailedException{
		LOG.info("adding Marketers");
		System.out.println("Marketer Service create invoked:");
		marketer = marketerDAO.addMarketer(marketer);
		LOG.error("Marketer added");
		return marketer;
	}
	@Transactional
	public Marketer updateMarketer(Marketer marketer) {
		LOG.info("updating Marketers");
		System.out.println("Marketer Service Update invoked:");
		marketer = marketerDAO.updateMarketer(marketer);
		LOG.debug(" Marketer updated");
		return marketer;
		
	}

	public Marketer getMarketer(long marketerId) {
		LOG.info("getMarketers for " + marketerId);
		try
		{
			Marketer mrkt = marketerDAO.getMarketer(marketerId);
			LOG.info("Received marketer details..." + mrkt.getName());
			return mrkt;
		}
		catch(Exception ex)
		{
			LOG.info("Received marketer details exception..." ,ex);			
		}
		return null;
	}

	public List<Marketer> getAllMarketers() {
		return marketerDAO.getMarketers();
	}
	@Transactional
	public void deleteMarketer(long marketerId) {
		LOG.info("Deleting Marketer with " + marketerId);
		marketerDAO.deleteMarketer(marketerId);
	}


}
