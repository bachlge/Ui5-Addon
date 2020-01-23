package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-button")
@JsModule("@ui5/webcomponents/dist/Button.js")
public class Ui5Button extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Button.class);

	public Ui5Button() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("icon", "employee");
		this.getElement().setProperty("design", "Negative");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
