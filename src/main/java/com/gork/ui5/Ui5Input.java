/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Input/
 * 
 * + Label (implements HasLabel)
 * + Data binding
 * + Value Change Event
 * 
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-input")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/Input.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
@JsModule("@ui5/webcomponents/dist/features/InputSuggestions.js")
public class Ui5Input extends AbstractSinglePropertyField<Ui5Input, String> implements HasLabel {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Input.class);

	public Ui5Input() {
		super("value", "", false);
		LOGGER.info("constructor ...");
		addListener(ValueChangeEvent.class, null);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setAccessibleNameRef(String accessibleNameRef) {
		this.getElement().setProperty("accessibleNameRef", accessibleNameRef);
	}

	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setMaxLength(int value) {
		this.getElement().setProperty("maxLength", value);
	}

	// For the name property to have effect, you must add the following import to your project:
	// import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";
	public void setName(String value) {
		this.getElement().setProperty("name", value);
	}

	public void setPlaceholder(String value) {
		this.getElement().setProperty("placeholder", value);
	}

	public void setReadonly(Boolean value) {
		this.getElement().setProperty("readonly", value);
	}

	public void setRequired(Boolean value) {
		this.getElement().setProperty("required", value);
	}

	public void setShowSuggesions(Boolean value) {
		this.getElement().setProperty("showSuggesions", value);
	}

	/**
	 * Default: Text
	 * @param type
	 */
	public void setType(InputType type) {
		this.getElement().setProperty("inputType", type.toString());
	}

	public enum InputType { Text, Email, Number, Password, Tel, URL }

	/**
	 * Default None
	 * @param valueState
	 */
	public void setValueState(ValueState valueState) {
		this.getElement().setProperty("valueState", valueState.toString());
	}

	public enum ValueState { None, Error, Warning, Success, Information }

	/**
	 * Convenience Method
	 * Slots: default, icon, valueStateMessage
	 * @param slot
	 */
	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}

	@DomEvent("change")
	public static class ValueChangeEvent extends ComponentEvent<Ui5Input> {

		public ValueChangeEvent(Ui5Input source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("value"));
			Notification.show("value changed to " + source.getElement().getProperty("value"));
		}
	}

	public Registration addChangeListener(ComponentEventListener<ValueChangeEvent> listener) {
		return addListener(ValueChangeEvent.class, listener);
	}

}
