package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-product-switch-item")
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

	public void setHeading(String heading) {
		this.getElement().setProperty("heading", heading);
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

}
