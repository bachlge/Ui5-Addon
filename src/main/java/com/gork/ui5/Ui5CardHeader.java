/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Card/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;

@SuppressWarnings("serial")
@Tag("ui5-card-header")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.1.1")
@NpmPackage(value = "@ui5/webcomponents-icons", version = "^2.1.1")
@JsModule("@ui5/webcomponents/dist/CardHeader.js")
public class Ui5CardHeader extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5CardHeader.class);

	public Ui5CardHeader() {
		LOGGER.info("constructor ...");
//		setIcon("example"); // default icon
		getElement().setProperty("slot", "header");
	}

	public void setIcon(String icon) {
		Ui5Icon ui5Icon = new Ui5Icon();
		ui5Icon.setIcon(icon);
		ui5Icon.getElement().setProperty("slot", "avatar");
		add(ui5Icon);
		// docu says: <ui5-card avatar="group" heading="Team Space" ...>
		// but: (Error) : Cannot set slots directly, use the DOM APIs
//		this.getElement().setProperty("avatar", icon);
	}

	@Deprecated
	public void setTitle(String title) {
		setTitleText(title);
	}

	public void setTitleText(String title) {
		this.getElement().setProperty("titleText", title);
	}

	@Deprecated
	public void setSubTitle(String title) {
		setSubTitleText(title);
	}

	public void setSubTitleText(String title) {
		this.getElement().setProperty("subtitleText", title);
	}

	public void setStatus(String status) {
		this.getElement().setProperty("status", status);
	}

	/**
	 * Convenience Method
	 * Ui5Card wants the Ui5CardHeader to be put in slot `header`
	 */
	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}

	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<Ui5CardHeader> {

		public ClickEvent(Ui5CardHeader source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("ClickEvent ...");
			Notification.show("clicked on card header " + source.getElement().getProperty("text"));
		}
		
	}

}
