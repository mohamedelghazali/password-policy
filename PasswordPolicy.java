package com.devglan.password.policy;

import java.util.Arrays;
import java.util.List;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordGenerator;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

public class PasswordPolicy {

	public String generateRandomPassword() {

		List<CharacterRule> rules = Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 1),
				new CharacterRule(EnglishCharacterData.LowerCase, 1), new CharacterRule(EnglishCharacterData.Digit, 1),
				new CharacterRule(EnglishCharacterData.Special, 1));

		PasswordGenerator generator = new PasswordGenerator();
		String password = generator.generatePassword(8, rules);
		return password;
	}

	public boolean isPasswordValid(String password) {
		boolean isPasswordValid = false;
		PasswordValidator validator = new PasswordValidator(Arrays.asList(new LengthRule(8, 16),
				new CharacterRule(EnglishCharacterData.UpperCase, 1),
				new CharacterRule(EnglishCharacterData.LowerCase, 1), new CharacterRule(EnglishCharacterData.Digit, 1),
				new CharacterRule(EnglishCharacterData.Special, 1), new WhitespaceRule()));

		RuleResult result = validator.validate(new PasswordData(password));
		if (result.isValid()) {
			isPasswordValid = true;
			System.out.println("The supplied password - " + password +" is valid.");
		} else {
			isPasswordValid = false;
			final StringBuilder message = new StringBuilder();
			message.append(getMessage(validator.getMessages(result)));
			System.out.println("The supplied password - " + password +" is invalid." + message);
		}
		return isPasswordValid;
	}

	private String getMessage(List<String> messages) {
		StringBuilder string = new StringBuilder();
		for(String message: messages){
			string.append(message);
		}
		return string.toString();
	}

}
