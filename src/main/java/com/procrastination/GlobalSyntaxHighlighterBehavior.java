package com.procrastination;

import com.procrastination.scripts.Brush;
import com.procrastination.utils.Toolbox;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.request.resource.ResourceReference;

/**
 *
 * it will be behavior, maybe add component based on webcomponent
 */
public class GlobalSyntaxHighlighterBehavior extends Behavior{

    public GlobalSyntaxHighlighterBehavior(SyntaxHighlighterSettings settings) {
        this.settings = settings;
    }
    private SyntaxHighlighterSettings settings = null;

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        for(ResourceReference cssResource: settings.getCssResources()) {
            response.render(CssHeaderItem.forReference(cssResource));
        }

        for(ResourceReference resource: settings.getJsResources()){
            response.render(JavaScriptHeaderItem.forReference(resource));
        }
        response.render(OnDomReadyHeaderItem.forScript(settings.generateScripts()));
    }


    public ClassAtributeDecorator produceClassAttributeBehavior(Brush brush, Defaults defaults) {
        Toolbox.argumentNotNull(brush, "Brush shouldn't be null");
        Toolbox.argumentNotNull(defaults, "Defaults shouldn't be null");

        settings.putBrush(brush);
        return new ClassAtributeDecorator(brush, defaults);
    }
}
