/**
 * https://sap.github.io/ui5-webcomponents/playground/components/RangeSlider/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

import elemental.json.JsonNumber;

@SuppressWarnings("serial")
@Tag("ui5-range-slider")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.14.0")
@NpmPackage(value = "@ui5/webcomponents-icons", version = "^1.14.0")
@JsModule("@ui5/webcomponents/dist/RangeSlider.js")
@JsModule("@ui5/webcomponents-icons/dist/direction-arrows.js")
//public class Ui5RangeSlider extends CustomField implements HasLabel, HasValue.ValueChangeListener, HasSize {
public class Ui5RangeSlider extends Component implements HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5RangeSlider.class);

	public Ui5RangeSlider() {
		LOGGER.info("constructor ...");
		setShowTooltip(true);
		setShowTickmarks(true);
		setLabelInterval(1);
		//setStep(1); // 1 is the default
	}

	public void setShowTooltip(Boolean value) {
		this.getElement().setProperty("showTooltip", value);
	}

	public void setShowTickmarks(Boolean value) {
		this.getElement().setProperty("showTickmarks", value);
	}

	public void setStep(int value) {
		this.getElement().setProperty("step", value);
	}

	public void setLabelInterval(int value) {
		this.getElement().setProperty("labelInterval", value);
	}

	// Convenience method
	public void setMin(int value) {
		setMin(new Float(value));
	}

	public void setMin(Float value) {
		this.getElement().setProperty("min", value);
	}

	// Convenience method
	public void setMax(int value) {
		setMax(new Float(value));
	}

	public void setMax(Float value) {
		this.getElement().setProperty("max", value);
	}

	// Convenience method
	public void setStartValue(int value) {
		setStartValue(new Float(value));
	}

	public void setStartValue(Float value) {
		this.getElement().setProperty("startValue", value);
	}

	public Float getStartValue() {
		return Float.parseFloat(this.getElement().getProperty("startValue"));
	}

	// Convenience method
	public void setEndValue(int value) {
		setEndValue(new Float(value));
	}

	public void setEndValue(Float value) {
		this.getElement().setProperty("endValue", value);
	}

	public Float getEndValue() {
		return Float.parseFloat(this.getElement().getProperty("endValue"));
	}

	public Registration addChangeListener(ComponentEventListener<ChangeEvent> listener) {
		return addListener(ChangeEvent.class, listener);
	}

	@DomEvent("change")
	public static class ChangeEvent extends ComponentEvent<Ui5RangeSlider> {

		private final JsonNumber startValue;
		private final JsonNumber endValue;

		public ChangeEvent(Ui5RangeSlider source, boolean fromClient,
				@EventData("event.startValue") JsonNumber startValue,
				@EventData("event.endValue") JsonNumber endValue) {
			super(source, fromClient);
			this.startValue = startValue;
			this.endValue = endValue;
			if (!fromClient) return;
			LOGGER.info("ChangeEvent ...");
			LOGGER.info("ChangeEvent - event:", this);
			LOGGER.info("ChangeEvent - source:", source);
			LOGGER.info("Change Event - low=" + startValue + ", high=" + endValue);
		}

		public Number getStartValue() {
			return startValue.asNumber();
		}

		public Number getEndValue() {
			return endValue.asNumber();
		}

	}

}
