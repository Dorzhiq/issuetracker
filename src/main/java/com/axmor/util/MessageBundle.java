package com.axmor.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MessageBundle {

    private ResourceBundle messages;

    public MessageBundle(String languageTag) {
        this.messages = ResourceBundle.getBundle("localization/messages");
    }
    public String get(String message) {
        return messages.getString(message);
    }
    public final String get(final String key, final Object... args) {
        return MessageFormat.format(get(key), args);
    }
}
