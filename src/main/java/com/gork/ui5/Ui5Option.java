/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Select/
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
@Tag("ui5-option")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.1.1")
@JsModule("@ui5/webcomponents/dist/Token.js")
public class Ui5Option extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Option.class);

	public Ui5Option() {
		LOGGER.info("constructor ...");
	}

	public Ui5Option(String value, String text) {
		this();
		LOGGER.info("constructor(value) ...");
		setValue(value);
		add(text);
	}

	public void setDisabled(Boolean disabled) {
		this.getElement().setProperty("disabled", disabled);
	}

	public void setIcon(String value) {
		this.getElement().setProperty("icon", value);
	}

	public void setSelected(Boolean value) {
		this.getElement().setProperty("selected", value);
	}

	public void setValue(String value) {
		this.getElement().setProperty("value", value);
	}

}
