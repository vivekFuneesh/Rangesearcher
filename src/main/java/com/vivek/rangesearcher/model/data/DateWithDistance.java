package com.vivek.rangesearcher.model.data;

import javax.validation.constraints.NotBlank;

public class DateWithDistance{
	@NotBlank(message="date-time in millis must not be null or blank")
	private Long date;
	
	@NotBlank(message="distance must not be null or blank")
	private Long distance;

	public DateWithDistance(Long date, Long distance) {
		this.date=date; this.distance=distance;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}
}