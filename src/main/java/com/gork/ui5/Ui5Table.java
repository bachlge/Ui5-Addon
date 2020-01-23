package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-table")
@JsModule("@ui5/webcomponents/dist/Table.js")
public class Ui5Table extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Table.class);

	public Ui5Table() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("noDataText", "No data in this table");
		this.getElement().setProperty("showNoData", true);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
