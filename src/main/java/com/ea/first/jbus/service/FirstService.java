package com.ea.first.jbus.service;

import java.util.List;

import com.ea.first.jbus.api.NameVO;

public interface FirstService {

    List<NameVO> getAllNames() throws Exception;
    
    Integer addName(NameVO name) throws Exception;

}
