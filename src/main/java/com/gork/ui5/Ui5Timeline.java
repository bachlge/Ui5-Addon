package com.gork.ui5;
/**
 * How to use:
 * 
 * import com.gork.ui5.Ui5Timeline;
 * import com.gork.ui5.Ui5TimelineItem;
 * 
 * Ui5TimelineItem timeItem1 = new Ui5TimelineItem();
 * Ui5TimelineItem timeItem2 = new Ui5TimelineItem();
 * Ui5TimelineItem timeItem3 = new Ui5TimelineItem();

 * Ui5Timeline ui5Timeline = new Ui5Timeline();
 * ui5Timeline.add(timeItem1, timeItem2, timeItem3);
 * 
 * getContent().add(ui5Timeline);
 * 
 */

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-timeline")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.6")
@JsModule("@ui5/webcomponents/dist/Timeline.js")
public class Ui5Timeline extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Timeline.class);

	public Ui5Timeline() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
