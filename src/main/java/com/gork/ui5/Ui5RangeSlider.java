/**
 * https://sap.github.io/ui5-webcomponents/playground/components/RangeSlider/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-range-slider")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.11")
@JsModule("@ui5/webcomponents/dist/RangeSlider.js")
public class Ui5RangeSlider extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5RangeSlider.class);

	public Ui5RangeSlider() {
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

	public void setValue(Float value) {
		this.getElement().setProperty("value", value.toString());
	}

	public Float getValue() {
		return new Float(this.getElement().getProperty("value"));
	}


}
