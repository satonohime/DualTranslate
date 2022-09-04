package com.satonohime.dualtranslate;

import java.io.IOException;

import com.google.gson.*;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MSTranslatorText {
    private static String key = "";
    public String endpoint = "https://api.cognitive.microsofttranslator.com";
    public String RouteTL = "/translate?api-version=3.0&from=en&to=ja";
    public String RouteTLit = "/transliterate?api-version=3.0&language=ja&fromScript=Jpan&toScript=Latn";
    public String url = endpoint.concat(RouteTL);


    // Add your location, also known as region. The default is global.
    // This is required if using a Cognitive Services resource.
    private static String location = "westus2";

    // Instantiates the OkHttpClient.
    OkHttpClient client = new OkHttpClient();

    private void setURL(String LangFrom, String LangTo) {
        RouteTL = "/translate?api-version=3.0&from=" + LangFrom + "&to=" + LangTo;
        url = endpoint.concat(RouteTL);
    }

    //Do not check for to/from languages here
    //Values pulled from HTML form have different byte values than strings in IDE
    private void setURLTLit() {
        url = endpoint.concat(RouteTLit);
    }

    private String buildJSON(String[] textArr) {
        String jsonString = "[";
        for (int i = 0; i < textArr.length; i++) {
            jsonString += "{\"Text\": \"" + textArr[i] + "\"}";
            if (i != textArr.length - 1) {
                jsonString += ",";
            }
        }
        jsonString += "]";
        return jsonString;
    }

    // This function performs a POST request.
    public String Post(String[] input) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        String JSONInput = buildJSON(input);
        String[] HeaderField = new String[]{"Content-Length", "" + JSONInput.length()};
        RequestBody body = RequestBody.create(JSONInput, mediaType);
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Ocp-Apim-Subscription-Key", key)
                .addHeader("Ocp-Apim-Subscription-Region", location)
                .addHeader("Content-type", "application/json");
        if (input.length != 1) {
            requestBuilder.addHeader(HeaderField[0], HeaderField[1]);
        }
        Request request = requestBuilder.build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String translate(String[] input, String LangFrom, String LangTo, String secret) {
        try {
            MSTranslatorText translateRequest = new MSTranslatorText();
            key = secret;
            translateRequest.setURL(LangFrom, LangTo);
            String response = translateRequest.Post(input);

            JsonArray jsonArr = JsonParser.parseString(response).getAsJsonArray();
            JsonObject jsonO = jsonArr.get(0).getAsJsonObject();
            JsonArray jsonTLs = jsonO.get("translations").getAsJsonArray();
            JsonObject text = jsonTLs.get(0).getAsJsonObject();
            return text.get("text").getAsString();
        } catch (Exception e) {
            return "[Error! Unable to retrieve text]";
        }
    }

    public static String[] transliterate(String[] input) {
        try {
            MSTranslatorText translateRequest = new MSTranslatorText();
            translateRequest.setURLTLit();
            String response = translateRequest.Post(input);

            JsonArray jsonArr = JsonParser.parseString(response).getAsJsonArray();
            JsonObject MSTLit = jsonArr.get(0).getAsJsonObject();
            JsonObject GTLit = jsonArr.get(1).getAsJsonObject();
            String MSTLitText = MSTLit.get("text").getAsString();
            String GTLitText = GTLit.get("text").getAsString();
            return new String[]{MSTLitText, GTLitText};
        } catch (Exception e) {
            return new String[]{e.toString(), e.toString()};
        }
        
    }
}