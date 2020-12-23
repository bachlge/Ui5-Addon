/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Slider/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-slider")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.11")
@JsModule("@ui5/webcomponents/dist/Slider.js")
public class Ui5Slider extends Component implements HasValue {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Slider.class);

	private boolean readOnly = false;
	private boolean requiredIndicatorVisible = false;

	public Ui5Slider() {
		LOGGER.info("constructor ...");
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

	@Override
	public void setValue(Object value) {
		this.getElement().setProperty("value", value.toString());
	}

	@Override
	public Object getValue() {
		return new Float(this.getElement().getProperty("value"));
	}

	@Override
	public Registration addValueChangeListener(ValueChangeListener listener) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
		
	}

	@Override
	public boolean isReadOnly() {
		return readOnly;
	}

	@Override
	public void setRequiredIndicatorVisible(boolean requiredIndicatorVisible) {
		this.requiredIndicatorVisible = requiredIndicatorVisible;
	}

	@Override
	public boolean isRequiredIndicatorVisible() {
		return requiredIndicatorVisible;
	}

}
