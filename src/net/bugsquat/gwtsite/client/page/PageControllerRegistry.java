package net.bugsquat.gwtsite.client.page;

import java.util.HashMap;

public class PageControllerRegistry {

	private HashMap<PageId, PageController<? extends Page>> pageCache;

	protected PageControllerRegistry() {
		this.pageCache = new HashMap<PageId, PageController<? extends Page>>();
	}

	protected void registerPageController(PageController<? extends Page> pageController) {
		PageId id = pageController.getPageId();
		if (pageCache.containsKey(id)) {
			throw new RuntimeException("A page with id " + id + " was already loaded.");
		}
		pageCache.put(id, pageController);
	}


	public PageController<? extends Page> getPageController(PageId pageId) {
		if (!pageCache.containsKey(pageId)) {
			throw new RuntimeException("Page was not registered with id: " + pageId);
		}
		return pageCache.get(pageId);
	}

}
