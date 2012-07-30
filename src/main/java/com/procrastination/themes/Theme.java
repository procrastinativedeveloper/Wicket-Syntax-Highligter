package com.procrastination.themes;

import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;


public enum Theme {

    Core("shCore"),
    CoreDefault("shCoreDefault"),
    CoreDjango("shCoreDjango"),
    CoreEclipse("shCoreEclipse"),
    CoreEmacs("shCoreEmacs"),
    CoreFadeToGrey("shCoreFadeToGrey"),
    CoreMDUltra("shCoreMDUltra"),
    CoreMidnight("shCoreMidnight"),
    CoreRDark("shCoreRDark"),
    ThemeDefault("shThemeDefault"),
    ThemeDjango("shThemeDjango"),
    ThemeEclipse("shThemeEclipse"),
    ThemeEmacas("shThemeEmacs"),
    ThemeFadeToGrey("shThemeFadeToGrey"),
    ThemeMDUltra("shThemeMDUltra"),
    ThemeMidnight("shThemeMidnight"),
    ThemeRDark("shThemeRDark");


    private Theme(String resourceName) {
        this.resourceName = resourceName;
    }
    private String resourceName = null;

    public ResourceReference getThemeResource() {
        return new PackageResourceReference(Theme.class, this.resourceName + ".css");
    }
}
