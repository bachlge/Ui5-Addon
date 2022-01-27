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
@Tag("ui5-color-palette-item")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/ColorPaletteItem.js")
public class Ui5ColorPaletteItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ColorPaletteItem.class);

	public Ui5ColorPaletteItem() {
		LOGGER.info("constructor() ...");
	}

	public Ui5ColorPaletteItem(String color) {
		LOGGER.info("constructor(String color) ...");
		setValue(color);
		
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void getValue() {
		this.getElement().getProperty("value");
	}

	public void setValue(String value) {
		this.getElement().setProperty("value", value);
	}

}
