package com.procrastination.scripts;


import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import java.util.ArrayList;

public enum Brush {
    AppleScript("shBrushAppleScript", "n/a"),
    AS3("shBrushAS3", "n/a"),
    Bash("shBrushBash", "n/a"),
    ColdFusion("shBrushColdFusion", "n/a"),
    Cpp("shBrushCpp", "n/a"),
    CSharp("shBrushCSharp", "n/a"),
    Css("shBrushCss", "n/a"),
    Delphi("shBrushDelphi", "n/a"),
    Diff("shBrushDiff", "n/a"),
    Erlang("shBrushErlang", "n/a"),
    Groovy("shBrushGroovy", "n/a"),
    Java("shBrushJava", "java"),
    JavaFX("shBrushJavaFX", "n/a"),
    JScript("shBrushJScript", "n/a"),
    Perl("shBrushPerl", "n/a"),
    Php("shBrushPhp", "n/a"),
    Plain("shBrushPlain", "n/a"),
    PowerShell("shBrushPowerShell", "n/a"),
    Python("shBrushPython", "n/a"),
    Ruby("shBrushRuby", "n/a"),
    Sass("shBrushSaas", "n/a"),
    Scala("shBrushScala", "n/a"),
    Sql("shBrushSql", "n/a"),
    Vb("shBrushVb", "n/a"),
    Xml("shBrushXml", "n/a");


    private String resourceName = null;
    private String brushName = null;

    private Brush(String resourceName, String brushName) {
        this.resourceName = resourceName;
        this.brushName = brushName;
    }

    public  ResourceReference getResourceReference() {
        return new PackageResourceReference(Brush.class, resourceName + ".js") {

            @Override
            public Iterable<? extends HeaderItem> getDependencies() {
                java.util.List<HeaderItem> dependencies = new ArrayList<HeaderItem>();
                dependencies.add(JavaScriptHeaderItem.forReference(CoreDependecies.Core.getResourceReference()));
                dependencies.add(CssHeaderItem.forReference(CoreDependecies.cssCore.getResourceReference()));
                return dependencies;
            }
        };
    }

    public String getBrushName() {
        return brushName;
    }
}
