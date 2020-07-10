package com.vivek.rangesearcher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.rangesearcher.exception.PersonNotFoundException;
import com.vivek.rangesearcher.model.data.DateWithDistance;
import com.vivek.rangesearcher.model.data.Person;
import com.vivek.rangesearcher.model.data.repo.PersonRepository;
import com.vivek.rangesearcher.requirements.ProcessPersonRequirements;

@Service
public class ProcessPerson implements ProcessPersonRequirements{

	@Autowired
	PersonRepository pr;
	
	public Long totDistTravel(String id) {
		
		Person p=pr.findById(id).orElse(null);
		if(p==null)throw new PersonNotFoundException(id);
		
		List<DateWithDistance> dwd=p.getDwd();
		Long distance=Long.valueOf(0l);
		for(int i=0;i<dwd.size();i++)
			distance+=dwd.get(i).getDistance();
		return distance;
	}
	
	public PersonDto addPersonDist(PersonDto pd) {
		Person p=pr.findById(pd.getPersonId()).orElse(null);
		DateWithDistance dWD=new DateWithDistance(pd.getDate1().getTime(),pd.getDistance());
		
		if(p==null) {
			p=new Person();
			p.setPersonId(pd.getPersonId());
			p.setDwd(new ArrayList<DateWithDistance>());
			p.getDwd().add(dWD);
			pr.save(p);
			return pd;
		}
		
		List<DateWithDistance> dwdList=p.getDwd();
		for(DateWithDistance d:dwdList) {
			if(d.getDate()==pd.getDate1().getTime()) {
				d.setDistance(pd.getDistance()+d.getDistance());
				pd.setDistance(d.getDistance());
				pr.save(p);
				return pd; 
			}
		}
		p.getDwd().add(dWD);
		pr.save(p);
		return pd;
		
	}
	
	public Long getRangedDistTravel(PersonDto pd) {
		Person p=pr.findById(pd.getPersonId()).orElse(null);
		if(p==null)throw new PersonNotFoundException(pd.getPersonId());

		List<DateWithDistance> dwdList=p.getDwd();
		
		Long date1 = pd.getDate1().getTime(), date2=pd.getDate2().getTime();
		Long tmp;
		if(date1>date2) {tmp=date1;date1=date2;date2=tmp;}
		
			
		Long result=Long.valueOf(0l);
		
		for(int i=0; i<dwdList.size(); i++) {
			if(dwdList.get(i).getDate()>=date1 && dwdList.get(i).getDate()<=date2)
				result+=dwdList.get(i).getDistance();
		}
		return result;
	}
	
}
