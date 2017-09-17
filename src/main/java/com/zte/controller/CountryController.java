package com.zte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zte.service.CountryService;

@Controller
@RequestMapping("/countries")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	/*@RequestMapping("/check")
	@ResponseBody
	public List<Country> findCountryByPage(){
		Country country = new Country();
		List<Country> list = countryService.findCountryByPage(country);
		return list;
	}*/
	
	/*@RequestMapping("/add")
	@ResponseBody
	public String addUserInfo(Country country){
		try {
			countryService.addCountry(country);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fail";
	}*/

}
