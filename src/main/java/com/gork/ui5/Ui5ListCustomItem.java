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
@Tag("ui5-li")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.1")
@JsModule("@ui5/webcomponents/dist/CustomListItem.js")
public class Ui5ListCustomItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ListCustomItem.class);

	public Ui5ListCustomItem() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
		setType(Type.Detail);
	}

	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}

	public void setIcon(String value) {
		this.getElement().setProperty("icon", value);
	}

	public void setDescription(String value) {
		this.getElement().setProperty("description", value);
	}

	public void setInfo(String value) {
		this.getElement().setProperty("info", value);
	}

	public void setInfoState(InfoState value) {
		this.getElement().setProperty("infoState", value.name());
	}

	public void setType(Type value) {
		this.getElement().setProperty("type", value.name());
	}

	public enum InfoState { None, Success, Warning, Information, Erorr }
	public enum Type { Active, Inactive, Detail }

	@DomEvent("detail-click")
	public static class DetailClickEvent extends ComponentEvent<Ui5ListCustomItem> {
		private Element item;
		public DetailClickEvent(Ui5ListCustomItem source, boolean fromClient, @EventData("event.item.bla") Element item) {
			super(source, fromClient);
			LOGGER.info("Custom List item detail-click event occured");
			this.item = item;
		}
		public Element getElement() {
			return item;
		}
	}

	public Registration addDetailListener(ComponentEventListener<DetailClickEvent> listener) {
		return addListener(DetailClickEvent.class, listener);
	}
}
