/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Icon/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-icon")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.7")
@NpmPackage(value = "@ui5/webcomponents-icons", version = "^1.0.0-rc.7")
@JsModule("@ui5/webcomponents/dist/Icon.js")
@JsModule("@ui5/webcomponents-icons/dist/icons/employee.js")
@JsModule("@ui5/webcomponents-icons/dist/icons/loan.js")
public class Ui5Icon extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Icon.class);

	public Ui5Icon() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("name", "employee"); // default icon
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("name", icon);
	}

	public void setBig() {
		this.getElement().setProperty("style", "width:3rem;height:3rem;font-size:1.5rem;color:crimson;background-color:#fafafa");
	}

}
