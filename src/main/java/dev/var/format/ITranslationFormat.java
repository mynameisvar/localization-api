package dev.var.format;


import java.io.Reader;
import java.util.Map;

/**
 * @author mynameisvar <github@mynameisvar>
 */

public interface ITranslationFormat {
    Map<String, String> parse(Reader name);
}
