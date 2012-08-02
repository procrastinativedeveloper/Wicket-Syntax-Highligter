package com.procrastination;

import java.io.Serializable;

public class Localization implements Serializable {

    private String expandSource = "expandSource";
    private String help = "help";
    private String alert =  "SyntaxHighlighter\\n\\n";
    private String noBrush = "Can't find brush for:";
    private String brushNotHtmlScript = "Brush wasn't made for html-script option:";
    private String viewSource = "view source";
    private String copyToClipboard = "copy to clipboard";
    private String copyToClipboardConfirmation = "The code is in your clipboard now";
    private String print = "pring";

    public String getExpandSource() {
        return expandSource;
    }

    public void setExpandSource(String expandSource) {
        this.expandSource = expandSource;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getNoBrush() {
        return noBrush;
    }

    public void setNoBrush(String noBrush) {
        this.noBrush = noBrush;
    }

    public String getBrushNotHtmlScript() {
        return brushNotHtmlScript;
    }

    public void setBrushNotHtmlScript(String brushNotHtmlScript) {
        this.brushNotHtmlScript = brushNotHtmlScript;
    }

    public String getViewSource() {
        return viewSource;
    }

    public void setViewSource(String viewSource) {
        this.viewSource = viewSource;
    }

    public String getCopyToClipboard() {
        return copyToClipboard;
    }

    public void setCopyToClipboard(String copyToClipboard) {
        this.copyToClipboard = copyToClipboard;
    }

    public String getCopyToClipboardConfirmation() {
        return copyToClipboardConfirmation;
    }

    public void setCopyToClipboardConfirmation(String copyToClipboardConfirmation) {
        this.copyToClipboardConfirmation = copyToClipboardConfirmation;
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }
}
