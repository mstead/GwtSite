package net.bugsquat.gwtsite.client;

import net.bugsquat.gwtsite.client.page.Page;
import net.bugsquat.gwtsite.client.page.PageController;

import com.google.gwt.user.client.ui.Widget;

/**
 * A page container layout is how the sites pages will be show when a page is loaded.
 * It is essentially the dynamically created web template. For example, consider a
 * web site broken down into 3 peices: 1) header, 2) body, 3) footer. The header and footer
 * are static, and the body (the page) is what changes (setPage(page)).
 * 
 * @author mike
 *
 */
public interface PageContainerLayout {

	/**
	 * Content is defined as the root of the layour. ie: A vertical panel containing
	 * all components of this layout.
	 * @return the content pane.
	 */
	Widget getContent();

	/**
	 * Sets the specified <code>Page</code> in the page section of the layout.
	 * @param currentPage the page to set.
	 */
	void setPage(Page<? extends PageController> currentPage);

}
