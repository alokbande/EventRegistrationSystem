package com.event.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.event.domain.Employees;
import com.event.domain.EmployeeEvent;
import com.event.domain.Events;
import com.event.form.RegisterEmployeeEventForm;
import com.event.service.EmployeeEventService;

/**
 * @author M1021173
 * 
 *         EmplyeeEventController is used for getting list of Employees , Events
 *         and Register Emplyoee to Events.
 */
@Controller
@RequestMapping("/event")
public class EmplyeeEventController {

	private static final Logger logger = LoggerFactory.getLogger(EmplyeeEventController.class);

	@Autowired
	private EmployeeEventService employeeEventService;

	@RequestMapping(value = { "/registerEmployeeForEvents" })
	public String registerEmployeeForEvents(ModelMap model,
			@ModelAttribute("registerEmployeeEventForm") RegisterEmployeeEventForm registerEmployeeEventForm,
			BindingResult result, HttpSession session) {
		try {
			logger.debug("registerEmployeeForEvents {}", registerEmployeeEventForm);
			model.addAttribute("listEmployee", employeeEventService.getListEmployee());
			model.addAttribute("listEvent", employeeEventService.getListEvent());
		} catch (Exception e) {
			logger.error("registerEmployeeForEvents {}", e);
		}
		return "registerEmployeeForEvents";
	}

	@RequestMapping(value = "/submitRegisterEmployeeEventForm")
	public ModelAndView submitRegisterEmployeeEventForm(Model model,
			@ModelAttribute("registerEmployeeEventForm") RegisterEmployeeEventForm registerEmployeeEventForm,
			BindingResult result, HttpSession session) {
		ModelAndView mav = new ModelAndView("registerEmployeeForEvents");
		try {
			if (!validateRegisterEmployeeEventForm(registerEmployeeEventForm, result)) {
				logger.debug("submitSelfAssessmentForm validation failed {}", registerEmployeeEventForm);
				model.addAttribute("listEmployee", employeeEventService.getListEmployee());
				model.addAttribute("listEvent", employeeEventService.getListEvent());
				return mav;
			} else {
				logger.debug("Registred successfully {}", registerEmployeeEventForm);
				mav = new ModelAndView("home");
				employeeEventService.registerEmployeeEvent(registerEmployeeEventForm);
				model.addAttribute("registerEmployeeEventSuccess", "Registred successfully.");
			}
		} catch (Exception e) {
			logger.error("submitSelfAssessmentForm {}", e);
		}
		return mav;
	}

	@RequestMapping(value = { "/displayAllEmployeeEvents" })
	public String displayAllEmployeeEvents(ModelMap model,
			@ModelAttribute("registerEmployeeEventForm") RegisterEmployeeEventForm registerEmployeeEventForm,
			BindingResult result, HttpSession session) {
		try {
			List<EmployeeEvent> employeeEvents = employeeEventService.getListEmployeeEvent();
			logger.debug("displayAllEmployeeEvents {}", employeeEvents);
			model.addAttribute("employeeEvents", employeeEvents);
		} catch (Exception e) {
			logger.error("displayAllEmployeeEvents {}", e);
		}
		return "displayAllEmployeeEvents";
	}

	@RequestMapping(value = { "/displayAllEmployees" })
	public String displayAllEmployees(ModelMap model,
			@ModelAttribute("registerEmployeeEventForm") RegisterEmployeeEventForm registerEmployeeEventForm,
			BindingResult result, HttpSession session) {
		try {
			List<Employees> employees = employeeEventService.getListEmployee();
			logger.debug("displayAllEmployeeEvents {}", employees);
			model.addAttribute("employees", employees);
		} catch (Exception e) {
			logger.error("displayAllEmployeeEvents {}", e);
		}
		return "displayAllEmployees";
	}

	@RequestMapping(value = { "/displayAllEvents" })
	public String displayAllEvents(ModelMap model,
			@ModelAttribute("registerEmployeeEventForm") RegisterEmployeeEventForm registerEmployeeEventForm,
			BindingResult result, HttpSession session) {
		try {
			List<Events> events = employeeEventService.getListEvent();
			logger.debug("displayAllEvents {}", events);
			model.addAttribute("events", events);
		} catch (Exception e) {
			logger.error("displayAllEvents {}", e);
		}
		return "displayAllEvents";
	}

	private boolean validateRegisterEmployeeEventForm(RegisterEmployeeEventForm registerEmployeeEventForm,
			BindingResult result) throws Exception {
		FieldError fieldErr = null;
		boolean isRecordExist = false;
		if (registerEmployeeEventForm.getMid() == null || registerEmployeeEventForm.getMid().isEmpty()) {
			fieldErr = new FieldError("registerEmployeeEventForm", "mid", "Please select Employee Name");
			result.addError(fieldErr);
		}

		if (registerEmployeeEventForm.getEventId() == null) {
			fieldErr = new FieldError("registerEmployeeEventForm", "eventId", "Please select Event Title");
			result.addError(fieldErr);
		}

		if (registerEmployeeEventForm.getEventId() != null && !registerEmployeeEventForm.getMid().isEmpty()) {

			Events events = employeeEventService.findById(Events.class, registerEmployeeEventForm.getEventId());
			Employees employees = employeeEventService.findById(Employees.class, registerEmployeeEventForm.getMid());
			List<EmployeeEvent> employeeEvents = employeeEventService.getListEmployeeEvent();
			for (EmployeeEvent employeeEvent : employeeEvents) {
				if (employees.getMid().equals(employeeEvent.getPk().getEmployee().getMid())
						&& events.getEventId().equals(employeeEvent.getPk().getEvent().getEventId())) {
					isRecordExist = true;
				}
			}
		}

		if (isRecordExist) {
			fieldErr = new FieldError("registerEmployeeEventForm", "",
					"Employee-Event Combination of Regisration already Exist");
			result.addError(fieldErr);
		}

		if (result.hasErrors()) {
			return false;
		}
		return true;
	}

	@RequestMapping(value = { "/home" })
	public String home(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = { "/cancel" })
	public String cancel(ModelMap model) {
		return "home";
	}
}
