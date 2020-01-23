package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-popover")
@JsModule("@ui5/webcomponents/dist/Popover.js")
public class Ui5Popover extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Popover.class);

	public Ui5Popover() {
		LOGGER.info("constructor ...");
		this.setModal(true); // modal by default
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setTitle(String title) {
		this.getElement().setProperty("headerText", title);
	}

	public void setModal(Boolean modal) {
		this.getElement().setProperty("modal", modal);
	}


}
