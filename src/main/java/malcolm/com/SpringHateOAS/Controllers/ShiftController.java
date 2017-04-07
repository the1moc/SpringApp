package malcolm.com.SpringHateOAS.Controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import malcolm.com.SpringHateOAS.Models.Shift;
import malcolm.com.SpringHateOAS.Repositories.ShiftsRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/** Main controller for shift API requests.
 * @author malcolm-campbell
 */
@RestController
@RequestMapping("/api")
public class ShiftController {

	@Autowired
	ShiftsRepository shiftRepo;
	
    /** Fetch all the shifts for all workers.
     * @return All shifts for all workers.
     */
    @RequestMapping("/getAllShifts")
    public ResponseEntity<List<Shift>> getShiftsByFirstName() {
    	List<Shift> shifts = (List<Shift>) shiftRepo.getAllShifts();
    	shifts.forEach(shift -> shift.add(linkTo(methodOn(ShiftController.class).getShiftsByFirstName()).withSelfRel()));

        return new ResponseEntity<List<Shift>>(shifts, HttpStatus.OK);
    }
	
    /** Fetch all the shifts for all workers with this name.
     * @param firstName The first name for the worker.
     * @return All shifts for workers with a matching first name.
     */
    @RequestMapping("/getShiftsFor/{firstName}")
    public ResponseEntity<List<Shift>> getShiftsByFirstName(@PathVariable("firstName") String firstName) {
    	List<Shift> shifts = shiftRepo.findByFirstName(firstName);
    	shifts.forEach(shift -> shift.add(linkTo(methodOn(ShiftController.class).getShiftsByFirstName(firstName)).withSelfRel()));

        return new ResponseEntity<List<Shift>>(shifts, HttpStatus.OK);
    }
    
    /** Fetch all the shifts for all workers with the given first and last name.
     * @param firstName The first name for the worker.
     * @param lastName The last name for the worker.
     * @return All shifts for workers with matching first and second names
     */
    @RequestMapping("/getShiftsFor/{firstName}/{lastName}")
    public ResponseEntity<List<Shift>> getShiftsByFirstName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
    	List<Shift> shifts = shiftRepo.findByFirstAndLastName(firstName, lastName);
    	shifts.forEach(shift -> shift.add(linkTo(methodOn(ShiftController.class).getShiftsByFirstName(firstName, lastName)).withSelfRel()));

        return new ResponseEntity<List<Shift>>(shifts, HttpStatus.OK);
    }
    
    /** Fetch all the shifts happening on a specific day.
     * @param day The day of the week.
     * @return All shifts for workers with matching first and second names
     */
    @RequestMapping("/shiftsOnDay/{day}")
    public ResponseEntity<List<Shift>> getShiftsOnSpecificDay(@PathVariable("day") String day) {
    	List<Shift> shifts = shiftRepo.findByDay(day);
    	shifts.forEach(shift -> shift.add(linkTo(methodOn(ShiftController.class).getShiftsByFirstName(day)).withSelfRel()));

        return new ResponseEntity<List<Shift>>(shifts, HttpStatus.OK);
    }
    
    /** Fetch all the shifts happening on a specific day.
     * @param day The day of the week.
     * @return All shifts for workers with matching first and second names
     */
    @RequestMapping("/shiftsAtTime/{time}")
    public ResponseEntity<List<Shift>> getShiftsAtSpecificTime(@PathVariable("time") String time) {
    	List<Shift> shifts = shiftRepo.findByTime(time);
    	shifts.forEach(shift -> shift.add(linkTo(methodOn(ShiftController.class).getShiftsAtSpecificTime(time)).withSelfRel()));

        return new ResponseEntity<List<Shift>>(shifts, HttpStatus.OK);
    }
}