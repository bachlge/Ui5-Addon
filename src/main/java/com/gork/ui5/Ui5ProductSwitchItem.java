/**
 * https://sap.github.io/ui5-webcomponents/playground/components/ProductSwitch/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

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
@Tag("ui5-product-switch-item")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.1.2")
@JsModule("@ui5/webcomponents-fiori/dist/ProductSwitchItem.js")
public class Ui5ProductSwitchItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ProductSwitchItem.class);

	public Ui5ProductSwitchItem() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setIcon(String value) {
		this.getElement().setProperty("icon", value);
	}

	public void setTarget(Target target) {
		this.getElement().setProperty("target", target.toString());
	}

	public enum Target { _self, _top, _blank, _parent, _search }

	public void setTargetSrc(String value) {
		this.getElement().setProperty("targetSrc", value);
	}

	public void setTitleText(String value) {
		this.getElement().setProperty("titleText", value);
	}

	public void setSubtitleText(String value) {
		this.getElement().setProperty("subUi5ProductSwitchItem", value);
	}

	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<Ui5ProductSwitchItem> {

		public ClickEvent(Ui5ProductSwitchItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5ProductSwitchItem ClickEvent ...");
			Notification.show("Ui5ProductSwitchItem clicked on item " + source.getElement().getProperty("titleText"));
		}
	}

	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}


}
