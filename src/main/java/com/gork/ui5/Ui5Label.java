/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Label/
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
@Tag("ui5-label")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.1")
@JsModule("@ui5/webcomponents/dist/Label.js")
public class Ui5Label extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Label.class);

	public Ui5Label() {
		LOGGER.info("constructor ...");
	}

	public Ui5Label(String value) {
		super();
		add(value);
	}

	public void setFor(String value) {
		this.getElement().setProperty("for", value);
	}

	public void setRequired(boolean value) {
		this.getElement().setProperty("required", value);
	}

	public void setShowColon(boolean value) {
		this.getElement().setProperty("showColon", value);
	}

	public void setWrap(boolean value) {
		this.getElement().setProperty("wrap", value);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
