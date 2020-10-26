package com.*****.password.policy;

public class PasswordPolicyTest {

	public static void main(String[] args) {
		PasswordPolicy passpolicy = new PasswordPolicy();
		String generatedPassword = passpolicy.generateRandomPassword();
		System.out.println(String.format("%s '%s'", "Generated password according to password policy - ", generatedPassword));
		
		String validPassword = getPassword(true);
		System.out.println(String.format("%s '%s'", "valid password to test - ", validPassword));
		passpolicy.isPasswordValid(validPassword);
		
		String inValidPassword = getPassword(false);
		System.out.println(String.format("%s '%s'", "invalid password to test - ", inValidPassword));
		passpolicy.isPasswordValid(inValidPassword);

	}

	private static String getPassword(boolean validPassword) {
		String password;
		if(validPassword) {
			password = "Dafg123!j";
		}else {
			password = "1234asfg";
		}
		return password;
		
	}

}
