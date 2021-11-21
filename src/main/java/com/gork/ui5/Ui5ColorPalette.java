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
@Tag("ui5-color-palette")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.1")
@JsModule("@ui5/webcomponents/dist/ColorPalette.js")
public class Ui5ColorPalette extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ColorPalette.class);

	public Ui5ColorPalette() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	/**
	 * The selected color
	 */
	public String getValue() {
		return this.getElement().getProperty("value");
	}

	/**
	 * The selected color
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.getElement().setProperty("value", value);
	}

}
