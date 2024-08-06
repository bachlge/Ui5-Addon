/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Timeline/
 * 
 * Java implementation of SAP's UI5 TimeLineItem web component
 * 
 * javascript-event handled as described here:
 * https://www.youtube.com/watch?v=nkmN5H1e3FE 
 * (Tutorial video by Alejandro Duarte)
 * resp https://vaadin.com/docs/latest/flow/element-api/event-listener
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-timeline-item")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.1.1")
@JsModule("@ui5/webcomponents-fiori/dist/TimelineItem.js")
public class Ui5TimelineItem extends Component implements HasComponents, HasStyle {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5TimelineItem.class);

	public Ui5TimelineItem() {
		LOGGER.info("constructor ...");
		setIcon("calendar"); // default icon
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public String getName() {
		return this.getElement().getProperty("name");
	}

	public void setName(String name) {
		this.getElement().setProperty("name", name);
	}

	public void setTitleText(String title) {
		this.getElement().setProperty("titleText", title);
	}

	public void setSubtitleText(String title) {
		this.getElement().setProperty("subtitleText", title);
	}

	public void setNameClickable(boolean value) {
		this.getElement().setProperty("nameClickable", value);
	}

	/**
	 * Convenience Method
	 */
	public void setNameClickable() {
		this.getElement().setProperty("nameClickable", true);
	}

	/**
	 * Convenience Method
	 */
	public void setProperty(String propertyName, String propertyValue) {
		this.getElement().setProperty(propertyName, propertyValue);
	}

	/**
	 * Convenience Method
	 */
	public String getProperty(String propertyName) {
		return this.getElement().getProperty(propertyName);
	}

	@DomEvent("name-click")
	public static class ClickEvent extends ComponentEvent<Ui5TimelineItem> {

		public ClickEvent(Ui5TimelineItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5TimelineItem ClickEvent ...");
		}
	}

	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}

}
