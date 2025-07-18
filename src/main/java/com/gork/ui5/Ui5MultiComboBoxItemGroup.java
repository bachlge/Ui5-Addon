/**
 * https://sap.github.io/ui5-webcomponents/playground/components/MultiComboBox/
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
@Tag("ui5-mcb-item-group")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.12.0")
@JsModule("@ui5/webcomponents/dist/MultiComboBoxItemGroup.js")
public class Ui5MultiComboBoxItemGroup extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MultiComboBoxItemGroup.class);

	public Ui5MultiComboBoxItemGroup() {
		LOGGER.info("constructor ...");
	}

	public Ui5MultiComboBoxItemGroup(String text) {
		LOGGER.info("constructor ...");
		setText(text);
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

}
