package com.bizintelli.offerprocessing.services;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bizintelli.offerprocessing.dao.MarketerDAO;
import com.bizintelli.offerprocessing.dao.MarketerDAOImpl;
import com.bizintelli.offerprocessing.entity.Marketer;
import com.bizintelli.offerprocessing.exception.DeleteFailedException;
import com.bizintelli.offerprocessing.exception.InsertFailedException;
import com.bizintelli.offerprocessing.exception.RetrieveFailedException;
import com.bizintelli.offerprocessing.exception.UpdateFailedException;
import com.bizintelli.offerprocessing.rest.conroller.MarketerController;

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
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		MarketerWorkerThread worker1 = new MarketerWorkerThread("object1");
		MarketerWorkerThread worker2 = new MarketerWorkerThread("object2");
		MarketerWorkerThread worker3 = new MarketerWorkerThread("object3");
		MarketerWorkerThread worker4 = new MarketerWorkerThread("object4");
		MarketerWorkerThread worker5 = new MarketerWorkerThread("object5");
		MarketerWorkerThread worker6 = new MarketerWorkerThread("object6");
		MarketerWorkerThread worker7 = new MarketerWorkerThread("object7");
		executorService.execute(worker1);
		executorService.execute(worker2);
		executorService.execute(worker3);
		executorService.execute(worker4);
		executorService.execute(worker5);
		executorService.execute(worker6);
		executorService.execute(worker7);
		marketer = marketerDAO.addMarketer(marketer);
		
		LOG.error("Marketer added");
		return marketer;
	}
	@Transactional
	public Marketer updateMarketer(Marketer marketer) throws UpdateFailedException{
		LOG.info("updating Marketers");
		System.out.println("Marketer Service Update invoked:");
		marketer = marketerDAO.updateMarketer(marketer);
		LOG.debug(" Marketer updated");
		return marketer;
		
	}

	public Marketer getMarketer(long marketerId) throws RetrieveFailedException {
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
	public boolean deleteMarketer(long marketerId) throws DeleteFailedException {
		LOG.info("Deleting Marketer with " + marketerId);
		try {
			marketerDAO.deleteMarketer(marketerId);
		} catch (RetrieveFailedException e) {
			
			e.printStackTrace();
		}
		return false;
	}


}




