package com.zte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zte.mapper.CountryMapper;
import com.zte.model.Country;
import com.zte.service.CountryService;

@Service
public class CountryServiceimpl implements CountryService {

	@Autowired
	private CountryMapper countryMapper;

	@Override
	public List<Country> findCountryByPage(Country country) {
		PageHelper.startPage(country.getPage(), country.getRows());
		List<Country> list = countryMapper.select(null);
		return list;
	}

	@Override
	public void addCountry(Country country) {
		countryMapper.insert(country);
	}

}
