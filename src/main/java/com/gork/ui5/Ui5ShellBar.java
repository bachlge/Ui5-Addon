/**
 * https://sap.github.io/ui5-webcomponents/playground/components/ShellBar/
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
@Tag("ui5-shellbar")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.0.0-rc.11")
@JsModule("@ui5/webcomponents-fiori/dist/ShellBar.js")
public class Ui5ShellBar extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ShellBar.class);

	public Ui5ShellBar() {
		LOGGER.info("constructor ...");
		this.showCoPilot(true); // show by default
		this.showProductSwitch(true); // show by default
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setTitle(String title) {
		this.getElement().setProperty("primaryTitle", title);
	}

	public void setSecondaryTitle(String title) {
		this.getElement().setProperty("secondaryTitle", title);
	}

	public void showCoPilot(Boolean copilot) {
		this.getElement().setProperty("showCoPilot", copilot);
	}

	public void showProductSwitch(Boolean productswitch) {
		this.getElement().setProperty("showProductSwitch", productswitch);
	}

	public void showNotifications(Boolean showNotifications) {
		this.getElement().setProperty("showNotifications", showNotifications);
	}

	public void setNotificationCount(String notificationCount) {
		this.getElement().setProperty("notificationCount", notificationCount);
	}


}
