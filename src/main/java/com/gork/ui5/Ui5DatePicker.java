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
@Tag("ui5-date-picker")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.9")
@JsModule("@ui5/webcomponents/dist/DatePicker.js")
public class Ui5DatePicker extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5DatePicker.class);

	public Ui5DatePicker() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setPlaceholder(String placeholder) {
		this.getElement().setProperty("placeholder", placeholder);
	}


}
