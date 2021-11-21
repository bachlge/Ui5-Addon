/**

	Vaadin Java Component for SAP UI5 SegmentedButton webcomponent 

	see:
		https://sap.github.io/ui5-webcomponents/playground/components/SegmentedButton/

	overview:
		The ui5-segmentedbutton shows a group of buttons.
		When the user clicks or taps one of the buttons, it stays in a pressed state.
		It automatically resizes the buttons to fit proportionally within the component.
		When no width is set, the component uses the available width.

		Note: There can be just one selected button at a time.

	use:
		Ui5SegmentedButton ui5SegmentedButtonRating = new Ui5SegmentedButton();

		Ui5ToggleButton ui5ToggleButton_0 = new Ui5ToggleButton();
		ui5ToggleButton_0.add("0");

		Ui5ToggleButton ui5ToggleButton_1 = new Ui5ToggleButton();
		ui5ToggleButton_1.add("1");

		getContent().add(ui5SegmentedButtonRating);
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

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
@Tag("ui5-segmentedbutton")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.1")
@JsModule("@ui5/webcomponents/dist/SegmentedButton.js")
public class Ui5SegmentedButton extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5SegmentedButton.class);

	public Ui5SegmentedButton() {
		LOGGER.info("constructor ...");
		addListener(ValueChangeEvent.class, null);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	@DomEvent("selection-change")
	public static class ValueChangeEvent extends ComponentEvent<Ui5SegmentedButton> {

		public ValueChangeEvent(Ui5SegmentedButton source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("checked"));
			Notification.show("value changed to " + source.getElement().getProperty("checked"));
		}
		
	}


}
