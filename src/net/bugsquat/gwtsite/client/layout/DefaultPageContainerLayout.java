package net.bugsquat.gwtsite.client.layout;

import net.bugsquat.gwtsite.client.PageContainerLayout;
import net.bugsquat.gwtsite.client.page.Page;
import net.bugsquat.gwtsite.client.page.PageController;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class DefaultPageContainerLayout implements PageContainerLayout {

    private static final String LAYOUT_CONTENT_STYLE = "gwtsite-default-layout";
	private static final String LAYOUT_HEADER_STYLE = LAYOUT_CONTENT_STYLE + "-header";
	private static final String PAGE_HOLDER_STYLE = LAYOUT_CONTENT_STYLE + "-page-holder";
    
	private VerticalPanel content;
	private VerticalPanel pageHolder;

	public DefaultPageContainerLayout() {
		pageHolder = new VerticalPanel();
		pageHolder.setStyleName(PAGE_HOLDER_STYLE);
		
		content = new VerticalPanel();
		content.setStyleName(LAYOUT_CONTENT_STYLE);
		
		content.add(createHeader());
		content.add(pageHolder);
	}
	
	@Override
	public Widget getContent() {
		return content;
	}

	@Override
	public void setPage(Page<? extends PageController> currentPage) {
		pageHolder.clear();
		pageHolder.add(currentPage);
	}
	
	/**
	 * Creates the header for this site. By default it is an empty cell.
	 * @return the header.
	 */
    protected HorizontalPanel createHeader()
    {
        HorizontalPanel header = new HorizontalPanel();
        header.setStyleName(LAYOUT_HEADER_STYLE);
        return header;
    }

}
