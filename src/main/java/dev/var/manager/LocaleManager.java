package dev.var.manager;


import java.util.Locale;

/**
 * @author mynameisvar <github@mynameisvar>
 */

public class LocaleManager {

    private Locale currentLocale;

    public LocaleManager(Locale defaultLocale) {
        this.currentLocale = defaultLocale;
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale locale) {
        this.currentLocale = locale;
    }
}
