package com.satonohime.dualtranslate;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.Translate.TranslateOption;

public class GTranslatorText {
    public static String translate(String text, String langFrom, String langTo) {
        Translate translate = TranslateOptions.getDefaultInstance().getService();
   
        Translation translation = translate.translate(
            text,
            TranslateOption.sourceLanguage(langFrom),
            TranslateOption.targetLanguage(langTo));
        
        return translation.getTranslatedText();
    }
}
