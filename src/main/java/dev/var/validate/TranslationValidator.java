package dev.var.validate;

import java.util.Map;

/**
 * @author mynameisvar <github@mynameisvar>
 */

public class TranslationValidator {

    public boolean validate(Map<String, String> translations) {
        return translations.values().stream().noneMatch(String::isBlank);
    }
}
