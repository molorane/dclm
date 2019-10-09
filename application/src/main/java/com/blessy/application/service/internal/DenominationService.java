package com.blessy.application.service.internal;

import com.blessy.application.model.Denomination;
import com.blessy.application.repository.DenominationRepository;
import com.blessy.application.service.IDenominationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DenominationService implements IDenominationService {
	
	@Autowired
	DenominationRepository denominationRepository;

	@Override
	public Denomination getDenomination(Integer id) {
		// TODO Auto-generated method stub
		return denominationRepository.findById(id).get();
	}

}
