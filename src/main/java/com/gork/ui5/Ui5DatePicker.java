package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;

@SuppressWarnings("serial")
@Tag("ui5-date-picker")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.12.0")
@JsModule("@ui5/webcomponents/dist/DatePicker.js")
public class Ui5DatePicker extends AbstractSinglePropertyField<Ui5Input, String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5DatePicker.class);

	public Ui5DatePicker() {
		super("value", "", false);
		LOGGER.info("constructor ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setAccessibleNameRef(String accessibleNameRef) {
		this.getElement().setProperty("accessibleNameRef", accessibleNameRef);
	}

	public void setName(String value) {
		this.getElement().setProperty("name", value);
	}

	public void setPlaceholder(String value) {
		this.getElement().setProperty("placeholder", value);
	}

	public void setFormatPattern(String value) {
		this.getElement().setProperty("formatPattern", value);
	}

	/**
	 * Defines a formatted date value.
	 */
	public void setValue(String value) {
		this.getElement().setProperty("value", value);
	}

	public void setMaxDate(String value) {
		this.getElement().setProperty("maxDate", value);
	}

	public void setMinDate(String value) {
		this.getElement().setProperty("minDate", value);
	}

	public void setValueState(ValueState valueState) {
		this.getElement().setProperty("valueState", valueState.toString());
	}

	/**
	 * Sets a calendar type used for display. If not set, the calendar type of the global configuration is used.
	 * @param calendarType
	 */
	public void setPrimaryCalendarType(CalendarType calendarType) {
		this.getElement().setProperty("primaryCalendarType", calendarType.toString());
	}

	/**
	 * Defines the secondary calendar type. If not set, the calendar will only show the primary calendar type.
	 * @param calendarType
	 */
	public void setSecondaryCalendarType(CalendarType calendarType) {
		this.getElement().setProperty("secondaryCalendarType", calendarType.toString());
	}

	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setReadonly(Boolean value) {
		this.getElement().setProperty("readonly", value);
	}

	public void setRequired(Boolean value) {
		this.getElement().setProperty("required", value);
	}

	public void setHideWeekNumbers(Boolean pressed) {
		this.getElement().setProperty("hideWeekNumbers", pressed);
	}


	public enum ValueState { None, Error, Warning, Success, Information }

	/**
	 * 
	 *
	 */
	// By default the Gregorian Calendar is used
	// In order to use the Buddhist, Islamic, Japanese or Persian calendar, you need to set the primaryCalendarType property and import one or more of the following modules:
	//	import "@ui5/webcomponents-localization/dist/features/calendar/Buddhist.js";
	//	import "@ui5/webcomponents-localization/dist/features/calendar/Islamic.js";
	//	import "@ui5/webcomponents-localization/dist/features/calendar/Japanese.js";
	//	import "@ui5/webcomponents-localization/dist/features/calendar/Persian.js";
	public enum CalendarType { Gregorian, Buddhist, Islamic, Japanese, Persian }

	@DomEvent("change")
	public static class ChangeEvent extends ComponentEvent<Ui5ComboBox> {

		public ChangeEvent(Ui5ComboBox source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("checked"));
			Notification.show("value changed to " + source.getElement().getProperty("checked"));
		}
		
	}

	@DomEvent("input")
	public static class InputEvent extends ComponentEvent<Ui5ComboBox> {

		public InputEvent(Ui5ComboBox source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("input " + source.getElement().getProperty("checked"));
			Notification.show("input " + source.getElement().getProperty("checked"));
		}
		
	}


}
