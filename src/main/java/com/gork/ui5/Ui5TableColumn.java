/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Table/
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
@Tag("ui5-table-column")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.4.0")
@JsModule("@ui5/webcomponents/dist/TableColumn.js")
public class Ui5TableColumn extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5TableColumn.class);

	public Ui5TableColumn() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("slot", "columns");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setDemandPopin(boolean value) {
		this.getElement().setProperty("demandPopin", value);
	}

	public void setMinWidth(int value) {
		this.getElement().setProperty("minWidth", value);
	}

	public void setPopinText(String value) {
		this.getElement().setProperty("popinText", value);
	}

}
