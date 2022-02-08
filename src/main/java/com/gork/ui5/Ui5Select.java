/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Select/
 */
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
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-select")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/Select.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
//public class Ui5MultiComboBox extends AbstractSinglePropertyField<Ui5MultiComboBox, Boolean> implements HasComponents, HasLabel, HasSize {
public class Ui5Select extends Component implements HasComponents, HasLabel, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Select.class);

	public Ui5Select() {
		LOGGER.info("constructor ...");
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

	// For the name property to have effect, you must add the following import to your project:
	// import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";
	public void setName(String value) {
		this.getElement().setProperty("name", value);
	}

	public void setRequired(Boolean value) {
		this.getElement().setProperty("required", value);
	}

	public String getSelectedOption() {
		return getElement().getProperty("selectedOption");
	}

	/**
	 * Default: None
	 * @param valueState
	 */
	public void setValueState(SelectValueState valueState) {
		this.getElement().setProperty("valueState", valueState.toString());
	}

	public enum SelectValueState { None, Warning, Error, Success, Information }


	/**
	 * Fired when the selected option changes.
	 *
	 */
	@DomEvent("change")
	public static class ChangeEvent extends ComponentEvent<Ui5Select> {

		private final String selectedOption;
		public ChangeEvent(Ui5Select source, boolean fromClient,
				@EventData("element.selectedOption") String selectedOption) {
			super(source, fromClient);
			this.selectedOption = selectedOption;
			LOGGER.info("Ui5Select.ChangeEvent - selectedOption=" + selectedOption);
		}
		public String getSelectedOption() {
			return selectedOption;
		}
	}

	public Registration addChangeListener(ComponentEventListener<ChangeEvent> listener) {
		return addListener(ChangeEvent.class, listener);
	}


}
