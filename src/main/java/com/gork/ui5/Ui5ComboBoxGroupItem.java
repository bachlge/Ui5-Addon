/**
 * https://sap.github.io/ui5-webcomponents/playground/components/ComboBox/
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
@Tag("ui5-combobox-group-item")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.12.0")
@JsModule("@ui5/webcomponents/dist/ComboBox.js")
public class Ui5ComboBoxGroupItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ComboBoxGroupItem.class);

	public Ui5ComboBoxGroupItem() {
		LOGGER.info("constructor ...");
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

}
