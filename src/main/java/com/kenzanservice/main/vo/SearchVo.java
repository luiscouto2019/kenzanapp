package com.kenzanservice.main.vo;

import java.io.Serializable;

/**
 * Creating the SearchVo for the search page
 * @author LUIS
 *
 */
public class SearchVo implements Serializable {
	private static final long serialVersionUID = 334655728120611263L;

	private String idEmployee = "";

	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

}
