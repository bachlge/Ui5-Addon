/**
 * https://sap.github.io/ui5-webcomponents/playground/components/MultiInput/
 * 
 * + Label (implements HasLabel)
 * + Data binding
 * + Change Event
 * 
 */
package com.gork.ui5;

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

import elemental.json.JsonValue;

@SuppressWarnings("serial")
@Tag("ui5-multi-input")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.12.0")
@JsModule("@ui5/webcomponents/dist/MultiInput.js")
@JsModule("@ui5/webcomponents/dist/features/InputSuggestions.js")
public class Ui5MultiInput extends Component implements HasComponents, HasLabel, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MultiInput.class);

	public Ui5MultiInput() {
		LOGGER.info("constructor ...");
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


	/**
	 * Convenience Method
	 * add Token to `tokens`-Slot of the MultiInput Component
	 *
	 * @param token
	 */
	public void addToken(Ui5Token token) {
		token.setSlot("tokens");
		add(token);
	}

	/**
	 * Convenience Method
	 * add multiple Tokens to `tokens`-Slot of the MultiInput Component
	 *
	 * @param token
	 */
	public void addTokens(Ui5Token... tokens) {
		for(Ui5Token token : tokens) {
			token.setSlot("tokens");
			add(token);
		}
	}


	/**
	 * 
	 * Fired when a token is about to be deleted.
	 *
	 */
	@DomEvent("token-delete")
	public static class TokenDeleteEvent extends ComponentEvent<Ui5MultiInput> {

		private final String tokens;

		public TokenDeleteEvent(Ui5MultiInput source, boolean fromClient,
				@EventData("element.token") JsonValue token) {
			super(source, fromClient);
			this.tokens = "dummy token value";
			LOGGER.info("Token=" + token);
			Notification.show("Ui5MultiInput.TokenDeleteEvent - token=" + token);
		}
		public String getToken() {
			return tokens;
		}
	}

	public Registration addTokenDeleteListener(ComponentEventListener<TokenDeleteEvent> listener) {
		return addListener(TokenDeleteEvent.class, listener);
	}

	/**
	 * Fired when the input operation has finished by pressing Enter or on focusout.
	 *
	 */
	@DomEvent("change")
	public static class ChangeEvent extends ComponentEvent<Ui5MultiInput> {

		private final String token;
		public ChangeEvent(Ui5MultiInput source, boolean fromClient,
				@EventData("element.checked") String value) {
			super(source, fromClient);
			this.token = value;
			Notification.show("Ui5MultiInput.ChangeEvent - value=" + value);
		}
		public String getToken() {
			return token;
		}
	}

	public Registration addChangeListener(ComponentEventListener<ChangeEvent> listener) {
		return addListener(ChangeEvent.class, listener);
	}

}
