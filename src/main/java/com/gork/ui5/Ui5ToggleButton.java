package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;

@SuppressWarnings("serial")
@Tag("ui5-togglebutton")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.1")
@NpmPackage(value = "@ui5/webcomponents-icons", version = "^1.0.1")
@JsModule("@ui5/webcomponents/dist/ToggleButton.js")
public class Ui5ToggleButton extends AbstractSinglePropertyField<Ui5ToggleButton, Boolean> implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ToggleButton.class);

	public Ui5ToggleButton() {
		super("value", false, false);
		LOGGER.info("constructor ...");
		addListener(ClickEvent.class, null);
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

	public void setPressed(Boolean pressed) {
		this.getElement().setProperty("pressed", pressed);
	}

	public void setDesign(ToggleButtonDesign design) {
		this.getElement().setProperty("design", design.toString());
	}

	public enum ToggleButtonDesign { Default, Positive, Negative, Emphasized, Transparent }

	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<Ui5ToggleButton> {

		public ClickEvent(Ui5ToggleButton source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("ClickEvent ...");
			Notification.show("clicked on togglebutton " + source.getElement().getProperty("pressed"));
		}
		
	}

}
