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

        String tagDecoration = (Toolbox.emptyOrNull(componentTag) ? renderTag() : componentTag + " " + renderTag());
        tag.put("class", tagDecoration);
    }

    private String renderTag() {
        return "";
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(JavaScriptHeaderItem.forReference(brush.getResourceReference()));
    }

    private Brush brush = null;
    private Defaults defaults = null;
}
