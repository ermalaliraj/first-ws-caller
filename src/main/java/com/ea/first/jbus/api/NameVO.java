package com.ea.first.jbus.api;

import java.io.Serializable;

public class NameVO implements Serializable {

	private static final long serialVersionUID = -4337041024452939917L;

	private Long id;
	private String name;
	
	public NameVO() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NameVO(String name) {
		this.name = name;
	}
	
}
