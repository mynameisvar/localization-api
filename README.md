# Localization API

Гибкий и мощный API для локализации. Этот API поддерживает динамические переводы, замену плейсхолдеров и автоматические обновления из удалённых источников.

## Особенности

- **Динамическая локализация**: Легко управляйте переводами для нескольких языков.
- **Поддержка плейсхолдеров**: Заменяйте динамические значения в ваших переводах.
- **Автообновление переводов**: Автоматически получайте обновлённые переводы из удалённых URL.
- **Система кэширования**: Быстрый доступ к переводам с помощью кэширования в памяти.
- **Управление локалями**: Поддержка нескольких локалей с простым переключением.

## Использование

### Основная настройка

1. Инициализируйте `TranslationAPI` с необходимыми компонентами:

   ```java
   TranslationSource source = new URLTranslationSource("https://gitlab.com/example/exampleproject/-/raw/main/ru_RU.json");
   TranslationCache cache = new TranslationCache();
   TranslationValidator validator = new BasicTranslationValidator();
   PlaceholderProcessor processor = new PlaceholderProcessor();
   LocaleManager localeManager = new LocaleManager();

   TranslationAPI translationAPI = new TranslationAPI(source, cache, validator, processor, localeManager, 60000);
   ```

2. Загружайте переводы и переключайте локали по мере необходимости:

   ```java
   translationAPI.setLocale("ru_RU");
   String welcomeMessage = translationAPI.translate("welcome_message", Map.of("playerName", "Steve"));
   System.out.println(welcomeMessage);
   ```

### Пример источника перевода

Вы можете реализовать свой собственный `TranslationSource`:

```java
public class MyTranslationSource implements TranslationSource {
    
    @Override
    public Map<String, String> loadTranslations() {
        // ...
    }
}
```
