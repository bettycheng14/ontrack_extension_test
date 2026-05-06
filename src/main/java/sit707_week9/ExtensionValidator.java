package sit707_week9;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ExtensionValidator {
	    
    public static String submitRequest(String reason, LocalDate dueDate, LocalDate requestedDate) {
        // Reason not empty
        if (reason == null || reason.trim().isEmpty()) {
            return "You must enter a reason";
        }
        // Reason >= 15 characters
        if (reason.length() < 15) {
        	return "The reason must be at least 15 characters long";
        }
        // Date not before due date
        if (requestedDate.isBefore(dueDate)) {
            return "Due date too early";
        }
        // Date not after 7 days from due date
        long daysBetween = ChronoUnit.DAYS.between(dueDate, requestedDate);
        if (daysBetween > 6) {
            return "Due date too late";
        }
        
        // If all validations pass
        return "Submission success";
    }
}
