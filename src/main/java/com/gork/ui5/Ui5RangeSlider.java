/**
 * https://sap.github.io/ui5-webcomponents/playground/components/RangeSlider/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.HasValue.ValueChangeEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.data.value.HasValueChangeMode;
import com.vaadin.flow.data.value.ValueChangeMode;

@SuppressWarnings("serial")
@Tag("ui5-range-slider")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.1")
@JsModule("@ui5/webcomponents/dist/RangeSlider.js")
public class Ui5RangeSlider extends CustomField implements HasValue.ValueChangeListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5RangeSlider.class);

	public Ui5RangeSlider() {
		LOGGER.info("constructor ...");
		setShowTooltip(true);
		setShowTickmarks(true);
		setLabelInterval(1);
		//setStep(1); // 1 is the default
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
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

	// Convenience method
	public void setEndValue(int value) {
		setEndValue(new Float(value));
	}

	public void setEndValue(Float value) {
		this.getElement().setProperty("endValue", value);
	}

	@Override
	public void valueChanged(ValueChangeEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	protected Object generateModelValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setPresentationValue(Object newPresentationValue) {
		// TODO Auto-generated method stub
		
	}

}
