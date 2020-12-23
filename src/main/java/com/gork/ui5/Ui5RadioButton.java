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
@Tag("ui5-radiobutton")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.11")
@JsModule("@ui5/webcomponents/dist/RadioButton.js")
public class Ui5RadioButton extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5RadioButton.class);

	public Ui5RadioButton() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	/**
	 * Radio buttons with the same name will form a radio button group
	 * @param name
	 */
	public void setName(String name) {
		this.getElement().setProperty("name", name);
	}

	public void setValue(String value) {
		this.getElement().setProperty("value", value);
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

	public void setValueState(ValueState valueState) {
		this.getElement().setProperty("valueState", valueState.toString());
	}

	public void setDisabled(Boolean disabled) {
		this.getElement().setProperty("disabled", disabled);
	}

	public void setReadonly(Boolean readonly) {
		this.getElement().setProperty("readonly", readonly);
	}

	public void setSelected(Boolean selected) {
		this.getElement().setProperty("selected", selected);
	}


	public enum ValueState { None, Warning, Error }

}
