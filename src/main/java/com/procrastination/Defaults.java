package com.procrastination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Defaults implements Serializable {/*defaults this options could be configured per component*/

    public Defaults() {
    }

    /*rethink this abstraction*/

    /**
     * Allows you to turn detection of links in the highlighted element on and off. If the option is turned off, URLs won’t be clickable.
     * default:  true
     */
    private boolean autolinks = true;

    /**
     * Allows you to add a custom class (or multiple classes) to every highlighter element that will be created on the page.
     * default: ''
     */
    private String classname = null;

    /**
     * Allows you to force highlighted elements on the page to be collapsed by default.
     * default: false
     */
    private boolean collapse = false;

    /**
     * Allows you to change the first (starting) line number.
     * default: 1
     */
    private int firstLine = 1;

    /**
     * Allows you to turn gutter with line numbers on and off.
     * default: true
     */
    private boolean gutter = true;

    /**
     * Allows you to highlight one or more lines to focus user’s attention. When specifying as a parameter, you have to pass an array looking value, like [1, 2, 3] or just an number for a single line. If you are changing SyntaxHighlighter.defaults['highlight'], you can pass a number or an array of numbers.
     * default: null <- jsArray
     */
    private List<Integer> highlight = new ArrayList<Integer>();

    /**
     * Allows you to highlight a mixture of HTML/XML code and a script which is very common in web development. Setting this value to true requires that you have shBrushXml.js loaded and that the brush you are using supports this feature.
     * default: false
     */
    private boolean htmlScript = false;
    /**
     * Allows you to turn smart tabs feature on and off
     * default: true
     */
    private boolean smartTabs = true;

    /**
     * Allows you to adjust tab size.
     * default: 4
     */
    private int tabSize = 4;

    /**
     *Toggles toolbar on/off
     * default: true
     */
    private boolean toolbar = true;

    public boolean isAutolinks() {
        return autolinks;
    }

    public void setAutolinks(boolean autolinks) {
        this.autolinks = autolinks;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public boolean isCollapse() {
        return collapse;
    }

    public void setCollapse(boolean collapse) {
        this.collapse = collapse;
    }

    public int getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(int firstLine) {
        this.firstLine = firstLine;
    }

    public boolean isGutter() {
        return gutter;
    }

    public void setGutter(boolean gutter) {
        this.gutter = gutter;
    }

    public List<Integer> getHighlight() {
        return highlight;
    }

    public void setHighlight(List<Integer> highlight) {
        this.highlight = highlight;
    }

    public boolean isHtmlScript() {
        return htmlScript;
    }

    public void setHtmlScript(boolean htmlScript) {
        this.htmlScript = htmlScript;
    }

    public boolean isSmartTabs() {
        return smartTabs;
    }

    public void setSmartTabs(boolean smartTabs) {
        this.smartTabs = smartTabs;
    }

    public int getTabSize() {
        return tabSize;
    }

    public void setTabSize(int tabSize) {
        this.tabSize = tabSize;
    }

    public boolean isToolbar() {
        return toolbar;
    }

    public void setToolbar(boolean toolbar) {
        this.toolbar = toolbar;
    }
}