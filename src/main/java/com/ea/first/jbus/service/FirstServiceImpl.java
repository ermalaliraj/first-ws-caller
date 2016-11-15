package com.ea.first.jbus.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.ea.first.be.ws.client.AddNameRequest;
import com.ea.first.be.ws.client.AddNameResponse;
import com.ea.first.be.ws.client.FirstPortTypeV1;
import com.ea.first.be.ws.client.FirstServiceV1;
import com.ea.first.be.ws.client.GetAllNamesResponse;
import com.ea.first.jbus.api.NameVO;
import com.ea.first.jbus.web.controllers.FirstController;

@Service(value="firstService")
public class FirstServiceImpl implements FirstService{
	
	protected static transient Log log = LogFactory.getLog(FirstService.class);
    
    public List<NameVO> getAllNames() throws Exception {
        GetAllNamesResponse res = null;
       
        FirstServiceV1 serviceV1 = new FirstServiceV1();
        FirstPortTypeV1 roiServicePort = serviceV1.getFirstServicePort();

        res = roiServicePort.getAllNames();
        
        //oggetti business del jbuss
        List<NameVO> listAllNames = new ArrayList<NameVO>();
        NameVO dto;
        for (com.ea.first.be.ws.client.NameDTO beDto : res.getResult().getNames()) {
        	dto = new NameVO();
        	dto.setId(beDto.getId());
        	dto.setName(beDto.getName());
        	listAllNames.add(dto);
		}
       
        log.debug("After calling WS-BE getAllNames() total: "+listAllNames.size());
        return listAllNames;
    }
    
    public Integer addName(NameVO name) throws Exception {
        FirstServiceV1 serviceV1 = new FirstServiceV1();
        FirstPortTypeV1 roiServicePort = serviceV1.getFirstServicePort();
        
        AddNameRequest req = new AddNameRequest();
        com.ea.first.be.ws.client.NameDTO beName = new com.ea.first.be.ws.client.NameDTO();
        beName.setName(beName.getName());
        req.setInput(beName);
        AddNameResponse res = roiServicePort.addName(req);
        Integer result = -1;
        if(res != null){
        	result = res.getResult(); 
        }
        log.debug("After calling WS-BE result: "+result);
        
        return result;
    }


}
