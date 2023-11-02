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
@Tag("ui5-mcb-group-item")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.19.0")
@JsModule("@ui5/webcomponents/dist/MultiComboBoxGroupItem.js")
public class Ui5MultiComboBoxGroupItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MultiComboBoxGroupItem.class);

	public Ui5MultiComboBoxGroupItem() {
		LOGGER.info("constructor ...");
	}

	public Ui5MultiComboBoxGroupItem(String text) {
		LOGGER.info("constructor ...");
		setText(text);
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

}
