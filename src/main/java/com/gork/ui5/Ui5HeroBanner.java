/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Bar/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gork.ui5.Ui5FlexibleColumnLayout.Slot;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-hero-banner")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.12.0")
@JsModule("@ui5/webcomponents-fiori/dist/HeroBanner.js")
public class Ui5HeroBanner extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5HeroBanner.class);

	public Ui5HeroBanner() {
		LOGGER.info("constructor ...");
	}

	/**
	 * Defines the placement of the actions slot within the hero banner header.
	 * - TopEnd (default) - Actions are displayed to the right of the header text, at the top of the header row.
	 * - BottomStart - Actions are displayed below the header text, left-aligned, regardless of columnsRatio or slot usage.
	 */
	public void setActionsPlacement(ActionsPlacement actionsPlacement) {
		this.getElement().setProperty("actionsPlacement", actionsPlacement.toString());
	}

	public enum ActionsPlacement {
		BottomStart,
		TopEnd,
	}

	/**
	 * Defines the ratio between the two content columns inside the hero banner.
	 * Takes effect only when endContent is provided. When no endContent is present, the content spans the full width (single column).
	 * - Equal - Two equal columns. Both content blocks share the available width equally. On smaller screens, both slots stack vertically.
	 * - FirstWider - Two unequal columns. The start content takes two-thirds of the width, the end content one-third.
	 * On smaller screens, both slots stack vertically.
	 */
	public void setColumnsRatio(ColumnsRatio columnsRatio) {
		this.getElement().setProperty("columnsRatio", columnsRatio.toString());
	}

	public enum ColumnsRatio {
		Equal,
		FirstWider,
	}

	/**
	 * Defines the vertical placement of the header block within the content area.
	 * - Top (default) - Header block is placed at the top of the content area.
	 * - Bottom - Header block is pushed to the bottom of column 1.
	 * Only takes effect when columnsRatio is Equal or FirstWider and only endContent is provided (no default slot content).
	 * When actionsPlacement is also BottomStart, the endContent slot spans the full height.
	 */
	public void setHeaderBlockPlacement(HeaderBlockPlacement headerBlockPlacement) {
		this.getElement().setProperty("headerBlockPlacement", headerBlockPlacement.toString());
	}

	public enum HeaderBlockPlacement {
		Bottom,
		Top,
	}

	public void setHeaderText(String text) {
		this.getElement().setProperty("headerText", text);
	}

	public void setOoverlineText(String text) {
		this.getElement().setProperty("overlineText", text);
	}

	/**
	 * Convenience Method for adding content
	 * @param component
	 * @param slot
	 */
	public void addTo(Component component, Slot slot) {
		component.getElement().setAttribute("slot", slot.toString());
		this.add(component);
	}

	public void addToActions(Component component) {
		this.addTo(component, Slot.actions);
	}

	public void addToDefault(Component component) {
		this.add(component);
	}

	public void addToEndContent(Component component) {
		this.addTo(component, Slot.endContent);
	}

	/**
	 * 
	 */
	public enum Slot {
		actions,
		endContent,		
	}



}
