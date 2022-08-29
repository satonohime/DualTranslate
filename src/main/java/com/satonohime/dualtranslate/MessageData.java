package com.satonohime.dualtranslate;

public class MessageData {
    private String text;
    private String LangFrom;
    private String LangTo;
    private String MSResult;
    private String GResult;
    private String MSTranslit;
    private String GTranslit;

    public MessageData() {
        this.text = "";
        this.LangFrom = "ja";
        this.LangTo = "en";
        this.MSResult = "";
        this.GResult = "";
        this.MSTranslit = "";
        this.GTranslit = "";
    }

    public String getText() {
        return this.text;
    }

    public void setText(String s) {
        this.text = s;
    }

    public String getLangFrom() {
        return this.LangFrom;
    }

    public void setLangFrom(String s) {
        this.LangFrom = s;
    }

    public String getLangTo() {
        return this.LangTo;
    }

    public void setLangTo(String s) {
        this.LangTo = s;
    }

    public String getMSResult() {
        return this.MSResult;
    }

    public void setMSResult(String s) {
        this.MSResult = s;
    }

    public String getGResult() {
        return this.GResult;
    }

    public void setGResult(String s) {
        this.GResult = s;
    }

    public String getMSTranslit() {
        return this.MSTranslit;
    }

    public void setMSTranslit(String s) {
        this.MSTranslit = s;
    }

    public String getGTranslit() {
        return this.GTranslit;
    }

    public void setGTranslit(String s) {
        this.GTranslit = s;
    }
}
