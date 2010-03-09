package net.bugsquat.gwtsite.client.layout;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import net.bugsquat.gwtsite.client.PageContainerLayout;
import net.bugsquat.gwtsite.client.page.Page;
import net.bugsquat.gwtsite.client.page.PageController;

public class DefaultPageContainerLayout implements PageContainerLayout {

	private VerticalPanel content;

	@Override
	public Widget getContent() {
		content = new VerticalPanel();
		content.setStyleName("page-container-content");
		return content;
	}

	@Override
	public void setPage(Page<? extends PageController> currentPage) {
		content.add(currentPage);
	}

}
