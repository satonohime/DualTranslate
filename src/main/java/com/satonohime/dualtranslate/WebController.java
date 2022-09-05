package com.satonohime.dualtranslate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

   @RequestMapping(value = "/")
   public String index(Model model) {
      model.addAttribute("data", new MessageData());
      return "index";
   }

   @RequestMapping(value = "/tl", method = RequestMethod.POST)
   public String result(@ModelAttribute MessageData data, Model model) {
      String[] results = new String[1];
      results[0] = data.getText();
      data.setGResult(GTranslatorText.translate(data.getText(), data.getLangFrom(), data.getLangTo()));
      data.setMSResult(MSTranslatorText.translate(results, data.getLangFrom(), data.getLangTo()));

      // HTML data contains some hidden characters, condition below used to workaround
      if (data.getLangTo().contains("ja") && data.getLangTo().length() == 2) {
         results = new String[2];
         results[0] = data.getMSResult();
         results[1] = data.getGResult();
         String[] litRes = MSTranslatorText.transliterate(results);
         String msLit = litRes[0];
         String gLit = litRes[1];
         data.setMSTranslit(msLit);
         data.setGTranslit(gLit);
      }

      model.addAttribute("data", data);
      return "index";
   }

}