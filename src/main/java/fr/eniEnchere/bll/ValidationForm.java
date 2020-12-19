package fr.eniEnchere.bll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
/**
 * @author ken
 * Class pour vérifier les informations données dans les formulaires.
 *
La description de l'expression régulière pour le téléphone "^(?:(?:\+|00)33|0)\s*[1-9](?:[\s.-]*\d{2}){4}$";
^
    (?:(?:\+|00)33|0)     # Dialing code
    \s*[1-9]              # First number (from 1 to 9)
    (?:[\s.-]*\d{2}){4}   # End of the phone number
$
 */

public class ValidationForm {
	
	private final  String PHONE_PATTERN = "^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$";
	private final  String ZIPCODE_PATTERN = "\\d{5}";
	private final  String PASSWORD_PATTERN = "\\d{5}";
	//private final  String PSEUDO_PATTERN =""[a-zA-Z0-9_]*$";
	
	public boolean verificationEmail(HttpServletRequest request) {
		
		String emailUser = request.getParameter("email");
		Pattern r = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = r.matcher(emailUser);	
		if (m.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verificationPhone(HttpServletRequest request) {
		
		String phoneUser = request.getParameter("phone");
		Pattern r = Pattern.compile(PHONE_PATTERN);
		Matcher m = r.matcher(phoneUser);	
		if (m.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verificationZipCode(HttpServletRequest request) {
		
		String zipcodeUser = request.getParameter("zipCode");
		Pattern r = Pattern.compile(ZIPCODE_PATTERN);
		Matcher m = r.matcher(zipcodeUser);	
		if (m.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verificationPassword(HttpServletRequest request) {
	
		String passwordUser = request.getParameter("password");
		Pattern r = Pattern.compile(PASSWORD_PATTERN);
		Matcher m = r.matcher(passwordUser);	
		if (m.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verificationConfirmation(HttpServletRequest request) {
		String confirmationUser = request.getParameter("confirmation");
		String passwordUser = request.getParameter("password");
		if (passwordUser.equals(confirmationUser)) {
			return true;
		}else {
			return false;
		}
	}

}
