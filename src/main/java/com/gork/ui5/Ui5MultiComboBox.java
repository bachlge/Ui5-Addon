/**
 * https://sap.github.io/ui5-webcomponents/playground/components/ComboBox/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;

@SuppressWarnings("serial")
@Tag("ui5-multi-combobox")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/MultiComboBox.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
public class Ui5MultiComboBox extends AbstractSinglePropertyField<Ui5MultiComboBox, Boolean> implements HasLabel {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MultiComboBox.class);

	public Ui5MultiComboBox() {
		super("value", false, false);
		LOGGER.info("constructor ...");
		addListener(ChangeEvent.class, null);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
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

	/**
	 * Default: StartsWithPerTerm
	 * @param filter
	 */
	public void setFilter(MultiComboboxFilter filterType) {
		this.getElement().setProperty("filter", filterType.toString());
	}

	public enum MultiComboboxFilter { StartsWithPerTerm, StartsWith, Contains, None }

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

	public void setReadonly(Boolean value) {
		this.getElement().setProperty("readonly", value);
	}

	public void setRequired(Boolean value) {
		this.getElement().setProperty("required", value);
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
	public static class ChangeEvent extends ComponentEvent<Ui5MultiComboBox> {

		public ChangeEvent(Ui5MultiComboBox source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("checked"));
			Notification.show("value changed to " + source.getElement().getProperty("checked"));
		}
		
	}

	@DomEvent("input")
	public static class InputEvent extends ComponentEvent<Ui5MultiComboBox> {

		public InputEvent(Ui5MultiComboBox source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("input " + source.getElement().getProperty("checked"));
			Notification.show("input " + source.getElement().getProperty("checked"));
		}
		
	}

	/**
	 * Fired when the dropdown is opened or closed
	 * @author georg
	 *
	 */
	@DomEvent("open-change")
	public static class OpenChangeEvent extends ComponentEvent<Ui5MultiComboBox> {

		public OpenChangeEvent(Ui5MultiComboBox source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("open status changed " + source.getElement().getProperty("item"));
			Notification.show("open status changed to " + source.getElement().getProperty("item"));
		}
		
	}
	@DomEvent("selection-change")
	public static class SelectionValueChangeEvent extends ComponentEvent<Ui5MultiComboBox> {

		public SelectionValueChangeEvent(Ui5MultiComboBox source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("selection changed to " + source.getElement().getProperty("item"));
			Notification.show("selection changed to " + source.getElement().getProperty("item"));
		}
		
	}

}
