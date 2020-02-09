package Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job jobOne;

    @Before
    public void createJobObject() {
        jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        Job jobTwo = new Job();
        assertEquals(1, jobTwo.getId() - jobOne.getId(), 0.0001);
    }

    @Test
    public void testJobConstructorSetsAllFIelds() {
        assertTrue(jobOne instanceof Job);
        assertTrue(jobOne.getName() instanceof String);
        assertTrue(jobOne.getEmployer() instanceof Employer);
        assertTrue(jobOne.getLocation() instanceof Location);
        assertTrue(jobOne.getPositionType() instanceof PositionType);
        assertTrue(jobOne.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester",jobOne.getName());
        assertEquals("ACME",jobOne.getEmployer().getValue());
        assertEquals("Desert",jobOne.getLocation().getValue());
        assertEquals("Quality control",jobOne.getPositionType().getValue());
        assertEquals("Persistence",jobOne.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job jobThree = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"),
                new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        assertFalse(jobOne.equals(jobThree));
    }

    @Test
    public void testForSpaces() {
        assertTrue(jobOne.toString().startsWith("\n"));
        assertTrue(jobOne.toString().endsWith("\n"));
    }

    @Test
    public void testForData() {
        String str = "\n" + "ID: " + jobOne.getId() + "\n" + "Name: " + jobOne.getName() + "\n" +
                "Employer: " + jobOne.getEmployer() + "\n" + "Location: " + jobOne.getLocation() + "\n" +
                "Position Type: " + jobOne.getPositionType() + "\n" + "Core Competency: " +
                jobOne.getCoreCompetency() + "\n";
        assertEquals(str,jobOne.toString());
    }

    @Test
    public void testForEmptyField() {
        Job jobFour = new Job("Ice cream tester", new Employer(""), new Location("Home"),
                new PositionType("UX"), new CoreCompetency("Tasting ability"));
        assertTrue(jobFour.toString().contains("Data not available"));
    }

    @Test
    public void testForNoData() {
        Job jobFive = new Job();
        assertEquals("OOPS! This job does not seem to exist.",jobFive.toString());
    }

}


















