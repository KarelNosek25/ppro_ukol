package cz.uhk.ppro.inzeraty.web;

import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Kontroler spravy katalogu (priklad, jak rozlisit akce pomoci parametru v URL)
 * @author kozelto1, krizpa1
 *
 */
@Controller
@RequestMapping("/sprava.do")
public class SpravaKataloguController {
	UlozisteInzeratu inzerat = null;

	/**
	 * Zobrazeni tabulky polozek s tlacitk pro editaci/mazani
	 */
	@RequestMapping(params="!akce")
	public ModelAndView show() throws Exception {
		return new ModelAndView("katalogSprava","inzerat",inzerat);
	}

	/**
	 * Smazani polozky
	 */
	@RequestMapping(params="akce=remove")
	public String remove(@RequestParam("polId") int id) {
		inzerat.odstran(id);
		return "redirect:/sprava.do";
	}
	
	public UlozisteInzeratu getInzerat() {
		return inzerat;
	}

	@Autowired
	public void setKatalog(UlozisteInzeratu inzerat) {
		this.inzerat = inzerat;
	}
}
