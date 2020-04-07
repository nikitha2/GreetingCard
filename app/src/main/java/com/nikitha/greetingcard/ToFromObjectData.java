package com.nikitha.greetingcard;

public class ToFromObjectData {
    String toMessageText;
    String fromMessageText;

    public ToFromObjectData() {
    }

    public String getToMessageText() {
        return toMessageText;
    }

    public void setToMessageText(String toMessageText) {
        this.toMessageText = toMessageText;
    }

    public String getFromMessageText() {
        return fromMessageText;
    }

    public void setFromMessageText(String fromMessageText) {
        this.fromMessageText = fromMessageText;
    }

    public ToFromObjectData(String toMessageText, String fromMessageText) {
        this.toMessageText = toMessageText;
        this.fromMessageText = fromMessageText;
    }




}
