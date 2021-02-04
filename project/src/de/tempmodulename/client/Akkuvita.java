package de.tempmodulename.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Akkuvita implements EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final TabPanel tabPanel = new TabPanel();
        tabPanel.setHeight("100%");
        tabPanel.setWidth("100%");

        addFilteredSearchPanel(tabPanel);
        addFilteredSearchPanel(tabPanel);

        tabPanel.selectTab(0);

        RootPanel.get().add(tabPanel);
    }

    static private void addFilteredSearchPanel(TabPanel tabPanel){
        final VerticalPanel filteredSearchPanel = new VerticalPanel();


        tabPanel.add(filteredSearchPanel, "Filtered Search Panel");
    }
}
