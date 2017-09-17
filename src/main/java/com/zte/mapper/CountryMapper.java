package com.zte.mapper;

import java.util.List;

import com.zte.model.Country;

public interface CountryMapper{

	List<Country> select(Object object);

	void insert(Country country);

}
