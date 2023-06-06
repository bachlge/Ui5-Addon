/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Card/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-card")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.14.0")
@NpmPackage(value = "@ui5/webcomponents-icons", version = "^1.14.0")
@JsModule("@ui5/webcomponents/dist/Card.js")
//@JsModule("@ui5/webcomponents-icons/dist/example.js")
//@JsModule("@ui5/webcomponents-icons/dist/folder-blank.js")
public class Ui5Card extends Component implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Card.class);

	private Ui5CardHeader header = new Ui5CardHeader();

	public Ui5Card() {
		LOGGER.info("constructor ...");
//		setIcon("example"); // default icon
		header.setSlot("header");
		add(header);
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setAccessibleNameRef(String accessibleNameRef) {
		this.getElement().setProperty("accessibleNameRef", accessibleNameRef);
	}

	/**
	 * Convenience Method: Set Header Icon
	 * @param icon
	 */
	public void setIcon(String icon) {
/*
		Ui5Icon ui5Icon = new Ui5Icon();
		ui5Icon.setIcon(icon);
		ui5Icon.getElement().setProperty("slot", "avatar");
		add(ui5Icon);
		// docu says: <ui5-card avatar="group" heading="Team Space" ...>
		// but: (Error) : Cannot set slots directly, use the DOM APIs
//		this.getElement().setProperty("avatar", icon);
 * 
 */
		header.setIcon(icon);
	}

	/**
	 * Convenience Method: Set Header Title
	 * @param title
	 */
	public void setTitle(String title) {
//		this.getElement().setProperty("titleText", title);
		header.setTitleText(title);
	}

	/**
	 * Convenience Method: Set Header SubtTitle
	 * @param sub-title
	 */
	public void setSubTitle(String title) {
//		this.getElement().setProperty("subtitleText", title);
		header.setSubTitleText(title);
	}

	/**
	 * Convenience Method: Set Header Statut
	 * @param statut
	 */
	public void setStatus(String status) {
//		this.getElement().setProperty("status", status);
		header.setStatus(status);
	}

}
