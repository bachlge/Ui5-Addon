package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-table-row")
@JsModule("@ui5/webcomponents/dist/TableRow.js")
public class Ui5TableRow extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5TableRow.class);

	public Ui5TableRow() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("slot", "default");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
