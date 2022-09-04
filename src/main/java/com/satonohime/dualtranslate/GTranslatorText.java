package com.satonohime.dualtranslate;
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslateTextRequest;
import com.google.cloud.translate.v3.TranslateTextResponse;
import com.google.cloud.translate.v3.Translation;
import com.google.cloud.translate.v3.TranslationServiceClient;
import java.io.IOException;


public class GTranslatorText {

    public static String translate(String input, String targetLanguage) {
        try {
            return translateText(input, targetLanguage);
        }
        catch (IOException e) {
            return e.getStackTrace().toString();
        }

    }

    public static String translateText(String input, String targetLang) throws IOException {
        String projectId = "dualtranslate";
        String targetLanguage = targetLang;
        String text = input;
        return translateText(projectId, targetLanguage, text);
    }

    public static String translateText(String projectId, String targetLanguage, String text)
        throws IOException {

        try (TranslationServiceClient client = TranslationServiceClient.create()) {
            LocationName parent = LocationName.of(projectId, "global");

            TranslateTextRequest request =
                TranslateTextRequest.newBuilder()
                    .setParent(parent.toString())
                    .setMimeType("text/plain")
                    .setTargetLanguageCode(targetLanguage)
                    .addContents(text)
                    .build();

            TranslateTextResponse response = client.translateText(request);

            // Display the translation for each input text provided
            for (Translation translation : response.getTranslationsList()) {
                return translation.getTranslatedText();
            }
        }
        return "[Error! Unable to retrieve text]";
    }

}
