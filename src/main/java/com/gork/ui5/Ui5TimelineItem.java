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
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-timeline-item")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.11.0")
//@NpmPackage(value = "@ui5/webcomponents-icons", version = "^1.4.0")
@JsModule("@ui5/webcomponents-fiori/dist/TimelineItem.js")
//@JsModule("@ui5/webcomponents-icons/dist/calendar.js")
public class Ui5TimelineItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5TimelineItem.class);

	public Ui5TimelineItem() {
		LOGGER.info("constructor ...");
		setIcon("calendar"); // default icon
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public void setName(String name) {
		this.getElement().setProperty("name", name);
	}

	/**
	 * @deprecated use @setName instead 
	 */
	public void setItemName(String name) {
		setName(name);
	}

	public void setTitleText(String title) {
		this.getElement().setProperty("titleText", title);
	}

	/**
	 * @deprecated use @setTitleText instead
	 */
	public void setTitle(String title) {
		setTitleText(title);
	}

	public void setSubtitleText(String title) {
		this.getElement().setProperty("subtitleText", title);
	}

	/**
	 * @deprecated use @setSubtitleText instead
	 */
	public void setSubTitle(String title) {
		this.getElement().setProperty("subtitleText", title);
	}

	public void setNameClickable(boolean value) {
		this.getElement().setProperty("nameClickable", value);
	}

	/**
	 * @deprecated use setNameClickable instead
	 */
	public void setItemNameClickable(boolean clickable) {
		setNameClickable(clickable);
	}

	/**
	 * Conveniance Method
	 * @param color
	 */
	public void setColor(String color) {
		this.getElement().getStyle().set("color", color);
		this.getElement().getStyle().set("background-color", color);
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
