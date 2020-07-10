package com.vivek.rangesearcher.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.rangesearcher.requirements.ProcessPersonRequirements;
import com.vivek.rangesearcher.service.PersonDto;
import com.vivek.rangesearcher.validation.AddDist;
import com.vivek.rangesearcher.validation.RangedDatedDist;

@RestController
@Validated
public class PersonController {

	@Autowired
	ProcessPersonRequirements ppr;
	
	@GetMapping("/totalDistance/{personId}")
	public Long getTotalDistance(@PathVariable @NotBlank String personId) {
		return ppr.totDistTravel(personId);
	}
	
	/**
	 * Date must be in yyyy-MM-dd pattern i.e. 4 digit year first<br>
	 * then 2 digit representing month<br>
	 * then 2 digit representing days.<br>
	 * NOTE:: If MM exceeds 12 then next year will get start<br>
	 * similarly if dd exceeds 31 or 30 or 29 for respective months then next month will start.
	 * 
	 */
	@PostMapping("/add/")
	@Validated(AddDist.class)
	public PersonDto addDistance(@RequestBody @Valid PersonDto pd) {
		return ppr.addPersonDist(pd);
	}
	
	/**
	 * Dates date1 & date2 must be in yyyy-MM-dd pattern i.e. 4 digit year first<br>
	 * then 2 digit representing month<br>
	 * then 2 digit representing days.<br>
	 * NOTE:: If MM exceeds 12 then next year will get start<br>
	 * similarly if dd exceeds 31 or 30 or 29 for respective months then next month will start.
	 */
	@GetMapping("/rangedDistance/")
	@Validated(RangedDatedDist.class)
	public Long getRangedDatedDist(@RequestBody @Valid PersonDto pd) {
		return ppr.getRangedDistTravel(pd);
	}
	
	@RequestMapping(value="/**", method= {RequestMethod.POST, RequestMethod.GET})
	public void error() {
		throw new RuntimeException("Invalid Path");
	}
	
}
