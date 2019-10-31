package com.blessy.application.service;


import com.blessy.application.model.Denomination;

public interface DenominationService {
	
	Denomination getDenomination(Integer id);
	Denomination updateDenomination(Denomination denomination);

}
