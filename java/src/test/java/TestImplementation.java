import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestImplementation {

    private WebDriver driver;

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        // for Edge
	    System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/msedgedriver.exe");
    }

    @Before
    public void setup() {
        // Driver pour chrome dans la partie 2
        //driver = new ChromeDriver();

        /*
        // Driver distant pour la partie 3 Chrome version :  97.0.4692.71
        String Hub = "http://localhost:4444";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        try {
            driver = new RemoteWebDriver(new URL(Hub), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
*/

        // Driver distant pour la partie 3 Microsoft edge version : 97.0.1072.69
        String HubEdge = "http://localhost:4444";
        DesiredCapabilities capsEdge = new DesiredCapabilities();
        capsEdge.setBrowserName("MicrosoftEdge");
        try {
            driver = new RemoteWebDriver(new URL(HubEdge), capsEdge);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



        // for Edge
        //driver = new EdgeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyGitHubTitle() {
        driver.get("https://www.github.com");
        assertThat(driver.getTitle(), containsString("GitHub"));
    }

    @Test
    public void verifyPageTitle() {
        driver.get("https://lambdatest.github.io/sample-todo-app/");
        assertThat(driver.getTitle(), containsString("Sample page"));
    }

    // Cocher les checkbox et check de si elles sont cochées
    @Test
    public void checkFirstElem() {
        driver.get("https://lambdatest.github.io/sample-todo-app/");
        driver.findElement(By.name("li1")).click();
        boolean firstIsChecked = driver.findElement(By.name("li1")).isSelected();
        assertEquals(firstIsChecked, true);
    }

    @Test
    public void checkSecondElem() {
        driver.get("https://lambdatest.github.io/sample-todo-app/");
        driver.findElement(By.name("li2")).click();
        boolean secondIsChecked = driver.findElement(By.name("li2")).isSelected();
        assertEquals(secondIsChecked, true);
    }

    @Test
    public void checkTirdElem() {
        driver.get("https://lambdatest.github.io/sample-todo-app/");
        driver.findElement(By.name("li3")).click();
        boolean thirdIsChecked = driver.findElement(By.name("li3")).isSelected();
        assertEquals(thirdIsChecked, true);
    }

    @Test
    public void checkFourthElem() {
        driver.get("https://lambdatest.github.io/sample-todo-app/");
        driver.findElement(By.name("li4")).click();
        boolean fourthIsChecked = driver.findElement(By.name("li4")).isSelected();
        assertEquals(fourthIsChecked, true);
    }

    @Test
    public void checkFifthElem() {
        driver.get("https://lambdatest.github.io/sample-todo-app/");
        driver.findElement(By.name("li5")).click();
        boolean fifthIsChecked = driver.findElement(By.name("li5")).isSelected();
        assertEquals(fifthIsChecked, true);
    }

    //Clique dans le text et ecrire une nouvelle entrée et check si elle est ajoutée et non cochée
    @Test
    public void newEntryCheck() {
        driver.get("https://lambdatest.github.io/sample-todo-app/");
        WebElement textZone = driver.findElement(By.id("sampletodotext"));
        textZone.sendKeys("new");
        driver.findElement(By.id("addbutton")).click();

        WebElement newElement = driver.findElement(By.name("li6"));
        assertNotNull(newElement);

        boolean newIsUnChecked = driver.findElement(By.name("li6")).isSelected();
        assertEquals(newIsUnChecked, false);
    }


    // Décoche le 5ème élément et check si il est bien décoché
    @Test
    public void uncheckFifthElem() {
        driver.get("https://lambdatest.github.io/sample-todo-app/");
        driver.findElement(By.name("li5")).click();
        boolean fifthIsUnChecked = driver.findElement(By.name("li5")).isSelected();
        assertEquals(fifthIsUnChecked, true);
        driver.findElement(By.name("li5")).click();
        fifthIsUnChecked = driver.findElement(By.name("li5")).isSelected();
        assertEquals(fifthIsUnChecked, false);
    }
}
