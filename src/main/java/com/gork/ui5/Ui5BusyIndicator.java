/**
 * https://sap.github.io/ui5-webcomponents/playground/components/BusyIndicator/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-busy-indicator")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.14.0")
@JsModule("@ui5/webcomponents/dist/BusyIndicator.js")
public class Ui5BusyIndicator extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5BusyIndicator.class);

	public Ui5BusyIndicator() {
		LOGGER.info("constructor ...");
	}

	public void setActive(Boolean active) {
		this.getElement().setProperty("active", active);
	}

	public void setDelay(Boolean delay) {
		this.getElement().setProperty("delay", delay);
	}

	/**
	 * Default: Medium
	 * @param size
	 */
	public void setSize(BusyIndicatorSize size) {
		this.getElement().setProperty("size", size.toString());
	}

	public enum BusyIndicatorSize { Small, Medium, Large }

	/**
	 * Defines text to be displayed below the component. It can be used to inform the user of the current operation.
	 * @param text
	 */
	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}
	
}
