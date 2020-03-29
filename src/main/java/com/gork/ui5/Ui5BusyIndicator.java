/**
 * https://sap.github.io/ui5-webcomponents/playground/components/BusyIndicator/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-busyindicator")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.6")
@JsModule("@ui5/webcomponents/dist/BusyIndicator.js")
public class Ui5BusyIndicator extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5BusyIndicator.class);

	public Ui5BusyIndicator() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAcive(Boolean active) {
		this.getElement().setProperty("active", active);
	}

	public void setSize(BusyIndicatorSize size) {
		this.getElement().setProperty("size", size.toString());
	}

	public enum BusyIndicatorSize { Small, Medium, Large }

}
