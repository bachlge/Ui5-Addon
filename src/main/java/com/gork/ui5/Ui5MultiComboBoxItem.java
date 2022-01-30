/**
 * https://sap.github.io/ui5-webcomponents/playground/components/MultiComboBox/
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
@Tag("ui5-mcb-item")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/MultiComboBoxItem.js")
public class Ui5MultiComboBoxItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MultiComboBoxItem.class);

	public Ui5MultiComboBoxItem() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAdditionalText(String additionalText) {
		this.getElement().setProperty("additionalText", additionalText);
	}

	public void setSelected(Boolean value) {
		this.getElement().setProperty("selected", value);
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

}
