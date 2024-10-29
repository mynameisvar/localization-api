package dev.var.format;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.util.Map;

/**
 * @author mynameisvar <github@mynameisvar>
 */

public class JsonTranslationFormat implements ITranslationFormat {

    @Override
    public Map<String, String> parse(Reader reader) {
        return new Gson().fromJson(reader, new TypeToken<Map<String, String>>() {}.getType());
    }
}
