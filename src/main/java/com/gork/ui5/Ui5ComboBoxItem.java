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
@Tag("ui5-cb-item")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.1.1")
@JsModule("@ui5/webcomponents/dist/ComboBox.js")
public class Ui5ComboBoxItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ComboBoxItem.class);

	public Ui5ComboBoxItem() {
		LOGGER.info("constructor ...");
	}

	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}

	public void setIcon(String value) {
		this.getElement().setProperty("icon", value);
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

	public void setAdditionalText(String additionalText) {
		this.getElement().setProperty("additionalText", additionalText);
	}

}
