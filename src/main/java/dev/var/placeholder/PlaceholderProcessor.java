package dev.var.placeholder;


import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mynameisvar <github@mynameisvar>
 */

public class PlaceholderProcessor {

    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\{(.+?)\\}");

    public String processPlaceholders(String text, Map<String, String> placeholders) {
        if (text == null || placeholders == null || placeholders.isEmpty()) {
            return text;
        }

        Matcher matcher = PLACEHOLDER_PATTERN.matcher(text);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String placeholderKey = matcher.group(1);
            String replacement = placeholders.getOrDefault(placeholderKey, "{" + placeholderKey + "}");
            matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(result);

        return result.toString();
    }
}