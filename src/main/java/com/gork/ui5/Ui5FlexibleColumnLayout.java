/**
 * https://sap.github.io/ui5-webcomponents/playground/components/FlexibleColumnLayout/
 * 
 * Slots:
 * 		startColumn
 * 		midColumn
 * 		endColumn
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gork.ui5.Ui5Switch.ChangeEvent;
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
@Tag("ui5-flexible-column-layout")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.1.2")
@JsModule("@ui5/webcomponents-fiori/dist/FlexibleColumnLayout.js")
public class Ui5FlexibleColumnLayout extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5FlexibleColumnLayout.class);

	public Ui5FlexibleColumnLayout() {
		LOGGER.info("constructor ...");
		// otherwise width is 0
    	getElement().getStyle().set("width", "100%");

	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAccessibleRoles(String accessibleRoles) {
		this.getElement().setProperty("accessibleRoles", accessibleRoles);
	}

	public void setAccessibleTexts(String accessibleTexts) {
		this.getElement().setProperty("accessibleTexts", accessibleTexts);
	}

	public void setHideArrows(boolean value) {
		this.getElement().setProperty("hideArrows", value);
	}

	/**
	 * Default: OneColumn
	 * @param layout
	 */
	public void setLayout(FCLLayout layout) {
		this.getElement().setProperty("layout", layout.toString());
	}

	public enum FCLLayout {
		OneColumn,
		TwoColumnsStartExpanded,
		TwoColumnsMidExpanded,
		ThreeColumnsMidExpanded,
		ThreeColumnsEndExpanded,
		ThreeColumnsStartExpandedEndHidden,
		ThreeColumnsMidExpandedEndHidden,
		MidColumnFullScreen,
		EndColumnFullScreen
		}

	/**
	 * Convienience Method
	 * @param component
	 * @param slot
	 */
	public void addTo(Component component, Slot slot) {
		component.getElement().setAttribute("slot", slot.toString());
		this.add(component);
	}

	public void addToStart(Component component) {
		this.addTo(component, Slot.startColumn);
	}

	public void addToMid(Component component) {
		this.addTo(component, Slot.midColumn);
	}

	public void addToEnd(Component component) {
		this.addTo(component, Slot.endColumn);
	}

	public enum Slot {
		startColumn,
		midColumn,
		endColumn		
	}

	@DomEvent("layout-change")
	public static class LayoutChangeEvent extends ComponentEvent<Ui5FlexibleColumnLayout> {

		public LayoutChangeEvent(Ui5FlexibleColumnLayout source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("LayoutChangeEvent ...");
			Notification.show("layout changed " + source.getElement().getProperty("text"));
		}
	}

	public Registration addChangeListener(ComponentEventListener<LayoutChangeEvent> listener) {
		return addListener(LayoutChangeEvent.class, listener);
	}

}
