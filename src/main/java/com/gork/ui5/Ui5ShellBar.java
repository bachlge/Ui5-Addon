package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-shellbar")
@JsModule("@ui5/webcomponents-fiori/dist/ShellBar.js")
public class Ui5ShellBar extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ShellBar.class);

	public Ui5ShellBar() {
		LOGGER.info("constructor ...");
		this.showCoPilot(true); // show by default
		this.showProductSwitch(true); // show by default
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setTitle(String title) {
		this.getElement().setProperty("primaryTitle", title);
	}

	public void setSecondaryTitle(String title) {
		this.getElement().setProperty("secondaryTitle", title);
	}

	public void showCoPilot(Boolean copilot) {
		this.getElement().setProperty("showCoPilot", copilot);
	}

	public void showProductSwitch(Boolean productswitch) {
		this.getElement().setProperty("showProductSwitch", productswitch);
	}

}
