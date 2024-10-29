package dev.var.settings;


import lombok.Getter;

import java.util.Locale;

/**
 * @author mynameisvar <github@mynameisvar>
 */

public class LocalizationSettings {

    @Getter
    private final Locale defaultLocale;
    @Getter
    private final String translationUrl;
    @Getter
    private final boolean isJsonFormat;

    public LocalizationSettings(Locale defaultLocale, String translationUrl, boolean isJsonFormat) {
        this.defaultLocale = defaultLocale;
        this.translationUrl = translationUrl;
        this.isJsonFormat = isJsonFormat;
    }
}
