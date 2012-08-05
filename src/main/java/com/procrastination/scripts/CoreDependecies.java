package com.procrastination.scripts;

import com.procrastination.themes.Theme;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

/**TODO cleanup - move to other package with dependet resources*/
public enum CoreDependecies {
    Core(new PackageResourceReference(Brush.class, "shCore.js")),
    Autoloader(new PackageResourceReference(Brush.class, "shAutoloader.js")),
    cssCore(new PackageResourceReference(Theme.class, "shCore.css"));

    private CoreDependecies(ResourceReference resourceReference) {
        this.resourceReference = resourceReference;
    }

    private ResourceReference resourceReference = null;

    public ResourceReference getResourceReference() {
        return resourceReference;
    }
}
