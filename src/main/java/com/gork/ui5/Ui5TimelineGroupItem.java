/**
 * https://sap.github.io/ui5-webcomponents/components/fiori/TimelineItem/
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
@Tag("ui5-timeline-group-item")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.12.0")
@JsModule("@ui5/webcomponents-fiori/dist/TimelineGroupItem.js")
public class Ui5TimelineGroupItem extends Component implements HasComponents, HasStyle {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5TimelineGroupItem.class);

	public Ui5TimelineGroupItem() {
		LOGGER.info("constructor ...");
	}

	public void setGroupName(String string) {
		this.getElement().setProperty("groupName", string);
	}

	public void setCollapsed(boolean value) {
		this.getElement().setProperty("collapsed", value);
	}

	/**
	 * Convenience Method
	 */
	public void setCollapsed() {
		setCollapsed(true);
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

	/*----- Events -----*/

	@DomEvent("name-click")
	public static class ClickEvent extends ComponentEvent<Ui5TimelineGroupItem> {

		public ClickEvent(Ui5TimelineGroupItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5TimelineItem ClickEvent ...");
		}
	}

	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}

}
