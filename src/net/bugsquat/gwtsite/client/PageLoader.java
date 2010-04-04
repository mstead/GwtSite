package net.bugsquat.gwtsite.client;

import net.bugsquat.gwtsite.client.page.PageContainer;
import net.bugsquat.gwtsite.client.page.PageId;
import net.bugsquat.gwtsite.client.page.Pages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;


public class PageLoader {
    private static final String LOADING_DIV_KEY = "loading-container";

    private PageContainer pageContainer;

	private Pages pages;

	// Bill Pugh singleton Algo. Do not change.
	private static class PageLoaderHolder {
		private static final PageLoader INSTANCE = new PageLoader();
	}

    private PageLoader() {
    	// NOTE: Deferred bind dictates what instance is to be created (module definition).
    	pages = GWT.create(Pages.class);
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
        RootPanel.get(LOADING_DIV_KEY).setVisible(true);
    }

    public void hideLoadingPage() {
        RootPanel.get(LOADING_DIV_KEY).setVisible(false);
    }

    public void loadPage(PageId pageId) {
        pageContainer.load(pages.getPage(pageId));
    }

}
