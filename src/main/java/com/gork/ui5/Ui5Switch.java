package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;

@SuppressWarnings("serial")
@Tag("ui5-switch")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.1")
@JsModule("@ui5/webcomponents/dist/Switch.js")
public class Ui5Switch extends AbstractSinglePropertyField<Ui5Switch, Boolean> {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Switch.class);

	public Ui5Switch() {
		super("value", false, false);
		LOGGER.info("constructor ...");
		this.getElement().setProperty("textOn", "Yes");
		this.getElement().setProperty("textOff", "No");
		addListener(ValueChangeEvent.class, null);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setGraphical(Boolean graphical) {
		this.getElement().setProperty("design", graphical ? Design.Textual.toString() : Design.Graphical.toString());
	}

	public boolean getChecked() {
		return Boolean.getBoolean(getElement().getProperty("checked"));
	}

	public void setChecked(Boolean checked) {
		this.getElement().setProperty("checked", checked);
	}

	@DomEvent("change")
	public static class ValueChangeEvent extends ComponentEvent<Ui5Switch> {

		public ValueChangeEvent(Ui5Switch source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("checked"));
			Notification.show("value changed to " + source.getElement().getProperty("checked"));
		}
		
	}

	public enum Design { Textual, Graphical }

}
