package com.axmor.util;

import java.util.ResourceBundle;

public class MessageBundle {

    private ResourceBundle messages;

    public MessageBundle(String languageTag) {
        this.messages = ResourceBundle.getBundle("localization/messages");
    }
    public String get(String message) {
        return messages.getString(message);
    }
}
