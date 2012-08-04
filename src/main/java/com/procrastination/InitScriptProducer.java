package com.procrastination;

import com.procrastination.utils.Toolbox;

import java.io.Serializable;

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


    private String buildConfigSection() {
        StringBuilder configSection = new StringBuilder();



        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private String syntaxHighlighterRunAll() {
        return "SyntaxHighlighter.all();";
    }
}
