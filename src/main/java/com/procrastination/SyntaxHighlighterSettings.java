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
        brushes.add(Brush.Java);

        themes.add(Theme.Core);
        themes.add(Theme.ThemeDefault);
    }

    private List<Brush> brushes = new ArrayList<Brush>();
    /*TODO Can be only one*/
    private List<Theme> themes = new ArrayList<Theme>();

    /*config*/
    private Localization localization = null;
    private boolean stripBrs = false;
    private String tagName = "pre";

    /*defaults this options could be configured per component*/
    private boolean autolinks = true;
    private String classname = null;
    private boolean collapse =  false;
    private int firstLine = -1;
    private boolean gutter = true;
    private List<Integer> highlight = new ArrayList<Integer>();
    private boolean htmlScript = false;
    private boolean smartTabs = true;
    private int tabSize = 4;
    private boolean toolbar = false;

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
}
