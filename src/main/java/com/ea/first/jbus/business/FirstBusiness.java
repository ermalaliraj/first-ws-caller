package com.ea.first.jbus.business;

import java.util.List;

import com.ea.first.jbus.api.NameVO;

public interface FirstBusiness {

	List<NameVO> getAllNames() throws Exception;
	
	Integer addName(NameVO name) throws Exception;

}
