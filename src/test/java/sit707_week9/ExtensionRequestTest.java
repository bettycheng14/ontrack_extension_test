package sit707_week9;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;

public class ExtensionRequestTest {

    // Helper baseline dates for testing
    LocalDate dueDate = LocalDate.of(2026, 05, 07);

    @Test
    public void testValidExtensionRequest() {
        String testName = "testValidExtensionRequest";
        String reason = "I have been severely ill this week.";
        LocalDate requestedDate = dueDate.plusDays(5);
        
        String status = ExtensionValidator.submitRequest(reason, dueDate, requestedDate);
        
        System.out.println(testName + " | Params: [" + reason + ", " + dueDate + ", " + requestedDate + "] | Returned: " + status);
        
        Assert.assertEquals("Submission success", status);
    }

    @Test
    public void testReasonEmpty() {
        String testName = "testReasonEmpty";
        String reason = "";
        LocalDate requestedDate = dueDate.plusDays(2);
        
        String status = ExtensionValidator.submitRequest(reason, dueDate, requestedDate);
        
        System.out.println(testName + " | Params: [" + reason + ", " + dueDate + ", " + requestedDate + "] | Returned: " + status);
        Assert.assertEquals("You must enter a reason", status);
    }

    @Test
    public void testReasonTooShort() {
        String testName = "testReasonTooShort";
        String reason = "More time plz";
        LocalDate requestedDate = dueDate.plusDays(2);
        
        String status = ExtensionValidator.submitRequest(reason, dueDate, requestedDate);
        
        System.out.println(testName + " | Params: [" + reason + ", " + dueDate + ", " + requestedDate + "] | Returned: " + status);
        Assert.assertEquals("The reason must be at least 15 characters long", status);
    }

    @Test
    public void testDateBeforeDueDate() {
        String testName = "testDateBeforeDueDate";
        String reason = "I need more time to finish this.";
        LocalDate requestedDate = dueDate.minusDays(1);
        
        String status = ExtensionValidator.submitRequest(reason, dueDate, requestedDate);
        
        System.out.println(testName + " | Params: [" + reason + ", " + dueDate + ", " + requestedDate + "] | Returned: " + status);
        Assert.assertEquals("Due date too early", status);
    }

    @Test
    public void testDateBeyondSevenDays() {
        String testName = "testDateBeyondSevenDays";
        String reason = "I need more time to finish this.";
        LocalDate requestedDate = dueDate.plusDays(7);
        
        String status = ExtensionValidator.submitRequest(reason, dueDate, requestedDate);
        
        System.out.println(testName + " | Params: [" + reason + ", " + dueDate + ", " + requestedDate + "] | Returned: " + status);
        Assert.assertEquals("Due date too late", status);
    }
}