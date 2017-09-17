package com.zte.service;

import java.util.List;

import com.zte.model.Country;

public interface CountryService {

	/**
	 * 分页查询所有国家
	 * @param country
	 * @return
	 */
	List<Country> findCountryByPage(Country country);

	void addCountry(Country country);
}
