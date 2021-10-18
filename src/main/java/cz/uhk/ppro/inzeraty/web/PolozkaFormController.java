package cz.uhk.ppro.inzeraty.web;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import cz.uhk.ppro.inzeraty.model.PolozkaValidator;
import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;

/**
 * Kontroler formulare pro zadavani, resp.editaci polozek katalogu
 * @author kozelto1, krizpa1
 *
 */
@Controller
@RequestMapping("/polozka.do")
public class PolozkaFormController {
	private UlozisteInzeratu uloziste = null;
	private Validator polozkaValidator;
	 
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//Nastaveni cutom editoru polozek formulare
		CustomNumberEditor ed = new CustomNumberEditor(
				Double.class,
				new DecimalFormat("#,##0.00"),
				true
		); 
		binder.registerCustomEditor(Double.class,"cena",ed);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	protected String onSubmit(@RequestParam(value="polId",required=false) Integer id, @ModelAttribute("inzerat")  Inzerat inzerat, BindingResult result) {
		//Provede se po odeslani formu
		polozkaValidator.validate(inzerat, result);
		if (result.hasErrors()) {
			return "inzeratForm";
		}
		if (id!=null) {
			uloziste.odstran(id);
		}
		uloziste.pridej(inzerat);
		return "redirect:/sprava.do";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	protected String form(@RequestParam(value="polId",required=false) Integer id, Model m) {
		//Priprava dat pro form, pokud je zadano id polozky, pak bude predvyplnena
		if (id!=null) {
			m.addAttribute("inzerat", uloziste.getById(id));
		} else {
			// pokud vytvarime novou polozku, tak do JSP predame novou instanci
			m.addAttribute("inzerat", new Inzerat());
		}
		return "polozkaForm";
	}

	public UlozisteInzeratu getUlozisteInzeratu() {
		return uloziste;
	}

	@Autowired
	public void setKatalog(UlozisteInzeratu uloziste) {
		this.uloziste = uloziste;
	}

	public Validator getPolozkaValidator() {
		return polozkaValidator;
	}
	
	@Autowired
	public void setPolozkaValidator(PolozkaValidator polozkaValidator) {
		this.polozkaValidator = polozkaValidator;
	}
}
