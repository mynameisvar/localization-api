package dev.var.source;


import dev.var.format.ITranslationFormat;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author mynameisvar <github@mynameisvar>
 */

public class UrlTranslationSource implements ITranslationSource{

    private final String url;
    private final ITranslationFormat format;

    public UrlTranslationSource(String url, ITranslationFormat format) {
        this.url = url;
        this.format = format;
    }

    @Override
    public Map<String, String> loadTranslations() throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestProperty("Accept-Charset", StandardCharsets.UTF_8.name());

        try (InputStreamReader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)) {
            return format.parse(reader);
        }
    }
}
