/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Link/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-link")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.14.0")
@JsModule("@ui5/webcomponents/dist/Link.js")
public class Ui5Link extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Link.class);

	public Ui5Link() {
		LOGGER.info("constructor ...");
	}

	public void setAccessibilityAttributes(String accessibilityAttributes) {
		this.getElement().setProperty("accessibilityAttributes", accessibilityAttributes);
	}

	public void setAccessibleNameRef(String accessibleNameRef) {
		this.getElement().setProperty("accessibleNameRef", accessibleNameRef);
	}

	/**
	 * Defines the component design
	 * Default: LinkDesign.Default
	 * @param LinkDesign
	 */
	public void setDesign(LinkDesign design) {
		this.getElement().setProperty("design", design.toString());
	}

	public enum LinkDesign { Default, Subtle, Emphasized }

	public boolean getDisabled() {
		return Boolean.getBoolean(getElement().getProperty("disabled"));
	}

	public void setDisabled(Boolean disabled) {
		this.getElement().setProperty("disabled", disabled);
	}

	public void setHref(String href) {
		this.getElement().setProperty("href", href);
	}

	public void setTarget(LinkTarget target) {
		this.getElement().setProperty("target", target.toString());
	}

	public enum LinkTarget { _self, _top, _blank, _parent, _search }

	public void setWrappingType(WrappingType wrappingType) {
		this.getElement().setProperty("wrappingType", wrappingType.toString());
	}

	public enum WrappingType { None, Normal }

	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<Ui5Button> {

		public ClickEvent(Ui5Button source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("ClickEvent ...");
			Notification.show("clicked on link " + source.getElement().getProperty("text"));
		}
	}

	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}

}
