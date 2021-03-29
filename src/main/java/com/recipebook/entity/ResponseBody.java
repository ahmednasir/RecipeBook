package com.recipebook.entity;

public class ResponseBody {

    private String responseMessage;
    private int responseCode;

    public int getResponseCode() {
        return responseCode;
    }

    public ResponseBody(int responseCode, String responseMessage){
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
