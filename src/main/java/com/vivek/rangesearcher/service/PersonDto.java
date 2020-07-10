package com.vivek.rangesearcher.service;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.vivek.rangesearcher.validation.AddDist;
import com.vivek.rangesearcher.validation.RangedDatedDist;

public class PersonDto {

	@NotBlank(message="personId field must not be blank OR null")
	private String personId;//Never null
	
	@NotNull(groups= {AddDist.class, RangedDatedDist.class}, message="date1 field must not be null")
	private Date date1;//not null in adding distance, null in others
	
	@Null(groups= {AddDist.class},message="date2 field must be null")
	@NotNull(groups= {RangedDatedDist.class},message="date2 must not be null")
	private Date date2;//null in others except RangedDatedDist.
	
	@Null(groups= {RangedDatedDist.class},message="distance must be null")
	@NotNull(groups=AddDist.class,message="distance must not be blank or null")
	private Long distance;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}
}
