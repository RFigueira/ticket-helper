package br.com.codepampa.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Bundles {

    private static Locale locale = new Locale("pt", "BR");

    private static final String BUNDLE_NAME = "message";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, locale);

    private static final String VALIDATION_MESSAGES_BUNDLE_NAME = "validationMessages";
    private static final ResourceBundle VALIDATION_MESSAGES_RESOURCE_BUNDLE
            = ResourceBundle.getBundle(VALIDATION_MESSAGES_BUNDLE_NAME, locale);

    private static String getKey(ResourceBundle bundle, String key) {
        try {
            return bundle.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    public static String getString(String key) {
        return getKey(RESOURCE_BUNDLE, key);
    }

    public static String getString(String key, Object... params) {
        try {
            return MessageFormat.format(RESOURCE_BUNDLE.getString(key), params);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    public static String validationMessages(String key) {
        return getKey(VALIDATION_MESSAGES_RESOURCE_BUNDLE, key);
    }

}

