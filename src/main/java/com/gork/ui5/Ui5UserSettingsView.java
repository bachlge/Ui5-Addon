/**
 * https://sap.github.io/ui5-webcomponents/components/fiori/UserSettingsView/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-user-settings-view")

@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.12.0")

@JsModule("@ui5/webcomponents-fiori/dist/UserSettingsView.js")

public class Ui5UserSettingsView extends Component {//implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5UserSettingsView.class);

	public Ui5UserSettingsView() {
		LOGGER.info("constructor ...");
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

	public void setSelected(Boolean value) {
		this.getElement().setProperty("selected", value);
	}

	/**
	 * convenience method
	 */
	public void setSelected() {
		setSelected(true);
	}

	public void setSecondary(Boolean value) {
		this.getElement().setProperty("secondary", value);
	}

	/**
	 * convenience method
	 */
	public void setSecondary() {
		setSecondary(true);
	}


}
