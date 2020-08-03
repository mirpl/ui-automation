package ai.makeitright.tests.todoist.readtitleofpage;


import ai.makeitright.utilities.DriverConfig;

import org.junit.Before;

import org.junit.BeforeClass;
import org.junit.Test;



public class Service extends DriverConfig {

    private String URL;


//    @BeforeClass
//    public static void beforeClass() {
//        System.setProperty("inputParameters.url","http://todoist-dev.s3-website-us-east-1.amazonaws.com/");
//
//    }


    @Before
    public void before() {
        URL = System.getProperty("inputParameters.url");
    }

    @Test
    public void readTitleOfPage() {
        driver.get(URL);
        driver.manage().window().maximize();
        String pageTitle = driver.getTitle();
        System.setProperty("output", String.format("{\"result\":{\"url\":\"%s\",\"title_of_page\":\"%s\"}}",URL,pageTitle));
    }
}
