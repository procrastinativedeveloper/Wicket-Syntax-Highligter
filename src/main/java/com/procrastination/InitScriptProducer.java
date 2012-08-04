package com.procrastination;

import java.io.Serializable;

public class InitScriptProducer implements Serializable{

    private SyntaxHighlighterSettings settings;

    public InitScriptProducer(SyntaxHighlighterSettings settings) {
        this.settings = settings;
    }
    public String generateInitScript() {
        StringBuilder result = new StringBuilder();

        if (settings.getLocalization() != null) {
            result.append(buildLocalization(settings.getLocalization()));
        }

        result.append(buildConfigSection());

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

        if (localization.getAlert() != null) {

        }

        return translation.toString();
    }



    private String buildConfigSection() {
        StringBuilder configSection = new StringBuilder();



        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private String syntaxHighlighterRunAll() {
        return "SyntaxHighlighter.all();";
    }
}
