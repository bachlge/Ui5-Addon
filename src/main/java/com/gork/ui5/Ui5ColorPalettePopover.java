package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;

@SuppressWarnings("serial")
@Tag("ui5-color-palette")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.12.0")
@JsModule("@ui5/webcomponents/dist/ColorPalette.js")
public class Ui5ColorPalettePopover extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ColorPalettePopover.class);

	public Ui5ColorPalettePopover() {
		LOGGER.info("constructor ...");
	}

	public void setDefaultColor(String color) {
		this.getElement().setProperty("defaultColor", color);
	}

	public void setShowDefaultColor(Boolean value) {
		this.getElement().setProperty("showDefaultColor", value);
	}


	public void setShowMoreColors(Boolean value) {
		this.getElement().setProperty("showMoreColors", value);
	}


	public void setShowRecentColors(Boolean value) {
		this.getElement().setProperty("showRecentColors", value);
	}


	@DomEvent("item-click")
	public static class ItemClickEvent extends ComponentEvent<Ui5ColorPalettePopover> {

		public ItemClickEvent(Ui5ColorPalettePopover source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("ItemClickEvent ...");
			Notification.show("clicked on button " + source.getElement().getProperty("color"));
		}

	}

}
