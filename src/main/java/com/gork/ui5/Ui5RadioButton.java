package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-radiobutton")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/RadioButton.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
public class Ui5RadioButton extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5RadioButton.class);

	public Ui5RadioButton() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAccessibleNameRef(String accessibleNameRef) {
		this.getElement().setProperty("accessibleNameRef", accessibleNameRef);
	}

	public void setChecked(Boolean value) {
		this.getElement().setProperty("checked", value);
	}
	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	/**
	 * Radio buttons with the same name will form a radio button group
	 * @param name
	 */
	public void setName(String name) {
		this.getElement().setProperty("name", name);
	}

	public void setReadonly(Boolean value) {
		this.getElement().setProperty("readonly", value);
	}

	/**
	 * @deprecated use @setChecked instead
	 */
	public void setSelected(Boolean selected) {
		this.getElement().setProperty("selected", selected);
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

	public void setValue(String value) {
		this.getElement().setProperty("value", value);
	}

	public void setValueState(ValueState valueState) {
		this.getElement().setProperty("valueState", valueState.toString());
	}

	public enum ValueState { None, Warning, Error }

	@DomEvent("change")
	public static class ChangeEvent extends ComponentEvent<Ui5RadioButton> {

		public ChangeEvent(Ui5RadioButton source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("value"));
			Notification.show("value changed to " + source.getElement().getProperty("value"));
		}
	}

	public Registration addChangeListener(ComponentEventListener<ChangeEvent> listener) {
		return addListener(ChangeEvent.class, listener);
	}

}
