/**
 * https://sap.github.io/ui5-webcomponents/playground/components/MultiComboBox/
 */
package com.gork.ui5;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

import elemental.json.JsonArray;
import elemental.json.JsonObject;
import elemental.json.JsonValue;

@SuppressWarnings("serial")
@Tag("ui5-multi-combobox")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.19.0")
@JsModule("@ui5/webcomponents/dist/MultiComboBox.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
//public class Ui5MultiComboBox extends AbstractSinglePropertyField<Ui5MultiComboBox, Boolean> implements HasComponents, HasLabel, HasSize {
public class Ui5MultiComboBox extends Component implements HasComponents, HasLabel, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MultiComboBox.class);

	public Ui5MultiComboBox() {
//		super("value", false, false);
		setWidthFull();
		LOGGER.info("constructor ...");
	}

	public void addItem(Ui5MultiComboBoxItem item) {
		this.add(item);
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

	/**
	 * Defines if the user input will be prevented, if no matching item has been found
	 * Default: false
	 * @param value
	 */
	public void setAllowCustomValues(Boolean value) {
		this.getElement().setProperty("allowCustomValues", value);
	}

	/**
	 * convenience method
	 */
	public void setAllowCustomValues() {
		setAllowCustomValues(true);
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

	/**
	 * Defines the value of the component.
	 * @param value
	 */
	public void setValue(String value) {
		this.getElement().setProperty("value", value);
	}

	/**
	 * Defines the value state of the component.
	 * Default: None
	 * @param valueState
	 */
	public void setValueState(ComboboxValueState valueState) {
		this.getElement().setProperty("valueState", valueState.toString());
	}

	public enum ComboboxValueState { None, Warning, Error, Success, Information }


	/**
	 * Fired when the input operation has finished by pressing Enter or on focusout.
	 *
	 */
	@DomEvent("change")
	public static class ChangeEvent extends ComponentEvent<Ui5MultiComboBox> {

		public ChangeEvent(Ui5MultiComboBox source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5MultiComboBox.ChangeEvent");
		}
	}

	public Registration addChangeListener(ComponentEventListener<ChangeEvent> listener) {
		return addListener(ChangeEvent.class, listener);
	}


	/**
	 * Fired when the value of the component changes at each keystroke.
	 *
	 */
	@DomEvent("input")
	public static class InputEvent extends ComponentEvent<Ui5MultiComboBox> {

		public InputEvent(Ui5MultiComboBox source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5MultiComboBox.InputEvent");
		}
	}

	public Registration addInputListener(ComponentEventListener<InputEvent> listener) {
		return addListener(InputEvent.class, listener);
	}


	/**
	 * Fired when the dropdown is opened or closed
	 *
	 */
	@DomEvent("open-change")
	public static class OpenChangeEvent extends ComponentEvent<Ui5MultiComboBox> {

		public OpenChangeEvent(Ui5MultiComboBox source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5MultiComboBox.OpenChangeEvent " + source.getElement().getProperty("item"));
			Notification.show("OpenChangeEvent " + source.getElement().getProperty("item"));
		}
	}

	public Registration addOpenChangeListener(ComponentEventListener<OpenChangeEvent> listener) {
		return addListener(OpenChangeEvent.class, listener);
	}


	/**
	 * Fired when selection is changed by user interaction in SingleSelect and MultiSelect modes.
	 * items type: Array
	 * an array of the selected items.
	 *
	 */
	@DomEvent("selection-change")
//	public static class SelectionChangeEvent<R extends Ui5MultiComboBox> extends ComponentEvent<Ui5MultiComboBox> {
	public static class SelectionChangeEvent extends ComponentEvent<Ui5MultiComboBox> {

		private JsonArray items;

		public SelectionChangeEvent(Ui5MultiComboBox source, boolean fromClient) {
//		public SelectionChangeEvent(Ui5MultiComboBox source, boolean fromClient,
//				@EventData("element.items") JsonArray items) {
			super(source, fromClient);
			LOGGER.info("Ui5MultiComboBox.SelectionChangeEvent");
//			LOGGER.info("details=", details);
			if (!fromClient) return;
//			this.items = detail.getArray("items");
//			LOGGER.info("Ui5MultiComboBoxSelectionChangeEvent: items=" + items);
		}

		public List<Object> getValues() {
			ArrayList<Object> listdata = new ArrayList<Object>();
			for (int i = 0; i < items.length(); i++) {
				listdata.add(items.get(i));
			}
			return listdata;
		}

	}

	public Registration addSelectionChangeListener(ComponentEventListener<SelectionChangeEvent> listener) {
		return addListener(SelectionChangeEvent.class, listener);
	}

}
