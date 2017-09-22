package testResources;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class TestData
{

    @DataProvider(name = "LoginRU_TestDataProvider")
    public static Object[][] getlogRUData()
    {
        Object[][] data = new Object[1][2];
        data[0][0] = "testeraccount@list.ru"; //email
        data[0][1] = "qwerty"; //password
        return data;
    }

    @DataProvider(name = "LoginWithUnregisteredEmail_TestDataProvider")
    public static Object[][] getUnregisteredEmail()
    {
        Object[][] data = new Object[1][2];
        data[0][0] = RandomStringUtils.randomAlphabetic(5).toLowerCase() + "@getnada.com";  //email
        data[0][1] = "qwerty"; //password
        return data;
    }

    @DataProvider(name = "LoginWithInvalidPass_TestDataProvider")
    public static Object[][] getInvalidPassword()
    {
        Object[][] data = new Object[1][2];
        data[0][0] = "testeraccount@list.ru";  //email
        data[0][1] = RandomStringUtils.randomAlphabetic(7); //password
        return data;
    }

    @DataProvider(name = "LoginWithBlankPass_TestDataProvider")
    public static Object[][] getBlankPassword()
    {
        Object[][] data = new Object[1][2];
        data[0][0] = "testeraccount@list.ru";  //email
        data[0][1] = ""; //password
        return data;
    }

    @DataProvider(name = "LoginWithBlankEmail_TestDataProvider")
    public static Object[][] getBlankEmail()
    {
        Object[][] data = new Object[1][2];
        data[0][0] = "";  //email
        data[0][1] = "qwerty"; //password
        return data;
    }

    @DataProvider(name = "LoginWithBlankEmailAndPass_TestDataProvider")
    public static Object[][] getBlankEmailAndPass()
    {
        Object[][] data = new Object[1][2];
        data[0][0] = "";  //email
        data[0][1] = ""; //password
        return data;
    }

    @DataProvider(name = "Registration_TestDataProvider")
    public static Object[][] RegistrationRUData()
    {
        Object[][] data = new Object[1][7];
        data[0][0] = RandomStringUtils.randomAlphabetic(5).toLowerCase(); //first name
        data[0][1] = RandomStringUtils.randomAlphabetic(8).toLowerCase(); //last name
        data[0][2] = "USA"; //country
        data[0][3] = RandomStringUtils.randomNumeric(4) + " " + RandomStringUtils.randomAlphabetic(7) + "Str, " + RandomStringUtils.randomAlphabetic(6); //address
        data[0][4] = RandomStringUtils.randomNumeric(10); //phone
        data[0][5] = RandomStringUtils.randomAlphabetic(5).toLowerCase() + "@getnada.com";//email
        data[0][6] = RandomStringUtils.randomAlphanumeric(6);//password
        return data;
    }

    @DataProvider(name = "NewTalent_TestDataProvider")
    public static Object[][] NewTalentData ()
    {
        Object[][] data = new Object[1][25];
        data[0][0] = RandomStringUtils.randomAlphabetic(5).toLowerCase(); //firstName
        data[0][1] = RandomStringUtils.randomAlphabetic(4).toLowerCase(); //middleName
        data[0][2] = RandomStringUtils.randomAlphabetic(6).toLowerCase(); //lastName
        data[0][3] = "03231990"; //dob
        data[0][4] = RandomStringUtils.randomAlphabetic(8).toLowerCase(); //placeOfBirth
        data[0][5] = RandomStringUtils.randomNumeric(4) + RandomStringUtils.randomAlphabetic(7) + RandomStringUtils.randomAlphabetic(6); //address
        data[0][6] = RandomStringUtils.randomAlphabetic(5).toLowerCase() + "@getnada.com";//newEmail
        data[0][7] = RandomStringUtils.randomNumeric(10); //phone
        data[0][8] = "facebook.com/" + RandomStringUtils.randomAlphabetic(6).toLowerCase(); //socialAccount
        data[0][9] = RandomStringUtils.randomNumeric(3); //height
        data[0][10] = RandomStringUtils.randomNumeric(2); //weight
        data[0][11] = RandomStringUtils.randomAlphabetic(10); //college
        data[0][12] = RandomStringUtils.randomAlphabetic(5); //successLevel
        data[0][13] = RandomStringUtils.randomAlphabetic(1, 500); //evidence
        data[0][14] = RandomStringUtils.randomAlphanumeric(1, 255); //workProduct
        data[0][15] = RandomStringUtils.randomNumeric(6); //income
        data[0][16] = RandomStringUtils.randomAlphanumeric(1, 500); //headline
        data[0][17] = RandomStringUtils.randomNumeric(2); //years
        data[0][18] = RandomStringUtils.randomAlphabetic(1, 500); //gutFeel
        data[0][19] = RandomStringUtils.randomAlphabetic(1, 500); //rationale
        data[0][20] = RandomStringUtils.randomAlphabetic(1, 100); //score
        data[0][21] = RandomStringUtils.randomAlphabetic(1, 100); //rank
        data[0][22] = RandomStringUtils.randomAlphabetic(1, 10); //talentTrait1
        data[0][23] = RandomStringUtils.randomAlphabetic(1, 10); //talentTrait2
        data[0][24] = RandomStringUtils.randomAlphabetic(1, 10); //talentTrait3
        return data;
    }

    @DataProvider(name = "NewTalentRUself_TestDataProvider")
    public static Object[][] NewTalentSelf ()
    {
        Object[][] data = new Object[1][19];
        data[0][0] = "03231990"; //dob
        data[0][1] = RandomStringUtils.randomAlphabetic(8).toLowerCase(); //placeOfBirth
        data[0][2] = "facebook.com/" + RandomStringUtils.randomAlphabetic(6).toLowerCase(); //socialAccount
        data[0][3] = RandomStringUtils.randomNumeric(3); //height
        data[0][4] = RandomStringUtils.randomNumeric(2); //weight
        data[0][5] = RandomStringUtils.randomAlphabetic(10); //college
        data[0][6] = RandomStringUtils.randomAlphabetic(5); //successLevel
        data[0][7] = RandomStringUtils.randomAlphabetic(1, 500); //evidence
        data[0][8] = RandomStringUtils.randomAlphanumeric(1, 255); //workProduct
        data[0][9] = RandomStringUtils.randomNumeric(6); //income
        data[0][10] = RandomStringUtils.randomAlphanumeric(1, 500); //headline
        data[0][11] = RandomStringUtils.randomNumeric(2); //years
        data[0][12] = RandomStringUtils.randomAlphabetic(1, 500); //gutFeel
        data[0][13] = RandomStringUtils.randomAlphabetic(1, 500); //rationale
        data[0][14] = RandomStringUtils.randomAlphabetic(1, 100); //score
        data[0][15] = RandomStringUtils.randomAlphabetic(1, 100); //rank
        data[0][16] = RandomStringUtils.randomAlphabetic(1, 10); //talentTrait1
        data[0][17] = RandomStringUtils.randomAlphabetic(1, 10); //talentTrait2
        data[0][18] = RandomStringUtils.randomAlphabetic(1, 10); //talentTrait3
        return data;
    }
}



