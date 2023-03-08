package TestCaseList;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Base.BaseClass;
import PageObjects.HomePage;

public class TestCase extends BaseClass {

	HomePage page;
	SoftAssert sa = new SoftAssert();

	@Test
	public void localHost8080API() {
		page = new HomePage();
		for (int j = 0; j < 12; j++) {
			setUp(j);
			String str = page.getBody();
			System.out.println(str);
			if (property.getProperty("para" + j + "").startsWith("%")) {
				sa.assertEquals(str, "Bad Request");

			} else if (property.getProperty("para" + j + "").startsWith("#")) {
				sa.assertEquals(str, "Send GET to /:input");

			} else if (property.getProperty("para" + j + "").startsWith("/")) {
				sa.assertEquals(str, "Not Found");

			} else {

				for (int i = 0; i < str.length(); i++) {
					sa.assertFalse(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
							|| str.charAt(i) == 'o' || str.charAt(i) == 'u');
				}
			}

		}
		sa.assertAll();
	}
}
