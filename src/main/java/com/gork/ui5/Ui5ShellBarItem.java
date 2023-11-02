/**
 * https://sap.github.io/ui5-webcomponents/playground/components/ShellBar/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-shell-bar-item")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.19.0")
@JsModule("@ui5/webcomponents-fiori/dist/ShellBarItem.js")
public class Ui5ShellBarItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ShellBarItem.class);

	public Ui5ShellBarItem() {
		LOGGER.info("constructor ...");
	}

	public void setCount(Boolean value) {
		this.getElement().setProperty("count", value);
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<Ui5ShellBarItem> {

		public ClickEvent(Ui5ShellBarItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5ShellBarItem ClickEvent ...");
			Notification.show("clicked on Ui5ShellBarItem " + source.getElement().getProperty("text"));
		}
	}

	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}

}
