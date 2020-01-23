package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-product-switch")
@JsModule("@ui5/webcomponents-fiori/dist/ProductSwitch.js")
public class Ui5ProductSwitch extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ProductSwitch.class);

	public Ui5ProductSwitch() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("slot", "default");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
