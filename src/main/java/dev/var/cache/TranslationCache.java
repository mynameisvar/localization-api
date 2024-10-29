package dev.var.cache;


import java.util.HashMap;
import java.util.Map;

/**
 * @author mynameisvar <github@mynameisvar>
 */

public class TranslationCache {

    private final Map<String, String> translations;

    public TranslationCache() {
        this.translations = new HashMap<>();
    }

    public String getTranslation(String key) {
        return translations.getOrDefault(key, "No Translation: " + key);
    }

    public void putTranslation(String key, String translation) {
        translations.put(key,translation);
    }

    public void putAll(Map<String, String> newTranslations) {
        translations.putAll(newTranslations);
    }

    public void clear() {
        translations.clear();
    }

    public boolean containsKey(String key) {
        return translations.containsKey(key);
    }
}
