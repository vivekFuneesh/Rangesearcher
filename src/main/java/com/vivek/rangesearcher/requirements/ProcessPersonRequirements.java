package com.vivek.rangesearcher.requirements;

import com.vivek.rangesearcher.service.PersonDto;

public interface ProcessPersonRequirements {

		/**
		 * Total distance traveled by a person with given ID.
		 */
		public Long totDistTravel(String id);
		
		/**
		 * Add a person's distance traveled at a particular date.
		 * If person doesn't exist, add as new entry.
		 * If person exist but that date doesn't exist then add that date.
		 * If person & date already exist then add new distance to existing one.
		 * Storing all date-time values in UTC zone
		 */
		public PersonDto addPersonDist(PersonDto pd);
		
		/**
		 * Get distance traveled by a person within range of dates.
		 * dates ranging from [date1,date2] both inclusive.
		 * If date1 is not present then take it's ceiling.
		 * If date2 is not present then take it's floor.
		 */
		public Long getRangedDistTravel(PersonDto pd);
	
}
