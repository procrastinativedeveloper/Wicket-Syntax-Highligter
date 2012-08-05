package com.procrastination;

import com.procrastination.utils.Toolbox;

import java.io.Serializable;


/**
 * TODO extract interface and implement to types (global highlighter), current highlighter
 */
public class InitScriptProducer implements Serializable{

    private SyntaxHighlighterSettings settings;

    public InitScriptProducer(SyntaxHighlighterSettings settings) {
        this.settings = settings;
    }
    public String generateInitScript() {
        StringBuilder result = new StringBuilder();

        //Override SyntaxHiglighter translation
        if (settings.getLocalization() != null) {
            String localizationScript = buildLocalization(settings.getLocalization());
            if (Toolbox.isNotEmptyOrNull(localizationScript)) {
                result.append(localizationScript);
            }
        }

        //Override default configuration of SyntaxHighlighter
        String configOverride = buildConfigSection();
        if (Toolbox.isNotEmptyOrNull(configOverride)) {
            result.append(configOverride);
        }

        result.append(syntaxHighlighterRunAll());
        return result.toString();
    }

    /**
     * This method is responsible for creating config part of syntax higlighter.
     * If settings has default values then return empty String.
     *
     * @return
     */
    protected String buildLocalization(Localization localization) {
        StringBuilder translation = new StringBuilder();
        addTranslation("expandSource", localization.getExpandSource(), translation);
        addTranslation("help", localization.getHelp(), translation);
        addTranslation("alert", localization.getAlert(), translation);
        addTranslation("noBrush", localization.getNoBrush(), translation);
        addTranslation("brushNotHtmlScript", localization.getBrushNotHtmlScript(), translation);
        addTranslation("viewSource", localization.getViewSource(), translation);
        addTranslation("copyToClipboard", localization.getCopyToClipboard(), translation);
        addTranslation("copyToClipboardConfirmation", localization.getCopyToClipboardConfirmation(), translation);
        addTranslation("print", localization.getPrint(), translation);
        return translation.toString();
    }

    //TODO escape jsCharacters in newValue, validation for npe etc...
    protected void addTranslation(String propertyName, String newValue, StringBuilder translation) {
        if (!Toolbox.emptyOrNull(newValue)) {
          String propertyTranslation = new StringBuilder().append("SyntaxHighlighter.config.strings.").append(propertyName)
                  .append(" = \"").append(newValue).append("\";\n").toString();
            translation.append(propertyTranslation);
        }
    }

    //TODO move into Defaults the default value
    protected String buildConfigSection() {
        Defaults defaults = settings.getDefaults();
        StringBuilder configSection = new StringBuilder();
        if (null != defaults) {
            overrideDefaultsValue("auto-links", true, defaults.isAutolinks(), configSection);
            overrideDefaultsValue("class-name", "", defaults.getClassname(), configSection);
            overrideDefaultsValue("collapse", false, defaults.isCollapse(), configSection);
            overrideDefaultsValue("first-line", Integer.toString(1), Integer.toString(defaults.getFirstLine()), configSection);
            overrideDefaultsValue("gutter", true, defaults.isGutter(), configSection);
            if ((defaults.getHighlight() != null) && (defaults.getHighlight().size() > 0)) {
                //TODO clean up this mess
                overrideDefaultsValueWithoutQuotes("highlight", "", defaults.getHighlightAsJsArray(), configSection);
            }
            overrideDefaultsValue("html-script", false, defaults.isHtmlScript(), configSection);
            overrideDefaultsValue("smart-tabs", true, defaults.isSmartTabs(), configSection);
            overrideDefaultsValue("tab-size", Integer.toString(4), Integer.toString(defaults.getTabSize()), configSection);
            overrideDefaultsValue("toolbar", true, defaults.isToolbar(), configSection);
        }
        return configSection.toString();
    }

    protected void overrideDefaultsValue(String property, String defaultValue,  String newValue,  StringBuilder builder) {
        if ( !defaultValue.equals(newValue) ) {
            builder.append("SyntaxHighlighter.defaults['").append(property).append("'] = \"")
                    .append(newValue).append("\";\n");
        }
    }

    protected void overrideDefaultsValueWithoutQuotes(String property, String defaultValue,  String newValue,  StringBuilder builder) {
        if ( !defaultValue.equals(newValue) ) {
            builder.append("SyntaxHighlighter.defaults['").append(property).append("'] = ")
                    .append(newValue).append(";\n");
        }
    }

    protected void overrideDefaultsValue(String property, boolean defaultValue, boolean newValue,  StringBuilder builder) {
        if ( newValue != defaultValue ) {
            builder.append("SyntaxHighlighter.defaults['").append(property).append("'] = ")
                    .append(newValue).append(";\n");
        }
    }

    private String syntaxHighlighterRunAll() {
        return "SyntaxHighlighter.all();";
    }
}
