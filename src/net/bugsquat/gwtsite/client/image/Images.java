package net.bugsquat.gwtsite.client.image;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Images extends ClientBundle {

	public static Images INSTANCE = GWT.create(Images.class);

	@Source("large-loading.gif")
	ImageResource largeLoading();
}
