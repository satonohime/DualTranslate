# DualTranslate
Web application to translate between English and Japanese that uses two translation services to easily cross reference results. EN -> JP translation will also provide romanized results, similar to Google Translate. No current plans to host the website anywhere.
This webapp uses Google Cloud translation and Azure Cognitive Services as the two translation services.

Tools used:
  - Java
  - Maven
  - Spring Boot
  - Thymeleaf
  - HTML/CSS/JavaScript

Code samples used and modified from:
  - Azure Cognitive Services code samples: 
        https://github.com/MicrosoftTranslator/Text-Translation-Code-Samples/blob/main/Java-Code-Samples/Translate/src/main/java/Translate.java
  - Google Cloud code samples:
        https://cloud.google.com/translate/docs/advanced/translate-text-advance

# How To Run
Rename MSTranslatorText_Template.java to MSTranslatorText.java, and do the same for all occurences within the file. Then, run the main function in DualtranslateApplication.java and navigate to localhost:8080 in your browser.
