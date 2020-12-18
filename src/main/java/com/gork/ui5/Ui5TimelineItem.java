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
@Tag("ui5-timeline-item")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.9")
@NpmPackage(value = "@ui5/webcomponents-icons", version = "^1.0.0-rc.9")
@JsModule("@ui5/webcomponents/dist/TimelineItem.js")
@JsModule("@ui5/webcomponents-icons/dist/calendar.js")
public class Ui5TimelineItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5TimelineItem.class);

	public Ui5TimelineItem() {
		LOGGER.info("constructor ...");
		setIcon("calendar"); // default icon
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

	public void setItemName(String name) {
		this.getElement().setProperty("itemName", name);
	}

	public void setItemNameClickable(boolean clickable) {
		this.getElement().setProperty("itemNameClickable", clickable);
	}

	public void setColor(String color) {
		this.getElement().getStyle().set("color", color);
		this.getElement().getStyle().set("background-color", color);
	}

}
