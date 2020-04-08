package com.learning.rest.webservices.restfulwebservices.filtering;


import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		String[] args = {"field1","field2"};
		return FilteringController.filtering(someBean, args);
		
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListofSomeBean() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2","value3"),
				new SomeBean("value11","value22","value33"));
		String[] args = {"field2","field3"};
		return filtering(list,args);
		
	}
	
	private static MappingJacksonValue filtering(Object object, String args[]) {
		
		MappingJacksonValue mapping = new MappingJacksonValue(object);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(args);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping.setFilters(filters);
		return mapping;
		
	}

}
