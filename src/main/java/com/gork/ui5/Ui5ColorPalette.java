package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-color-palette")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.4.0")
@JsModule("@ui5/webcomponents/dist/ColorPalette.js")
public class Ui5ColorPalette extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ColorPalette.class);

	public Ui5ColorPalette() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	@DomEvent("item-click")
	public static class ItemClickEvent extends ComponentEvent<Ui5ColorPalette> {
		private Element item;
		public ItemClickEvent(Ui5ColorPalette source, boolean fromClient,
				@EventData("color") Element item) {
			super(source, fromClient);
			LOGGER.info("ItemClickEvent ...");
			LOGGER.info("Item click event occured - item=" + item);
			this.item = item;
		}
	}

	public Registration addItemClickListener(ComponentEventListener<ItemClickEvent> listener) {
		return addListener(ItemClickEvent.class, listener);
	}

}
