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
@Tag("ui5-product-switch-item")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.1.2")
@JsModule("@ui5/webcomponents-fiori/dist/ProductSwitchItem.js")
public class Ui5ProductSwitchItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ProductSwitchItem.class);

	public Ui5ProductSwitchItem() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setHeading(String value) {
		this.getElement().setProperty("heading", value);
	}

	public void setSubtitle(String value) {
		this.getElement().setProperty("subtitle", value);
	}

	public void setIcon(String value) {
		this.getElement().setProperty("icon", value);
	}

	public void setTargetSrc(String value) {
		this.getElement().setProperty("targetSrc", value);
	}

}
