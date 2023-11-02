/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Calendar/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;

@SuppressWarnings("serial")
@Tag("ui5-calendar")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.19.0")
@JsModule("@ui5/webcomponents/dist/Calendar.js")
public class Ui5Calendar extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Calendar.class);

	public Ui5Calendar() {
		LOGGER.info("constructor ...");
	}

	public void setHideWeekNumbers(Boolean value) {
		this.getElement().setProperty("hideWeekNumbers", value);
	}

	/**
	 * Default: Single
	 * @param selectionMode
	 */
	public void setSelectionMode(CalendarSelectionMode selectionMode) {
		this.getElement().setProperty("selectionMode", selectionMode.toString());
	}

	public enum CalendarSelectionMode { Single, Range, Multiple }

	public void setFormatPattern(String formatPattern) {
		this.getElement().setProperty("formatPattern", formatPattern);
	}

	public void setMinDate(String minDate) {
		this.getElement().setProperty("minDate", minDate);
	}

	public void setMaxDate(String maxDate) {
		this.getElement().setProperty("maxDate", maxDate);
	}

	public void setPrimaryCalendarType(CalendarType calendarType) {
		this.getElement().setProperty("primaryCalendarType", calendarType.toString());
	}

	public void setSecondaryCalendarType(CalendarType calendarType) {
		this.getElement().setProperty("secondaryCalendarType", calendarType.toString());
	}

	public enum CalendarType { Gregorian, Buddhist, Islamic, Japanese, Persian }

	@DomEvent("selected-dates-change")
	public static class SelectedDatesChangeEvent extends ComponentEvent<Ui5Calendar> {

		public SelectedDatesChangeEvent(Ui5Calendar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("SelectedDatesChangeEvent ...");
			Notification.show("Selected Dates Change: " + source.getElement().getProperty("values"));
		}
		
	}

}
