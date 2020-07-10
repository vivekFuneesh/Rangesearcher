# Rangesearcher
A simple webservice to save a data(eg. Person's traveled distance) at a given date and retrieve saved data within dated ranges.

3 end points are there..

Tech used is spring boot.

	@GetMapping("/totalDistance/{personId}")
get Total Distance traveled by a person with given ID as 'personId'
	
	/**
	 * Date must be in yyyy-MM-dd type pattern i.e. 4 digit year first<br>
	 * then 2 digit representing month<br>
	 * then 2 digit representing days.<br>
	 * NOTE:: If MM exceeds 12 then next year will get start<br>
	 * similarly if dd exceeds 31 or 30 or 29/28 for respective months then next month will start.
	 * 
	 */
     @PostMapping("/add/") 
add Distance to a person's day. If person not exist, create that else if day not exist then create that else add that.
	
	/**
	 * Dates 'date1' & 'date2' must be in yyyy-MM-dd pattern i.e. 4 digit year first<br>
	 * then 2 digit representing month<br>
	 * then 2 digit representing days.<br>
	 * NOTE:: If MM exceeds 12 then next year will get start<br>
	 * similarly if dd exceeds 31 or 30 or 29/28 for respective months then next month will start.
	 */
     @GetMapping("/rangedDistance/") 
get Ranged Dated Distance.
