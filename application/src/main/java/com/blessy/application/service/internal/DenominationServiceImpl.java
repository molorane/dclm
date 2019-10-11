package com.blessy.application.service.internal;

import com.blessy.application.model.Denomination;
import com.blessy.application.repository.DenominationRepository;
import com.blessy.application.service.DenominationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DenominationServiceImpl implements DenominationService {

	private final DenominationRepository denominationRepository;

	@Override
	public Denomination getDenomination(Integer id) {
		// TODO Auto-generated method stub
		return denominationRepository.findById(id).get();
	}

}
