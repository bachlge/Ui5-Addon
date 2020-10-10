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
@Tag("ui5-button")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.9")
@JsModule("@ui5/webcomponents/dist/Button.js")
public class Ui5Button extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Button.class);

	public Ui5Button() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public void setIconEnd(Boolean iconEnd) {
		this.getElement().setProperty("iconEnd", iconEnd);
	}

	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}

	public void setDesign(ButtonDesign design) {
		this.getElement().setProperty("design", design.toString());
	}

	public enum ButtonDesign { Default, Transparent, Positive, Negative, Emphasized }

}
