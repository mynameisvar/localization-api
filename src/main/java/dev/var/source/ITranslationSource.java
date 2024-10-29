package dev.var.source;


import java.util.Map;

/**
 * 
 * @author mynameisvar <github@mynameisvar>
 *
 */

public interface ITranslationSource {

    Map<String, String> loadTranslations() throws Exception;

}
