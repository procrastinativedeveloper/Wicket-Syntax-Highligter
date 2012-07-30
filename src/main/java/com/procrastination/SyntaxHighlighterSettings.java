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

    private List<Theme> themes = new ArrayList<Theme>();


    public String generateScripts(){
        return "SyntaxHighlighter.all();";
    }

    public List<ResourceReference> getResources() {
        List<ResourceReference> result = new ArrayList<ResourceReference>();
        for(Brush brush: brushes) {
            result.add(brush.getBrushResource());
        }

        for(Theme theme: themes) {
            result.add(theme.getThemeResource());
        }

        return result;
    }
}
