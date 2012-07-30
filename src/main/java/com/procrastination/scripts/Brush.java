package com.procrastination.scripts;


import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

public enum Brush {
    Autoloader("shAutoloader"),
    AppleScript("shBrushAppleScript"),
    AS3("shBrushAS3"),
    Bash("shBrushBash"),
    ColdFusion("shBrushColdFusion"),
    Cpp("shBrushCpp"),
    CSharp("shBrushCSharp"),
    Css("shBrushCss"),
    Delphi("shBrushDelphi"),
    Diff("shBrushDiff"),
    Erlang("shBrushErlang"),
    Groovy("shBrushGroovy"),
    Java("shBrushJava"),
    JavaFX("shBrushJavaFX"),
    JScript("shBrushJScript"),
    Perl("shBrushPerl"),
    Php("shBrushPhp"),
    Plain("shBrushPlain"),
    PowerShell("shBrushPowerShell"),
    Python("shBrushPython"),
    Ruby("shBrushRuby"),
    Sass("shBrushSaas"),
    Scala("shBrushScala"),
    Sql("shBrushSql"),
    Vb("shBrushVb"),
    Xml("shBrushXml"),
    Core("shCore");

    private String resourceName = null;

    private Brush(String resourceName) {
        this.resourceName = resourceName;
    }

    public  ResourceReference getBrushResource() {
        return new PackageResourceReference(Brush.class, resourceName + ".js");
    }
}
