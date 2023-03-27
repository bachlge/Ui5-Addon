/**
 * https://sap.github.io/ui5-webcomponents/playground/components/CheckBox/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-checkbox")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.11.0")
@JsModule("@ui5/webcomponents/dist/CheckBox.js")
// For the name property to have effect, you must add the following import to your project:
// import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
public class Ui5CheckBox extends AbstractSinglePropertyField<Ui5CheckBox, Boolean> implements HasLabel {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5CheckBox.class);

	public Ui5CheckBox() {
		super("value", false, false);
		LOGGER.info("constructor ...");
//		addListener(ValueChangeEvent.class, null);
	}

	public boolean getChecked() {
		return Boolean.getBoolean(getElement().getProperty("checked"));
	}

	public void setChecked(Boolean checked) {
		this.getElement().setProperty("checked", checked);
	}

	public boolean getDisabled() {
		return Boolean.getBoolean(getElement().getProperty("disabled"));
	}

	public void setDisabled(Boolean disabled) {
		this.getElement().setProperty("disabled", disabled);
	}

	public boolean getIndeterminate() {
		return Boolean.getBoolean(getElement().getProperty("indeterminate"));
	}

	public void setIndeterminate(Boolean indeterminate) {
		this.getElement().setProperty("indeterminate", indeterminate);
	}

	public void setName(String value) {
		this.getElement().setProperty("name", value);
	}

	public boolean getReadonly() {
		return Boolean.getBoolean(getElement().getProperty("readonly"));
	}

	public void setReadonly(Boolean readonly) {
		this.getElement().setProperty("readonly", readonly);
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

	/**
	 * Default: None
	 * @param valueState
	 */
	public void setValueState(CheckboxValueState valueState) {
		this.getElement().setProperty("valueState", valueState.toString());
	}

	public enum CheckboxValueState { None, Warning, Error, Success, Information }

	/**
	 * Default: None
	 * @param valueState
	 */
	public void setWrappingType(WrappingType wrappingType) {
		this.getElement().setProperty("wrappingType", wrappingType.toString());
	}

	public enum WrappingType { None, Normal }


	@DomEvent("change")
	public static class ChangeEvent extends ComponentEvent<Ui5CheckBox> {

		private final boolean value;

		public ChangeEvent(Ui5CheckBox source, boolean fromClient,
				@EventData("element.checked") boolean value) {
			super(source, fromClient);
			this.value = value;
			Notification.show("Ui5CheckBox.ChangeEvent - value changed to " + value);
		}
		public boolean getChecked() {
			return value;
		}
	}

	public Registration addChangeListener(ComponentEventListener<ChangeEvent> listener) {
		return addListener(ChangeEvent.class, listener);
	}

}
