package ai.makeitright.tests.todoist.additemtotodoistfromheader;

import ai.makeitright.pages.todoist.MainTodoistPage;
import org.junit.Assert;
import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Service {
    private String TASKNAME;
//    private String TASKTIME;
    private String URL;

//    @BeforeClass
//    public static void beforeClass() {
//        System.setProperty("inputParameters.url","http://todoist-dev.s3-website-us-east-1.amazonaws.com/");
//        System.setProperty("inputParameters.taskname","Task for automatic tests");
//        System.setProperty("inputParameters.tasktime","Inbox");
//    }

    @Before
    public void before() {
        URL = System.getProperty("inputParameters.url");
        TASKNAME = System.getProperty("inputParameters.taskname");
//        TASKTIME = System.getProperty("inputParameters.tasktime");
    }

    @Test
    public void addItemToTodoistFromHeader() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--single-process");
        options.addArguments("--use-gl=swiftshader");
        options.addArguments("--no-zygote");


        WebDriver browser = new ChromeDriver(options);
        browser.get(URL);

        browser.manage().window().maximize();
        MainTodoistPage mainPage = new MainTodoistPage(browser,URL);

        mainPage.clickButtonPlus_Header();

        String taskName = mainPage.setTaskName(TASKNAME);

        mainPage.clickButtonAddTask();

        Assert.assertTrue(mainPage.isTaskAtInbox(taskName));

        System.setProperty("output",String.format("{\"result\":{\"task_name\":\"%s\"}}",taskName));

    }
}
