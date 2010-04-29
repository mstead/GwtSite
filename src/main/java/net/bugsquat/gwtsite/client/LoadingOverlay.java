package net.bugsquat.gwtsite.client;

import net.bugsquat.gwtsite.client.image.Images;

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class LoadingOverlay {

	private PopupPanel popup;

	private static class Overlay {
		private static final LoadingOverlay INSTANCE = new LoadingOverlay();
	}

	private LoadingOverlay() {
		popup = new PopupPanel(false);
		popup.setAnimationEnabled(true);
		popup.setGlassEnabled(true);

		FlowPanel content = new FlowPanel();
		content.setStyleName(GwtSiteResources.INSTANCE.css().gwtSiteLoadingOverlay());
		content.add(new Image(Images.INSTANCE.largeLoading()));
		content.add(new Label("Loading..."));
		popup.setWidget(content);

		int x = (Window.getClientWidth()/2) - 50;
		int y = (Window.getClientHeight()/2) - 50;
		popup.setPopupPosition(x, y);
	}

	private void on() {
		this.popup.show();
	}

	private void off() {
		this.popup.hide();
	}

	public static void show() {
		Overlay.INSTANCE.on();
	}

	public static void hide() {
		Overlay.INSTANCE.off();
	}
}
