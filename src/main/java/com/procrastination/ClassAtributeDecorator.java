package com.procrastination;

import com.procrastination.scripts.Brush;
import com.procrastination.utils.Toolbox;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;

public class ClassAtributeDecorator extends Behavior {

    public ClassAtributeDecorator(Brush brush, Defaults defaults) {
        if ((null == brush) || (null == defaults)) {
            throw new IllegalArgumentException();
        }
        this.brush = brush;
        this.defaults = defaults;
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);
        String componentTag = tag.getAttribute("class");

        String tagDecoration = (Toolbox.emptyOrNull(componentTag) ? getClassAttribute() : componentTag + " " + getClassAttribute());
        tag.put("class", tagDecoration);
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(JavaScriptHeaderItem.forReference(brush.getResourceReference()));
    }

    protected String getClassAttribute() {
        StringBuilder result = new StringBuilder();
        result.append(renderBrush());
        result.append(renderDefaults());
        return result.toString();
    }

    private String renderDefaults() {
        StringBuilder result = new StringBuilder();
        renderProperty("auto-links", defaults.isAutolinks(), result);
        result.append(", ");
        renderProperty("class-name", defaults.getClassname(), result);
        result.append(", ");
        renderProperty("collapse", defaults.isCollapse(), result);
        result.append(", ");
        renderProperty("first-line", Integer.toString(defaults.getFirstLine()), result);
        result.append(", ");
        renderProperty("gutter", defaults.isGutter(), result);
        result.append(", ");
        if ((defaults.getHighlight() != null) && (defaults.getHighlight().size() > 0)){
            renderProperty("highlight", defaults.getHighlightAsJsArray(), result);
            result.append(", ");
        }
        renderProperty("html-script", defaults.isHtmlScript(), result);
        result.append(", ");
        renderProperty("smart-tabs", defaults.isSmartTabs(), result);
        result.append(", ");
        renderProperty("tab-size", Integer.toString(defaults.getTabSize()), result);
        result.append(", ");
        renderProperty("toolbar", defaults.isToolbar(), result);


        return result.toString();
    }

    protected void renderProperty(String propertyName, boolean propertyValue, StringBuilder appendTo) {
        appendTo.append(propertyName + ": " + propertyValue);
    }

    protected void renderProperty(String propertyName, String propertyValue, StringBuilder appendTo) {
         appendTo.append(propertyName + ": " + propertyValue);
    }

    private String renderBrush() {
        return "brush: " + brush.getBrushName() + " ";
    }

    private Brush brush = null;
    private Defaults defaults = null;
}
