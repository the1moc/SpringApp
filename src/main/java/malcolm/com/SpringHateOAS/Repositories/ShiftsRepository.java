package malcolm.com.SpringHateOAS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import malcolm.com.SpringHateOAS.Models.Shift;

public interface ShiftsRepository extends CrudRepository<Shift, Long> {
	// Query to get all shifts.
	String getAllQuery = "SELECT shifts.id, workers.firstname, workers.lastName, days.day, times.TimeOfDay as time FROM shifts "
			+ "INNER JOIN times on shifts.TimeId = times.Id "
			+ "INNER JOIN days on shifts.DayId = days.Id "
			+ "INNER JOIN workers on shifts.WorkerId = workers.Id";
	
	// Query by first name.
	String getByFirstNameQuery = "SELECT shifts.id, workers.firstname, workers.lastName, days.day, times.TimeOfDay as time FROM shifts "
								+ "INNER JOIN times on shifts.TimeId = times.Id "
								+ "INNER JOIN days on shifts.DayId = days.Id "
								+ "INNER JOIN workers on shifts.WorkerId = workers.Id "
								+ "WHERE workers.firstname = :firstName";
	
	// Query by first name and second name.
	String getByFirstAndLastNameQuery = "SELECT shifts.id, workers.firstname, workers.lastName, days.day, times.TimeOfDay as time FROM shifts "
										+ "INNER JOIN times on shifts.TimeId = times.Id "
										+ "INNER JOIN days on shifts.DayId = days.Id "
										+ "INNER JOIN workers on shifts.WorkerId = workers.Id "
										+ "WHERE workers.firstname = :firstName AND workers.lastname = :lastName";
	
	// Query by day.
	String getByDay = "SELECT shifts.id, workers.firstname, workers.lastName, days.day, times.TimeOfDay as time FROM shifts "
						+ "INNER JOIN times on shifts.TimeId = times.Id "
						+ "INNER JOIN days on shifts.DayId = days.Id "
						+ "INNER JOIN workers on shifts.WorkerId = workers.Id "
						+ "WHERE days.day = :day";

	// Query by time.
	String getByTime = "SELECT shifts.id, workers.firstname, workers.lastName, days.day, times.TimeOfDay as time FROM shifts "
						+ "INNER JOIN times on shifts.TimeId = times.Id "
						+ "INNER JOIN days on shifts.DayId = days.Id "
						+ "INNER JOIN workers on shifts.WorkerId = workers.Id "
						+ "WHERE times.TimeOfDay = :time";
	
	// Query by time and day.
	String getByDayAndTime = "SELECT shifts.id, worker.firstname, worker.lastName, days.day, times.TimeOfDay as time FROM shifts "
						+ "INNER JOIN times on shifts.TimeId = times.Id "
						+ "INNER JOIN days on shifts.DayId = days.Id "
						+ "INNER JOIN worker on shifts.WorkerId = workers.Id "
						+ "WHERE times.TimeOfDay = :time" 
						+ "AND days.day = :day";
	
	@Query(value = getAllQuery, nativeQuery = true)
	List<Shift> getAllShifts();
	
	@Query(value = getByFirstNameQuery, nativeQuery = true)
	List<Shift> findByFirstName(@Param("firstName") String firstName);
	
	@Query(value = getByFirstAndLastNameQuery, nativeQuery = true)
	List<Shift> findByFirstAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	@Query(value = getByDay, nativeQuery = true)
	List<Shift> findByDay(@Param("day") String day);
	
	@Query(value = getByTime, nativeQuery = true)
	List<Shift> findByTime(@Param("time") String time);
	
	@Query(value = getByDayAndTime, nativeQuery = true)
	List<Shift> filterShifts(@Param("day") String day, @Param("time") String time);
}
