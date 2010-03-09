package net.bugsquat.gwtsite.client.page;

import java.util.HashMap;

public class Pages {

    private HashMap<PageId, Page<? extends PageController>> pageCache;

    protected Pages() {
        this.pageCache = new HashMap<PageId, Page<? extends PageController>>();
    }

    protected void registerPage(Page<? extends PageController> pageToRegister) {
        PageId id = pageToRegister.getId();
        if (pageCache.containsKey(id)) {
            throw new RuntimeException("A page with id " + id + " was already loaded.");
        }
        pageCache.put(id, pageToRegister);
    }


    public Page<? extends PageController> getPage(PageId pageId) {
        if (!pageCache.containsKey(pageId)) {
            throw new RuntimeException("Page was not registered with id: " + pageId);
        }
        return pageCache.get(pageId);
    }

}
