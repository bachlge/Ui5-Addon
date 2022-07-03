/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Input/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-suggestion-group-item")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.4.0")
@JsModule("@ui5/webcomponents/dist/SuggestionItem.js")
public class Ui5SuggestionGroupItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5SuggestionGroupItem.class);

	public Ui5SuggestionGroupItem() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setText(String value) {
		this.getElement().setProperty("text", value);
	}

}
