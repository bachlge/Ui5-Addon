package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-badge")
@JsModule("@ui5/webcomponents/dist/Badge.js")
public class Ui5Badge extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Badge.class);

	public Ui5Badge() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("colorScheme", "7");
//		this.getElement().setProperty("icon", "sap-ui5");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setColor(int color) {
		this.getElement().setProperty("colorScheme", color);
	}


}
