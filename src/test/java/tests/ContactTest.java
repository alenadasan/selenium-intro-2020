package tests;

import builders.ContactInfo;
import org.junit.jupiter.api.Test;
import pages.ContactPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static utils.Constants.HOME_PAGE_URL;

public class ContactTest extends TestBase {

    @Test
    void canSendContact() {
        driver.get(HOME_PAGE_URL + "contactus");

        ContactPage contactPage = new ContactPage(driver);
        ContactInfo contactInfoBuilder = new ContactInfo.ContactInfoBuilder()
                .name("Gigi")
                .enquiry("Hello")
                .build();

        contactPage.fillContactUs(contactInfoBuilder);

        assertThat(contactPage.getErrorMessages(), contains("Enter email"));
    }
}
