/**
 * https://sap.github.io/ui5-webcomponents/playground/components/MultiInput/
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
@Tag("ui5-multi-input")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.11")
@JsModule("@ui5/webcomponents/dist/MultiInput.js")
public class Ui5MultiInput extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MultiInput.class);

	public Ui5MultiInput() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("slot", "tokens");
	}

	public void setShowValueHelpIcon(Boolean value) {
		this.getElement().setProperty("showValueHelpIcon", value);
	}

	public void setShowSuggestions(Boolean value) {
		this.getElement().setProperty("showSuggestions", value);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
