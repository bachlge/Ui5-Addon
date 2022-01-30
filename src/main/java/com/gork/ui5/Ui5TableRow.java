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
@Tag("ui5-table-row")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/TableRow.js")
public class Ui5TableRow extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5TableRow.class);

	public Ui5TableRow() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setSelected(Boolean value) {
		this.getElement().setProperty("selected", value);
	}

	public void setType(TableRowType value) {
		this.getElement().setProperty("type", value.name());
	}

	public enum TableRowType { Avtive, Inactive }

}
