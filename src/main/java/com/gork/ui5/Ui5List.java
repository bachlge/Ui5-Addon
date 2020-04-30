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
@Tag("ui5-list")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.7")
@JsModule("@ui5/webcomponents/dist/List.js")
public class Ui5List extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5List.class);

	public Ui5List() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setHeader(String header) {
		this.getElement().setProperty("headerText", header);
	}

	public void setFooter(String footer) {
		this.getElement().setProperty("footerText", footer);
	}

	public int getNumItems() {
		return this.getElement().getChildCount();
	}

}
