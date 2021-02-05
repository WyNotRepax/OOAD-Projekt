package de.akkuvita.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.*;
import de.akkuvita.shared.AkkuProxy;
import de.akkuvita.shared.AkkuvitaRequestFactory;

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

        final EventBus eventBus = new SimpleEventBus();
        AkkuvitaRequestFactory requestFactory = GWT.create(AkkuvitaRequestFactory.class);

        requestFactory.initialize(eventBus);

        AkkuvitaRequestFactory.AkkuRequest akkuRequest = requestFactory.akkuRequest();
        AkkuProxy akkuProxy = akkuRequest.create(AkkuProxy.class);

        GWT.log(akkuProxy.getSeriennummer());

    }
}
