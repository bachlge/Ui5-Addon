package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-button")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/Button.js")
public class Ui5Button extends Component implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Button.class);

	public Ui5Button() {
		LOGGER.info("constructor ...");
		addListener(ClickEvent.class, null);
	}

	public Ui5Button(String text) {
		LOGGER.info("constructor(String text) ...");
		add(text);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setDesign(ButtonDesign design) {
		this.getElement().setProperty("design", design.toString());
	}

	public enum ButtonDesign { Default, Emphasized, Positive, Negative, Transparent, Attention }

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

	/**
	 * Defines whether the icon should be displayed after the component text.
	 * default: false
	 * @param iconEnd
	 */
	public void setIconEnd(Boolean iconEnd) {
		this.getElement().setProperty("iconEnd", iconEnd);
	}

	/**
	 * When set to true, the component will automatically submit the nearest form element upon press.
	 * default: false
	 * @param value
	 */
	public void setSubmits(Boolean value) {
		this.getElement().setProperty("submits", value);
	}

	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<Ui5Button> {

		public ClickEvent(Ui5Button source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("ClickEvent ...");
			Notification.show("clicked on button " + source.getElement().getProperty("text"));
		}
	}

	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}

}
