package net.bugsquat.gwtsite.client.page;

import net.bugsquat.gwtsite.client.PageContainerLayout;
import net.bugsquat.gwtsite.client.PageLoader;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;

public class PageContainer extends Composite implements PageDataLoadedListener
{
	private Page currentPage;
	private PageContainerLayout content;

	public PageContainer()
	{
		content = GWT.create(PageContainerLayout.class);
		initWidget(content.getContent());
	}

	public void load(PageController<? extends Page> pageController)
	{
		// Indicate loading until the page loads its data.
		showPageLoading(true);

		pageController.setLoadDataListener(this);
		pageController.loadData();
	}

	/**
	 * Shows/hides the loading indicator
	 *
	 * @param show
	 *            when true, the indicator is shown, else it is hidden.
	 */
	private void showPageLoading(boolean show)
	{
		if (show) {
			PageLoader.getInstance().showLoadingPage();
		} else {
			PageLoader.getInstance().hideLoadingPage();
		}
	}

	/**
	 * Called after the current page's data has been loaded. Hides the loading
	 * indicator and displays the current page.
	 */
	@Override
	public void pageDataHasBeenLoaded(Page loadedPage)
	{
		if (currentPage != null)
		{
			currentPage.removeFromParent();
		}
		currentPage = loadedPage;

		showPageLoading(false);
		content.setPage(currentPage);
	}

}
