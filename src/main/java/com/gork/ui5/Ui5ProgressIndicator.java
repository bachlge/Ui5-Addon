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
@Tag("ui5-progress-indicator")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.11")
@JsModule("@ui5/webcomponents/dist/ProgressIndicator.js")
public class Ui5ProgressIndicator extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ProgressIndicator.class);

	public Ui5ProgressIndicator() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setValue(Number value) {
		this.getElement().setProperty("value", value.toString());
	}

	public void setValueState(ValueState design) {
		this.getElement().setProperty("valueState", design.toString());
	}

	public enum ValueState { None, Error, Warning, Success, Information }

}
