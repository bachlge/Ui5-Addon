package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-togglebutton")
@JsModule("@ui5/webcomponents/dist/ToggleButton.js")
@JsModule("@ui5/webcomponents-icons/dist/icons/accept.js")
public class Ui5ToggleButton extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ToggleButton.class);

	public Ui5ToggleButton() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("design", "Positive");
		this.getElement().setProperty("icon", "accept");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
