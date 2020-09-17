package ai.makeitright.tests.scraper;


import ai.makeitright.models.Realtor;
import ai.makeitright.utilities.DriverConfig;
import ai.makeitright.utilities.Methods;
import ai.makeitright.utilities.Reporter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class Service {
    public static void main(String args[])
        throws InterruptedException {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            //Pause for 4 seconds
            Thread.sleep(40000);
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }
}

// public class Service extends DriverConfig {

//     Gson gson = new GsonBuilder().setPrettyPrinting().create();

//     private String BaseURL;
//     private String City;
//     private String State;

//     @Before
//     public void before() {
//         BaseURL = System.getProperty("inputParameters.baseURL");
//         City = System.getProperty("inputParameters.city").toLowerCase();
//         State = System.getProperty("inputParameters.state").toLowerCase();
//     }

//     @Test
//     public void getRealtors() throws IOException {
//         BufferedWriter writer ;
//         String outFileName = "leads.csv";
//         String workspacePath = System.getProperty("ARTIFACTS_PATH");
//         String outFilePath = workspacePath + System.getProperty("file.separator") + outFileName;
//         String baseTargetURL = BaseURL + City + "_" + State;
//         System.out.println("baseTargetURL: " + baseTargetURL);

//         int totalPages = getTotalPages(baseTargetURL);
//         System.out.println("totalPages: " + totalPages);

//         List<Realtor> realtors = new ArrayList<Realtor>();
//         String targetURL;
//         writer = new BufferedWriter(new FileWriter(outFilePath,true));
//         CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
//                 .withHeader("Name", "Phone", "City", "State"));

//         for (int page = 0; page < totalPages; page++) {
//             targetURL = baseTargetURL + "/pg-" + page;
//             System.out.println("targetURL: " + targetURL);

//             driver.navigate().to(targetURL);

//             List<WebElement> contactInfoElements = driver.findElements(By.xpath("//a[@id='call_inquiry_cta']"));
//             System.out.println("contactInfoElements size: " + contactInfoElements.size());


//             for (WebElement contactInfo : contactInfoElements) {
//                 String cityState = contactInfo.getAttribute("data-agent-address");
//                 System.out.println("cityState: " + cityState);
//                 Realtor realtor = new Realtor(
//                         contactInfo.getAttribute("data-agent-name"),
//                         contactInfo.getAttribute("href").replace("tel:", ""),
//                         cityState.split(",")[0],
//                         cityState.split(",")[1].trim()
//                 );
//                 System.out.println("realtor: " + realtor);
//                 realtors.add(realtor);
//                 csvPrinter.printRecord(realtor.getName(),
//                         realtor.getPhoneNumber(),
//                         realtor.getCity(),
//                         realtor.getState());
//             }
//         }
//         csvPrinter.flush();
//         csvPrinter.close();

//         System.setProperty("output", String.format("{\"result\": %s}", gson.toJson(realtors)));

//         System.out.println("output: " + gson.fromJson(System.getProperty("output"), Map.class));
//     }

//     private int getTotalPages(String url) {
//         driver.navigate().to(url);
//         List<WebElement> paginationElements = driver.findElements(By.xpath("//a[@data-pjax='pjax']"));
//         Collections.reverse(paginationElements);

//         int totalPages = Integer.parseInt(paginationElements.get(1).getText().trim());

//         return totalPages;
//     }
// }
