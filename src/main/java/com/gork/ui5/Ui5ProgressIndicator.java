package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-progress-indicator")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.11.0")
@JsModule("@ui5/webcomponents/dist/ProgressIndicator.js")
public class Ui5ProgressIndicator extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ProgressIndicator.class);

	public Ui5ProgressIndicator() {
		LOGGER.info("constructor ...");
	}

	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setDisplayValue(String displayValue) {
		this.getElement().setProperty("displayValue", displayValue);
	}

	public void setHideValue(Boolean value) {
		this.getElement().setProperty("hideValue", value);
	}

	public void setValue(int value) {
		this.getElement().setProperty("value", value);
	}

	/**
	 * Default: None
	 * @param valueState
	 */
	public void setValueState(ValueState valueState) {
		this.getElement().setProperty("valueState", valueState.toString());
	}

	public enum ValueState { None, Error, Warning, Success, Information }

}
