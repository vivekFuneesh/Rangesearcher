package com.vivek.rangesearcher.model.data;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Person {
	@Id
	private String personId;
	
	@NotBlank
	private List<@Valid DateWithDistance> dwd;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public List<DateWithDistance> getDwd() {
		return dwd;
	}

	public void setDwd(List<DateWithDistance> dwd) {
		this.dwd = dwd;
	}
}
