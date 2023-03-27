/**
 * https://sap.github.io/ui5-webcomponents/playground/components/ComboBox/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-combobox")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.11.0")
@JsModule("@ui5/webcomponents/dist/ComboBox.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
public class Ui5ComboBox extends AbstractSinglePropertyField<Ui5ComboBox, Boolean> implements HasLabel {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ComboBox.class);

	public Ui5ComboBox() {
		super("value", false, false);
		LOGGER.info("constructor ...");
		addListener(ChangeEvent.class, null);
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setAccessibleNameRef(String accessibleNameRef) {
		this.getElement().setProperty("accessibleNameRef", accessibleNameRef);
	}

	public boolean getDisabled() {
		return Boolean.getBoolean(getElement().getProperty("disabled"));
	}

	public void setDisabled(Boolean disabled) {
		this.getElement().setProperty("disabled", disabled);
	}

	public void setFilter(ComboboxFilter filterType) {
		this.getElement().setProperty("filter", filterType.toString());
	}

	public enum ComboboxFilter { StartsWithPerTerm, StartsWith, Contains }

	public void setLoading(Boolean loading) {
		this.getElement().setProperty("loading", loading);
	}

	// For the name property to have effect, you must add the following import to your project:
	// import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";
	public void setName(String value) {
		this.getElement().setProperty("name", value);
	}

	public void setPlaceholder(String placeholder) {
		this.getElement().setProperty("placeholder", placeholder);
	}

	public boolean getReadonly() {
		return Boolean.getBoolean(getElement().getProperty("readonly"));
	}

	public void setReadonly(Boolean readonly) {
		this.getElement().setProperty("readonly", readonly);
	}

	public void setValue(String value) {
		this.getElement().setProperty("value", value);
	}

	/**
	 * Default: None
	 * @param valueState
	 */
	public void setValueState(ComboboxValueState valueState) {
		this.getElement().setProperty("valueState", valueState.toString());
	}

	public enum ComboboxValueState { None, Warning, Error, Success, Information }

	@DomEvent("change")
	public static class ChangeEvent extends ComponentEvent<Ui5ComboBox> {

		public ChangeEvent(Ui5ComboBox source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("checked"));
//			Notification.show("value changed to " + source.getElement().getProperty("checked"));
		}
		
	}

	@DomEvent("input")
	public static class InputEvent extends ComponentEvent<Ui5ComboBox> {

		public InputEvent(Ui5ComboBox source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("input " + source.getElement().getProperty("checked"));
//			Notification.show("input " + source.getElement().getProperty("checked"));
		}
		
	}

	@DomEvent("selection-change")
	public static class SelectionValueChangeEvent extends ComponentEvent<Ui5ComboBox> {

		public SelectionValueChangeEvent(Ui5ComboBox source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("selection changed to " + source.getElement().getProperty("item"));
//			Notification.show("selection changed to " + source.getElement().getProperty("item"));
		}
		
	}

}
