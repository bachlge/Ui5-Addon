package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gork.ui5.Ui5Button.ButtonDesign;
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
@Tag("ui5-split-button")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.12.0")
@JsModule("@ui5/webcomponents/dist/SplitButton.js")
public class Ui5SplitButton extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5SplitButton.class);

	public Ui5SplitButton() {
		LOGGER.info("constructor ...");
		addListener(ClickEvent.class, null);
	}

	public Ui5SplitButton(String text) {
		LOGGER.info("constructor(String text) ...");
		add(text);
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setActiveIcon(String icon) {
		this.getElement().setProperty("activeIcon", icon);
	}

	/**
	 * Re-Use BottonDesign from Ui5Button
	 * @param design
	 */
	public void setDesign(ButtonDesign design) {
		this.getElement().setProperty("design", design.toString());
	}

	/**
	 * Defines whether the component is disabled.
	 * A disabled component can't be pressed or focused, and it is not in the tab chain.
	 * default: false
	 * @param value
	 */
	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<Ui5SplitButton> {

		public ClickEvent(Ui5SplitButton source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("ClickEvent ...");
			Notification.show("clicked on button " + source.getElement().getProperty("text"));
		}
	}

	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}

}
