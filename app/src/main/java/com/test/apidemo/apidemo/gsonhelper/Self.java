package com.test.apidemo.apidemo.gsonhelper;

import java.io.Serializable;

public class Self implements Serializable {
	private String href;

 	public void setHref(String href) {
		this.href = href;
	}

	public String getHref() {
		return href;
	}

}