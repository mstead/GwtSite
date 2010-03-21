package net.bugsquat.gwtsite.client.page;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

@SuppressWarnings("unchecked")
public abstract class Page<C extends PageController> extends Composite {

    protected FlowPanel content;

    public Page() {
        content = new FlowPanel();
        initWidget(content);
        content.setStyleName("page-content");
    }

    /**
     * Returns the id of this page. Each page should have a unique id defined.
     *
     * @return the id of this page.
     */
    public abstract PageId getId();

    /**
     * Loads the page's data.
     */
    public abstract void loadData();

    /**
     * Gets the controller for this page. It is recommended that all page implementations
     * create a single controller instance on construction, and have this method return that instance.
     *
     * @return the controller instance for this page.
     */
    public abstract C getController();

    public void setLoadDataListener(PageDataLoadedListener listener) {
        getController().setLoadDataListener(listener);
    }

}
