/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Input/
 * 
 * + Label (implements HasLabel)
 * + Data binding
 * + Value Change Event

 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;

@SuppressWarnings("serial")
@Tag("ui5-step-input")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/StepInput.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js") // for `name`-property to have effect
@JsModule("@ui5/webcomponents/dist/features/InputSuggestions.js")
public class Ui5StepInput extends AbstractSinglePropertyField<Ui5StepInput, Integer> implements HasLabel {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5StepInput.class);

	// default value: 0
	public Ui5StepInput() {
		super("value", 0, false);
		LOGGER.info("constructor ...");
		addListener(ValueChangeEvent.class, null);
}

	public void setValue(String value) {
		this.getElement().setProperty("value", value);
	}

	// For the name property to have effect, you must add the following import to your project:
	// import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";
	public void setName(String value) {
		this.getElement().setProperty("name", value);
	}

	public void setPlaceholder(String value) {
		this.getElement().setProperty("placeholder", value);
	}

	public void setMin(String value) {
		this.getElement().setProperty("min", value);
	}

	public void setMax(String value) {
		this.getElement().setProperty("max", value);
	}

	// default: false
	public void setRequired(Boolean value) {
		this.getElement().setProperty("required", value);
	}

	// default: false
	public void setReadonly(Boolean value) {
		this.getElement().setProperty("readonly", value);
	}

	// default: false
	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	// default: 1
	public void setStep(String value) {
		this.getElement().setProperty("step", value);
	}

	// number of digits after the decimal point 
	// default: 0
	public void setValuePrecision(String value) {
		this.getElement().setProperty("valuePrecision", value);
	}

	public void setValueState(ValueState value) {
		this.getElement().setProperty("valueState", value.toString());
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public enum ValueState { None, Error, Warning, Success, Information }

	@DomEvent("change")
	public static class ValueChangeEvent extends ComponentEvent<Ui5StepInput> {

		public ValueChangeEvent(Ui5StepInput source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("valiue"));
			Notification.show("value changed to " + source.getElement().getProperty("value"));
		}
		
	}


}
