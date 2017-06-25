package com.bizintelli.offerprocessing.rest.conroller;

import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bizintelli.offerprocessing.entity.Marketer;
import com.bizintelli.offerprocessing.exception.DeleteFailedException;
import com.bizintelli.offerprocessing.exception.InsertFailedException;
import com.bizintelli.offerprocessing.exception.UpdateFailedException;
import com.bizintelli.offerprocessing.rest.dto.ResponseDTO;
import com.bizintelli.offerprocessing.rest.dto.StatusDTO;
import com.bizintelli.offerprocessing.services.MarketerService;

@RestController
@RequestMapping("/marketer")
public class MarketerController {
	
	Logger  LOG = Logger.getLogger(MarketerController.class.getName());
	
	@Autowired(required=true)
	@Qualifier("marketerService")
	private MarketerService marketerService;
	
	@GetMapping("/{marketerId}")
	public Marketer getMarketers(@PathVariable("marketerId") long marketerId){
		LOG.info("getMarketers for " + marketerId);
		return marketerService.getMarketer(marketerId);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Marketer> allMarketers(){
		LOG.info("getallMarketers");
		List<Marketer> list = marketerService.getAllMarketers();
		return list;
		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Marketer editMarketer(@RequestBody Marketer marketer){
		 try {
			marketer = marketerService.updateMarketer(marketer);
		} catch (UpdateFailedException e) {
			
			e.printStackTrace();
		}
		return marketer;
		
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseDTO addMarketer(@RequestBody Marketer marketer){
		
		ResponseDTO response = new ResponseDTO();
	    try {
			marketer = marketerService.addMarketer(marketer);
			response.setData(marketer);
            response.setStatus(0);
            response.setMessage("SUCCESS");
            
		} catch (InsertFailedException e) {
			
			e.printStackTrace();
			response.setData(marketer);
            response.setStatus(-1);
            response.setMessage("Failed: " + e);
			
		}
		return response;
	}
	
	@RequestMapping(value="/delete/{marketerId}",method=RequestMethod.GET)
	public StatusDTO delete(@PathVariable("marketerId") long marketerId){
		LOG.info("delete Marketers for " + marketerId);
		StatusDTO status = new StatusDTO();
		try {
			marketerService.deleteMarketer(marketerId);
			status.setMessage("Marketer Deleted Successfully");
			status.setStatus(200);
		} catch (DeleteFailedException e) {
			e.printStackTrace();
			status.setMessage("Marketer Deleted Failed");
			status.setStatus(-200);
		}
		
		return status;
	}
	
}
