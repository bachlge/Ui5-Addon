package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;

@SuppressWarnings("serial")
@Tag("ui5-rating-indicator")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.1")
@JsModule("@ui5/webcomponents/dist/RatingIndicator.js")
public class Ui5RatingIndicator extends AbstractSinglePropertyField<Ui5RatingIndicator, Integer> {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5RatingIndicator.class);

	public Ui5RatingIndicator() {
		super("value", 0, false);
		LOGGER.info("constructor ...");
		addListener(ValueChangeEvent.class, this::showValue);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	// convenience method
	public void setValue(Integer value) {
		this.getElement().setProperty("value", value);
	}

	// convenience method
	public void setValue(Double value) {
		this.getElement().setProperty("value", value);
	}

	public void setValue(Float value) {
		this.getElement().setProperty("value", value);
	}

	public void setMaxValue(Integer value) {
		this.getElement().setProperty("maxValue", value);
	}

	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setReadonly(Boolean value) {
		this.getElement().setProperty("readonly", value);
	}

	@DomEvent("change")
	public static class ValueChangeEvent extends ComponentEvent<Ui5RatingIndicator> {

		public ValueChangeEvent(Ui5RatingIndicator source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("value"));
			Notification.show("value changed to " + source.getElement().getProperty("value"));
		}
	}

	private void showValue(ValueChangeEvent event) {
		LOGGER.info("value changed (ValueChangeEvent)");
		LOGGER.info("" + event.getSource().getElement().getProperty("value"));
		Notification.show("" + event.getSource().getElement().getProperty("value"));
	}

}
