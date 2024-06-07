package com.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constants.AppConstants;
import com.entity.UserRegistrationEntity;
import com.repo.UserRepo;
import com.response.RegistraionData;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private HttpSession httpSession;

	@Override
	public String registerUser(RegistraionData registraionData) {
		UserRegistrationEntity user_reg_entity = new UserRegistrationEntity();
		BeanUtils.copyProperties(registraionData, user_reg_entity);
		userRepo.save(user_reg_entity);

		return AppConstants.STR_USERSAVE;
	}

	@Override
	public String loginUser(String email, String password) {

		UserRegistrationEntity byEmailAndPwd = userRepo.findByUserEmailAndUserPassword(email, password);

		if (byEmailAndPwd == null) {
			return "Invalid credentials";
		}

		httpSession.setAttribute("UserId", byEmailAndPwd.getUserId());

		return "Succesfully loged in";

	}

}
