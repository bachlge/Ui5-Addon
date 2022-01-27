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

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-timeline-item")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.1.2")
@NpmPackage(value = "@ui5/webcomponents-icons", version = "^1.1.2")
@JsModule("@ui5/webcomponents-fiori/dist/TimelineItem.js")
@JsModule("@ui5/webcomponents-icons/dist/calendar.js")
public class Ui5TimelineItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5TimelineItem.class);

	public Ui5TimelineItem() {
		LOGGER.info("constructor ...");
		setIcon("calendar"); // default icon
		addListener(ClickEvent.class, this::onItemNameClick);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public void setTitle(String title) {
		this.getElement().setProperty("titleText", title);
	}

	public void setSubTitle(String title) {
		this.getElement().setProperty("subtitleText", title);
	}

	// as of RC.15, the properties “itemName” and “itemNameClickable” are renamed to “name” and “nameClickable” 
	public void setItemName(String name) {
		this.getElement().setProperty("name", name);
	}

	public void setItemNameClickable(boolean clickable) {
		this.getElement().setProperty("nameClickable", clickable);
	}

	public void setColor(String color) {
		this.getElement().getStyle().set("color", color);
		this.getElement().getStyle().set("background-color", color);
	}

	/**
	 *  listen to component-event
	 */
/*
	private <T extends ComponentEvent<?>> void onItemNameClick(T event) {
		LOGGER.info("clicked on time-line-item-name (ComponentEvent)");
		LOGGER.info("" + event.getSource().getElement().getProperty("titleText"));
	}
*/
	private void onItemNameClick(ClickEvent event) {
		LOGGER.info("clicked on time-line-item-name (ClickEvent)");
//		JsonObject eventData = event.getEventData();
		LOGGER.info("" + event.getSource().getElement().getProperty("titleText"));
	}

	@DomEvent("item-name-click")
//	@DomEvent("itemNameClick") // both events are fired
	public static class ClickEvent extends ComponentEvent<Ui5TimelineItem> {

		public ClickEvent(Ui5TimelineItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("ClickEvent ...");
		}
		
	}

	public Registration addItemNameClickListener() {
		return addListener(ClickEvent.class, this::onItemNameClick);
	}

}
