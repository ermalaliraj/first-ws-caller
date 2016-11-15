package com.ea.first.jbus.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ea.first.jbus.api.NameVO;
import com.ea.first.jbus.service.FirstService;

@Service(value = "firstBusiness")
public class FirstBusinessImpl implements FirstBusiness{

    @Autowired
    private FirstService service;

	public List<NameVO> getAllNames() throws Exception {
		List<NameVO>  res = service.getAllNames();
        return res;
	}
	
	public Integer addName(NameVO name) throws Exception{
		return service.addName(name);
	}
}