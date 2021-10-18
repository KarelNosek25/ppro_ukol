package cz.uhk.ppro.inzeraty.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validator Polozky katalogu
 * @author kozelto1, krizpa1
 *
 */
@Component
public class PolozkaValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return Inzerat.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Inzerat p = (Inzerat) target;
		
		if (p.getKategorie().equals("Nákup") ||  p.getKategorie().equals("Prodej") || p.getKategorie().equals("Výměna")) {
			errors.rejectValue("kategorie", "err.inzerat.kategorie", "Možné kategorie jsou pouze: Nákup, Prodej, Výměna");
		}
		
	}

}
