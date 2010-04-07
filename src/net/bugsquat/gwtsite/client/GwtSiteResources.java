package net.bugsquat.gwtsite.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface GwtSiteResources extends ClientBundle {

	public static final GwtSiteResources INSTANCE = GWT.create(GwtSiteResources.class);

	public interface GwtSiteCss extends CssResource {

		@ClassName("gwtsite-loading-overlay")
		String gwtSiteLoadingOverlay();

	}

	@Source("gwtsite.css")
	GwtSiteCss css();

}
