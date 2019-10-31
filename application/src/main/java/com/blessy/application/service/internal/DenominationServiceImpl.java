package com.blessy.application.service.internal;

import com.blessy.application.model.Denomination;
import com.blessy.application.model.User;
import com.blessy.application.repository.DenominationRepository;
import com.blessy.application.repository.UserRepository;
import com.blessy.application.service.DenominationService;
import com.blessy.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;

@Service
@RequiredArgsConstructor
@Transactional
public class DenominationServiceImpl implements DenominationService {

	private final DenominationRepository denominationRepository;
	private final UserService userService;

	@Override
	public Denomination getDenomination(Integer id) {
		// TODO Auto-generated method stub
		return denominationRepository.findById(id).get();
	}

	@Override
	public Denomination updateDenomination(Denomination denomination) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUsername(auth.getName()).get();
		Denomination updateDenomination = getDenomination(1);
		denomination.setId(updateDenomination.getId());
		updateDenomination.setName(denomination.getName());
		updateDenomination.setSname(denomination.getSname());
		updateDenomination.setCountry(denomination.getCountry());
		updateDenomination.setFounder(denomination.getFounder());
		updateDenomination.setStartDate(denomination.getStartDate());
		updateDenomination.setHq(denomination.getHq());
		updateDenomination.setGpsLat(denomination.getGpsLat());
		updateDenomination.setGpsLong(denomination.getGpsLong());
		updateDenomination.setMission(denomination.getMission());
		updateDenomination.setUser(user);
		return updateDenomination;
	}

}
