/**
 * https://ui5.github.io/webcomponents/components/fiori/ShellBarBranding/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-shell-bar-branding")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.22.0")
@JsModule("@ui5/webcomponents-fiori/dist/ShellBarBranding.js")
public class Ui5ShellBarBranding extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ShellBarBranding.class);

	public Ui5ShellBarBranding() {
		LOGGER.info("constructor ...");
	}

	public void setAccessibleName(String text) {
		this.getElement().setProperty("accessibleName", text);
	}

	public void setHref(String text) {
		this.getElement().setProperty("href", text);
	}

	public void setTarget(Target target) {
		this.getElement().setProperty("target", target.toString());
	}

	/**
	 * Defines the logo of the ui5-shellbar. For example, you can use ui5-avatar or img elements as logo.
	 */
	public void setLogo(Component logoComponent) {
		add(logoComponent);
		logoComponent.getElement().setAttribute("slot", "logo");
	}

	public enum Target {
		_self,
		_top,
		_blank,
		_parent,
		_search,
	}

	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<Ui5ShellBarBranding> {

		public ClickEvent(Ui5ShellBarBranding source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5ShellBarBranding ClickEvent ...");
			Notification.show("clicked on Ui5ShellBarBranding " + source.getElement().getProperty("text"));
		}
	}

	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}

}
