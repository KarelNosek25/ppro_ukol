package cz.uhk.ppro.inzeraty.web;

import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Kontroler hlavni stranky katalogu
 *
 * @author kozelto1, krizpa1
 */
@Controller
public class KatalogController {
    private UlozisteInzeratu inzerat = null;

    public UlozisteInzeratu getUlozisteInzeratu() {
        return inzerat;
    }

    /**
     * @param inzerat, který má být nastaven (injektujeme pomoci anotaci)
     */
    @Autowired
    public void setKatalog(UlozisteInzeratu inzerat) {
        this.inzerat = inzerat;
    }

    /**
     * Vlastni akce namapovana na danou URL, naplni Model pro JSP a urci logicke jmeno view
     */
    @RequestMapping("/katalog.do")
    public ModelAndView zobrazit(@ModelAttribute("kosik") UlozisteInzeratu k) {
        ModelAndView model = new ModelAndView("katalog");
        model.addObject("inzeráty", inzerat.getInzeraty());


        return model;
    }

}
