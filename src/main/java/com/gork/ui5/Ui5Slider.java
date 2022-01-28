/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Slider/
 * 
 * + Label (implements HasLabel)
 * + Data binding
 * + Change Event
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
@Tag("ui5-slider")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/Slider.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js") // for `name`-property to have effect
public class Ui5Slider extends AbstractSinglePropertyField<Ui5Slider, Integer> implements HasLabel {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Slider.class);

	public Ui5Slider() {
		super("value", 0, false);
		LOGGER.info("constructor ...");
		addListener(ValueChangeEvent.class, null);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setLabelInterval(int value) {
		this.getElement().setProperty("labelInterval", value);
	}

	public void setMin(Float value) {
		this.getElement().setProperty("min", value);
	}

	public void setMax(Float value) {
		this.getElement().setProperty("max", value);
	}

	// For the name property to have effect, you must add the following import to your project:
	// import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";
	public void setName(String value) {
		this.getElement().setProperty("name", value);
	}

	public void setShowTickmarks(Boolean value) {
		this.getElement().setProperty("showTickmarks", value);
	}

	public void setShowTooltip(Boolean value) {
		this.getElement().setProperty("showTooltip", value);
	}

	public void setStep(int value) {
		this.getElement().setProperty("step", value);
	}

	public void setValue(Float value) {
		this.getElement().setProperty("value", value);
	}

	// Convenience
	public void setValue(Integer value) {
		this.getElement().setProperty("value", value);
	}

	// Convenience
	public void setValue(Long value) {
		this.getElement().setProperty("value", value);
	}

	@DomEvent("change")
	public static class ValueChangeEvent extends ComponentEvent<Ui5Slider> {

		public ValueChangeEvent(Ui5Slider source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("value"));
			Notification.show("value changed to " + source.getElement().getProperty("value"));
		}
	}

	public Registration addChangeListener(ComponentEventListener<ValueChangeEvent> listener) {
		return addListener(ValueChangeEvent.class, listener);
	}

	@DomEvent("input")
	public static class InputEvent extends ComponentEvent<Ui5Slider> {

		public InputEvent(Ui5Slider source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("value"));
			Notification.show("value changed to " + source.getElement().getProperty("value"));
		}
	}

	public Registration addInputListener(ComponentEventListener<InputEvent> listener) {
		return addListener(InputEvent.class, listener);
	}


}
