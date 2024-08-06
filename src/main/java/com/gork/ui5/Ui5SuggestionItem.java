/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Input/
 * https://sap.github.io/ui5-webcomponents/playground/components/MultiInput/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-suggestion-item")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.1.1")
@JsModule("@ui5/webcomponents/dist/SuggestionItem.js")
public class Ui5SuggestionItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5SuggestionItem.class);

	public Ui5SuggestionItem() {
		LOGGER.info("constructor ...");
	}

	public void setText(String value) {
		this.getElement().setProperty("text", value);
	}

	public void setSlot(String value) {
		this.getElement().setProperty("slot", value);
	}

}
