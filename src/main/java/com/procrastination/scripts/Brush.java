package com.procrastination.scripts;


import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import java.util.ArrayList;

/**
 * some scripts have multiple aliases, I use only one
 */
public enum Brush {
    AppleScript("shBrushAppleScript", "applescript"),
    AS3("shBrushAS3", "as3"),
    Bash("shBrushBash", "bash"),
    ColdFusion("shBrushColdFusion", "coldfusion"),
    Cpp("shBrushCpp", "cpp"),
    CSharp("shBrushCSharp", "csharp"),
    Css("shBrushCss", "css"),
    Delphi("shBrushDelphi", "delphi"),
    Diff("shBrushDiff", "diff"),
    Erlang("shBrushErlang", "erlang"),
    Groovy("shBrushGroovy", "groovy"),
    Java("shBrushJava", "java"),
    JavaFX("shBrushJavaFX", "javafx"),
    JScript("shBrushJScript", "js"),
    Perl("shBrushPerl", "perl"),
    Php("shBrushPhp", "php"),
    Plain("shBrushPlain", "plain"),
    PowerShell("shBrushPowerShell", "powershell"),
    Python("shBrushPython", "python"),
    Ruby("shBrushRuby", "ruby"),
    Sass("shBrushSaas", "sass"),
    Scala("shBrushScala", "scala"),
    Sql("shBrushSql", "sql"),
    Vb("shBrushVb", "vb"),
    Xml("shBrushXml", "xml");


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
