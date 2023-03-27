/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Table/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-table-group-row")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.11.0")
@JsModule("@ui5/webcomponents/dist/TableGroupRow.js")
public class Ui5TableGroupRow extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5TableGroupRow.class);

	public Ui5TableGroupRow() {
		LOGGER.info("constructor ...");
	}

}
