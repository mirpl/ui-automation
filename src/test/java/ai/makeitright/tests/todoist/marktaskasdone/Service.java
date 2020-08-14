package ai.makeitright.tests.todoist.marktaskasdone;

import ai.makeitright.pages.todoist.MainTodoistPage;
import ai.makeitright.utilities.DriverConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Service extends DriverConfig {
    private String TASKNAME;
    private String URL;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("inputParameters.url","http://todoist-dev.s3-website-us-east-1.amazonaws.com/");
        System.setProperty("inputParameters.taskname","Task for automatic tests 2020-07-13 09:11:43");
    }

    @Before
    public void before() {
        URL = System.getProperty("inputParameters.url");
        TASKNAME = System.getProperty("inputParameters.taskname");
    }

    @Test
    public void addItemToTodoistFromHeader() {
        driver.get(URL);
        driver.manage().window().maximize();
        MainTodoistPage mainPage = new MainTodoistPage(driver,URL);

        Assert.assertTrue(mainPage.markTaskDone(TASKNAME));

        Assert.assertFalse(mainPage.isTaskAtInbox(TASKNAME));

//        System.setProperty("output", "success");
//        System.setProperty("inputParameters.taskname", taskName);
    }
}
