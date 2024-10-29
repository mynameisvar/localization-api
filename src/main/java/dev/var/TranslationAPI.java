package dev.var;


import dev.var.cache.TranslationCache;
import dev.var.manager.LocaleManager;
import dev.var.placeholder.PlaceholderProcessor;
import dev.var.source.ITranslationSource;
import dev.var.validate.TranslationValidator;

import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author mynameisvar <github@mynameisvar>
 */

public class TranslationAPI {

    private final ITranslationSource translationSource;
    private final TranslationValidator validator;
    private final TranslationCache cache;
    private final PlaceholderProcessor placeholderProcessor;
    private final LocaleManager localeManager;
    private final long updateInterval;

    private Timer updateTimer;

    public TranslationAPI(ITranslationSource translationSource,
                          TranslationValidator validator,
                          TranslationCache cache,
                          PlaceholderProcessor placeholderProcessor,
                          LocaleManager localeManager,
                          long updateInterval) {
        this.translationSource = translationSource;
        this.validator = validator;
        this.cache = cache;
        this.placeholderProcessor = placeholderProcessor;
        this.localeManager = localeManager;
        this.updateInterval = updateInterval;

        loadTranslations();
        startUpdateTask();
    }

    public void loadTranslations() {
        try {
            Map<String, String> translations = translationSource.loadTranslations();
            if (validator.validate(translations)) {
                cache.putAll(translations);
            }
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public String translate(String key, Map<String, String> placeholders) {
        String translation = cache.getTranslation(key);
        return placeholderProcessor.processPlaceholders(translation, placeholders);
    }

    public void startUpdateTask() {
        if (updateInterval > 0) {
            updateTimer = new Timer(true);
            updateTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    loadTranslations();
                }
            }, updateInterval, updateInterval);
        }
    }

    public void stopUpdateTask() {
        if (updateTimer != null) {
            updateTimer.cancel();
        }
    }

    public void setLocale(String localeCode) {
        localeManager.setCurrentLocale(new Locale(localeCode));
        loadTranslations();
    }
}
