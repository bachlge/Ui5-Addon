/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Timeline/
 * 
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
package com.gork.ui5;

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
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.4.0")
@JsModule("@ui5/webcomponents-fiori/dist/Timeline.js")
public class Ui5Timeline extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Timeline.class);

	public Ui5Timeline() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	/**
	 * Default: Vertical
	 * @param layout
	 */
	public void setLayout(TimelineLayout layout) {
		this.getElement().setProperty("layout", layout.toString());
	}

	public enum TimelineLayout { Vertical, Horizontal }

}
