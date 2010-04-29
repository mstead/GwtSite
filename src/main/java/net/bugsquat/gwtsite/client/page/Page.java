package net.bugsquat.gwtsite.client.page;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

@SuppressWarnings("unchecked")
public abstract class Page extends Composite {

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

}
