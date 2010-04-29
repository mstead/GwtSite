package net.bugsquat.gwtsite.client;

import net.bugsquat.gwtsite.client.page.PageContainer;
import net.bugsquat.gwtsite.client.page.PageId;
import net.bugsquat.gwtsite.client.page.PageControllerRegistry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;


public class PageLoader {

	private PageContainer pageContainer;

	private PageControllerRegistry controllerRegistry;

	// Bill Pugh singleton Algo. Do not change.
	private static class PageLoaderHolder {
		private static final PageLoader INSTANCE = new PageLoader();
	}

	private PageLoader() {
		GwtSiteResources.INSTANCE.css().ensureInjected();

		// NOTE: Deferred bind dictates what instance is to be created (module definition).
		controllerRegistry = GWT.create(PageControllerRegistry.class);
		pageContainer = new PageContainer();
		ScrollPanel scroll = new ScrollPanel();
		scroll.add(pageContainer);
		RootLayoutPanel.get().add(scroll);
	}

	public static PageLoader getInstance() {
		return PageLoaderHolder.INSTANCE;
	}

	public PageContainer getPageContainer() {
		return pageContainer;
	}

	public void showLoadingPage() {
		LoadingOverlay.show();
	}

	public void hideLoadingPage() {
		LoadingOverlay.hide();
	}

	public void loadPage(PageId pageId) {
		pageContainer.load(controllerRegistry.getPageController(pageId));
	}

}
