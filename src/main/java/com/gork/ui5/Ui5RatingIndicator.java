/**
 * https://sap.github.io/ui5-webcomponents/playground/components/RatingIndicator/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-rating-indicator")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.4.0")
@JsModule("@ui5/webcomponents/dist/RatingIndicator.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
public class Ui5RatingIndicator extends AbstractSinglePropertyField<Ui5RatingIndicator, Integer> {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5RatingIndicator.class);

	public Ui5RatingIndicator() {
		super("value", 0, false);
		LOGGER.info("constructor ...");
//		addListener(ValueChangeEvent.class, this::showValue);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setMax(Integer value) {
		this.getElement().setProperty("max", value);
	}

	/**
	 * 
	 * @deprecated use @setMax instead
	 */
	public void setMaxValue(Integer value) {
		this.getElement().setProperty("maxValue", value);
	}

	// For the name property to have effect, you must add the following import to your project:
	// import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";
	public void setName(String value) {
		this.getElement().setProperty("name", value);
	}

	public void setReadonly(Boolean value) {
		this.getElement().setProperty("readonly", value);
	}

	// convenience method
	public void setValue(Integer value) {
		this.getElement().setProperty("value", value);
	}

	// convenience method
	public void setValue(Double value) {
		this.getElement().setProperty("value", value);
	}

	// convenience method
	public void setValue(Float value) {
		this.getElement().setProperty("value", value);
	}

	// convenience method
	private void showValue(ValueChangeEvent event) {
		LOGGER.info("value changed (ValueChangeEvent)");
		LOGGER.info("" + event.getSource().getElement().getProperty("value"));
		Notification.show("" + event.getSource().getElement().getProperty("value"));
	}

	@DomEvent("change")
	public static class ValueChangeEvent extends ComponentEvent<Ui5RatingIndicator> {

		public ValueChangeEvent(Ui5RatingIndicator source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("value"));
			Notification.show("value changed to " + source.getElement().getProperty("value"));
		}
	}

	public Registration addChangeListener(ComponentEventListener<ValueChangeEvent> listener) {
		return addListener(ValueChangeEvent.class, listener);
	}

}
