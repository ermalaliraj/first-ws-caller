package com.ea.first.jbus.web.controllers;

import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.util.Date;
import java.util.List;

import javax.ejb.EJBException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ea.first.jbus.api.NameVO;
import com.ea.first.jbus.business.FirstBusiness;

@Controller
@RequestMapping("/first")
public class FirstController {
	
	//protected static transient Log log = LogFactory.getLog(FirstController.class);
	Logger log = LoggerFactory.getLogger(FirstController.class);
	
    @Autowired
    FirstBusiness business;

    @RequestMapping(value = "/ping")
    public @ResponseBody String ping() {
        return "NOW: "+new Date();
    }

    @RequestMapping(value = "/getAllNames", method = RequestMethod.GET)
    public @ResponseBody String getAllNames(HttpServletRequest request){
        try {
            List<NameVO> list = business.getAllNames();
            log.debug("Lista con nr elementi: " + list.size());
            String res = "";
            for (NameVO  n : list) {
				log.debug(n.getId() + "-" + n.getName());
				res =+ n.getId() +"-"+ n.getName()+"\n";
			}

            return res;
        } catch (Exception e) {
            log.error("UNHANDLED EXCEPTION ", e);
            throw new EJBException(e);
        }
    }
    
    @RequestMapping(value = "/addName", method = RequestMethod.GET)
    public @ResponseBody String addName(HttpServletRequest request){
        try {
        	NameVO name = new NameVO(); //build from user input
        	name.setName("aaaa");
            Integer res = business.addName(name);
            log.debug("Result addName: "+res);
            return "res:"+res;
        } catch (Exception e) {
            log.error("UNHANDLED EXCEPTION ", e);
            throw new EJBException(e);
        }
    }
}
