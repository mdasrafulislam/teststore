package it.unibz.teststore.annotation;

import it.unibz.teststore.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if(userRepository == null) {
			return true;
		}
		return userRepository.findByName(username) == null;
	}

}
