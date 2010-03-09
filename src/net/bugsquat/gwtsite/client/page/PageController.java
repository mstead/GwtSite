package net.bugsquat.gwtsite.client.page;

@SuppressWarnings("unchecked")
public abstract class PageController<P extends Page> {

    protected P page;
	protected PageDataLoadedListener loadListener;
    
	public abstract P getPage();

    public void setLoadDataListener(PageDataLoadedListener loadListener) {
        this.loadListener = loadListener;
    }

}
