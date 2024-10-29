package dev.var.format;


import org.yaml.snakeyaml.Yaml;

import java.io.Reader;
import java.util.Map;

/**
 * @author mynameisvar <github@mynameisvar>
 */

public class YamlTranslationFormat implements ITranslationFormat {

    @Override
    public Map<String, String> parse(Reader reader) {
        return new Yaml().load(reader);
    }
}
