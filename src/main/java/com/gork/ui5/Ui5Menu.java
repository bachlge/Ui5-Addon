/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Menu/
 */
package com.gork.ui5;

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
import com.vaadin.flow.shared.Registration;

import elemental.json.JsonValue;

@SuppressWarnings("serial")
@Tag("ui5-menu")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.14.0")
@JsModule("@ui5/webcomponents/dist/Menu.js")
public class Ui5Menu extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Menu.class);

	public Ui5Menu() {
		LOGGER.info("constructor ...");
	}

	public void setHeaderText(String headerText) {
		this.getElement().setProperty("headerText", headerText);
	}

	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<Ui5Menu> {

		private final JsonValue item;
		private final String text;

		public ClickEvent(Ui5Menu source, boolean fromClient,
				@EventData("event.item") JsonValue item, @EventData("event.text") String text) {
			super(source, fromClient);
			this.item = item;
			this.text = text;
			LOGGER.info("Ui5Breadcrumbs.ItemClickEvent - source=" + source);
			LOGGER.info("Ui5Breadcrumbs.ItemClickEvent - text=" + text);
		}
	
		public String getItem() {
			return item.asString();
		}

		public String getText() {
			return text;
		}

	}

	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}

}
