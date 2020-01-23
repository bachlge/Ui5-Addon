package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-timeline")
@JsModule("@ui5/webcomponents/dist/Timeline.js")
public class Ui5Timeline extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Timeline.class);

	public Ui5Timeline() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
