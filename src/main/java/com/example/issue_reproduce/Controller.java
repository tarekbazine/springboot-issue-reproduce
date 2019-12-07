package com.example.issue_reproduce;

import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/emails")
public class Controller {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> emails(Principal principal) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable("id") Long id) {
//
//		Appointment appointment = appointmentService.findOne(id);
//
//		if (appointment == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//
//		AppointmentDTO appointmentDTO = toAppointmentDTO.convert(appointment);
//
//		if (appointmentDTO == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//
//		return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/invited/{id}/{userId}/{response}", method = RequestMethod.GET)
//	public ResponseEntity getResponseForInvitationFromUser(@PathVariable("id") Long id,
//                                                           @PathVariable("userId") Long userId, @PathVariable("response") String response,
//                                                           HttpServletResponse servletResponse) throws IOException {
//
//		Appointment appointment = appointmentService.findOne(id);
//		User appointmentInvitee = userService.findOne(userId);
//
//		if (null == appointment || null == appointment.getParentTask()
//				|| null == appointment.getParentTask().getParentProject()) {
//			return new ResponseEntity(HttpStatus.NOT_FOUND);
//		}
//
//		appointmentService.processInvitationResponse(response, appointment, appointmentInvitee);
//
//		servletResponse.sendRedirect(appointmentService.generateRedirectAppointmentUrl(appointment));
//
//		return null;
//	}
//
//	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
//	public ResponseEntity<AppointmentDTO> add(@RequestBody AppointmentDTO newAppointment) throws ValidationException{
//
//		appointmentService.validate(newAppointment);
//
//		Appointment result = new Appointment();
//		try {
//			result = appointmentService.create(newAppointment);
//
//			loggingService.logSuccess("Created appointment" + result.getId(), Level.INFO);
//
//		} catch (Exception e) {
//			loggingService.logError("Failed to create appointment");
//		}
//
//		return new ResponseEntity<>(toAppointmentDTO.convert(result), HttpStatus.CREATED);
//	}
//
//	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST, consumes = "application/json")
//	public ResponseEntity<AppointmentDTO> edit(@RequestBody AppointmentDTO editAppointment, @PathVariable Long id) {
//
//		if (!id.equals(editAppointment.getId())) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		if (appointmentService.findOne(editAppointment.getId()) == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//
//		Appointment persisted = null;
//		try {
//			persisted = appointmentService.save(editAppointment);
//
//			loggingService.logSuccess("Edited appointment" + persisted.getId(), Level.INFO);
//
//		} catch (Exception e) {
//			loggingService.logError("Failed to edit appointment" + editAppointment.getId());
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		return new ResponseEntity<>(toAppointmentDTO.convert(persisted), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
//	public ResponseEntity delete(@PathVariable Long id) {
//		Appointment appointment = appointmentService.findOne(id);
//		if (appointment == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		try {
//			appointmentService.delete(appointment.getId());
//			loggingService.logSuccess("Deleted appointment " + appointment.getId(), Level.INFO);
//
//		} catch (Exception e) {
//			loggingService.logError("Failed to delete appointment " + appointment.getId());
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//
//	@RequestMapping(method = RequestMethod.POST, value = "/search")
//	public ResponseEntity<List<AppointmentDTO>> search(@RequestBody AppointmentFilter appointmentFilter) {
//
//		List<Appointment> appointments = appointmentService.search(appointmentFilter);
//
//		return new ResponseEntity<>(toAppointmentDTO.convert(appointments), HttpStatus.OK);
//	}
//
//	@RequestMapping(method = RequestMethod.POST, value = "/export")
//	public ResponseEntity<String> exportAppointments(@RequestBody AppointmentFilter appointmentFilter, @RequestParam Integer type)
//			throws IOException, DocumentException {
//
//		if (ExportType.values().length <= type) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		ExportType exportType = ExportType.values()[type];
//
//		List<Appointment> appointments = appointmentService.search(appointmentFilter);
//
//		String file = appointmentService.exportFile(exportType, "appointments", appointments);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Access-Control-Allow-Headers", "file-name");
//		headers.add("Access-Control-Expose-Headers", "file-name");
//		headers.add("file-name", helper.formatExportFile(exportType, "appointments"));
//
//		return ResponseEntity.ok().headers(headers).contentType(MediaType.valueOf(MediaType.APPLICATION_OCTET_STREAM_VALUE)).body(file);
//	}
//
//	@RequestMapping(value = "/{id}/following/{newStatus}", method = RequestMethod.POST)
//	public ResponseEntity<AppointmentDTO> updateFollowing(@PathVariable("id") Long id,
//                                                          @PathVariable("newStatus") Boolean newStatus, Principal principal) {
//
//		if (null == id || null == newStatus) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//
//		Appointment appointment = appointmentService.findOne(id);
//		if (appointment == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//
//		User user = userService.findUserByUsername(principal.getName());
//		List<User> followers = appointment.getFollowers();
//		boolean isFollowing = followers.contains(user);
//		if (isFollowing == newStatus) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//
//		if (newStatus) {
//			followers.add(user);
//		} else {
//			followers.remove(user);
//		}
//		appointment.setFollowers(followers);
//
//		Appointment persisted = appointmentService.save(appointment);
//
//		return new ResponseEntity<>(toAppointmentDTO.convert(persisted), HttpStatus.OK);
//	}
}
