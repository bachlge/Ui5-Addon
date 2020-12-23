package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-wheelslider")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.11")
@JsModule("@ui5/webcomponents/dist/WheelSlider.js")
public class Ui5WheelSlider extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5WheelSlider.class);

	public Ui5WheelSlider() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setValue(String value) {
		this.getElement().setProperty("value", value);
	}

	public void setLabel(String label) {
		this.getElement().setProperty("label", label);
	}

	public void setDisabled(Boolean disabled) {
		this.getElement().setProperty("disabled", disabled);
	}

}
