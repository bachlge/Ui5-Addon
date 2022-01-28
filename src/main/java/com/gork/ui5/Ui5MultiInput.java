/**
 * https://sap.github.io/ui5-webcomponents/playground/components/MultiInput/
 * 
 * + Label (implements HasLabel)
 * + Data binding
 * + Change Event
 * 
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
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-multi-input")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/MultiInput.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
@JsModule("@ui5/webcomponents/dist/features/InputSuggestions.js")
public class Ui5MultiInput extends Component implements HasLabel, HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MultiInput.class);

	public Ui5MultiInput() {
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

	public void setDisabled(Boolean disabled) {
		this.getElement().setProperty("disabled", disabled);
	}

	public void setMaxLength(int value) {
		this.getElement().setProperty("maxLength", value);
	}

	// For the name property to have effect, you must add the following import to your project:
	// import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";
	public void setName(String value) {
		this.getElement().setProperty("name", value);
	}

	public void setPlaceholder(String value) {
		this.getElement().setProperty("placeholder", value);
	}

	public void setReadonly(Boolean value) {
		this.getElement().setProperty("readonly", value);
	}

	public void setRequired(Boolean value) {
		this.getElement().setProperty("required", value);
	}


	public void setShowValueHelpIcon(Boolean value) {
		this.getElement().setProperty("showValueHelpIcon", value);
	}

	public void setShowSuggestions(Boolean value) {
		this.getElement().setProperty("showSuggestions", value);
	}

	/**
	 * Default: Text
	 * @param type
	 */
	public void setType(InputType type) {
		this.getElement().setProperty("inputType", type.toString());
	}

	public enum InputType { Text, Email, Number, Password, Tel, URL }

	/**
	 * Default None
	 * @param valueState
	 */
	public void setValueState(ValueState valueState) {
		this.getElement().setProperty("valueState", valueState.toString());
	}

	public enum ValueState { None, Error, Warning, Success, Information }

	@DomEvent("token-delete")
	public static class TokenDeleteEvent extends ComponentEvent<Ui5MultiInput> {

		public TokenDeleteEvent(Ui5MultiInput source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("TokenDeleteEvent ...");
			Notification.show("TokenDeleteEvent " + source.getElement().getProperty("text"));
		}
	}

	public Registration addTokenDeleteListener(ComponentEventListener<TokenDeleteEvent> listener) {
		return addListener(TokenDeleteEvent.class, listener);
	}
}
