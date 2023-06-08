package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gork.ui5.Ui5Button.ButtonDesign;
import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-toggle-button")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.14.0")
@NpmPackage(value = "@ui5/webcomponents-icons", version = "^1.14.0")
@JsModule("@ui5/webcomponents/dist/ToggleButton.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
public class Ui5ToggleButton extends AbstractSinglePropertyField<Ui5ToggleButton, Boolean> implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ToggleButton.class);

	public Ui5ToggleButton() {
		super("value", false, false);
		LOGGER.info("constructor ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setAccessibleNameRef(String accessibleNameRef) {
		this.getElement().setProperty("accessibleNameRef", accessibleNameRef);
	}

	/**
	 * ButtonDesign reused from Ui5Button component
	 * @param design
	 */
	public void setDesign(ButtonDesign design) {
		this.getElement().setProperty("design", design.toString());
	}

	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public void setIconEnd(Boolean iconEnd) {
		this.getElement().setProperty("iconEnd", iconEnd);
	}

	// For the name property to have effect, you must add the following import to your project:
	// import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";
	public void setName(String value) {
		this.getElement().setProperty("name", value);
	}

	public void setPressed(Boolean pressed) {
		this.getElement().setProperty("pressed", pressed);
	}

	/**
	 * When set to true, the component will automatically submit the nearest form element upon press.
	 * default: false
	 * @param value
	 */
	public void setSubmits(Boolean value) {
		this.getElement().setProperty("submits", value);
	}

	public void setTooltip(String value) {
		this.getElement().setProperty("tooltip", value);
	}


	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}

	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<Ui5ToggleButton> {

		private final boolean value;

		public ClickEvent(Ui5ToggleButton source, boolean fromClient,
				@EventData("element.pressed") boolean value) {
			super(source, fromClient);
			this.value = value;
			Notification.show("Ui5ToggleButton.ClickEvent - pressed=" + value);
		}
		public boolean getPressed() {
			return value;
		}
	}

}
