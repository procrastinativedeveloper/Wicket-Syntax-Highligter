package com.procrastination;

import com.procrastination.scripts.Brush;
import com.procrastination.themes.Theme;
import org.apache.wicket.request.resource.ResourceReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SyntaxHighlighterSettings implements Serializable{

    public SyntaxHighlighterSettings() {
        brushes.add(Brush.Core);
        themes.add(Theme.Core);
        themes.add(Theme.ThemeDefault);
    }

    private List<Brush> brushes = new ArrayList<Brush>();
    /*TODO Should be only one*/
    private List<Theme> themes = new ArrayList<Theme>();

    /*config*/
    private Localization localization = null;
    private boolean stripBrs = false;
    private String tagName = "pre";
    private Defaults defaults;

    public void putBrush(Brush brush) {
        if (null == brush) {
            throw new RuntimeException("Brush shouldn't be null");
        }
        brushes.add(brush);
    }

    public String generateScripts(){
        return "SyntaxHighlighter.all();";
    }

    public List<ResourceReference> getJsResources() {
        List<ResourceReference> result = new ArrayList<ResourceReference>();
        for(Brush brush: brushes) {
            result.add(brush.getBrushResource());
        }
        return result;
    }

    public List<ResourceReference> getCssResources() {
        List<ResourceReference> result = new ArrayList<ResourceReference>();
        for(Theme theme: themes) {
            result.add(theme.getThemeResource());
        }
        return result;
    }

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public boolean isStripBrs() {
        return stripBrs;
    }

    public void setStripBrs(boolean stripBrs) {
        this.stripBrs = stripBrs;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Defaults getDefaults() {
        return defaults;
    }

    public void setDefaults(Defaults defaults) {
        this.defaults = defaults;
    }
}
