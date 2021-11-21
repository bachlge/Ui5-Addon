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

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-flexible-column-layout")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.0.0-rc.14")
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

	public void setLayout(Layout layout) {
		this.getElement().setProperty("layout", layout.toString());
	}

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

	public void setNoArrows(boolean value) {
		this.getElement().setProperty("noArrows", value);
	}


	public enum Layout {
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

	public enum Slot {
		startColumn,
		midColumn,
		endColumn		
	}

}
