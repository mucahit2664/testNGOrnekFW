package com.techproed.tests;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.techproed.pages.CkHotelsHomePage;
import com.techproed.utitilies.ConfigReader;
import com.techproed.utitilies.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.crypto.KeyAgreementSpi;

public class D33_Data_Provider_Coklu {
    //{{"Manager","Manager"},{"Manager1","Manager1"},{"Manager2","Manager2"},{"Manager3","Manager3"}};
    @Test (dataProvider = "kullanicilar")
    public void test(String isim,String sifre){
        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
        CkHotelsHomePage ckHotelsHomePage =new CkHotelsHomePage();
        ckHotelsHomePage.ilkLogIn.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(isim);
        ckHotelsHomePage.passwordTextBox.sendKeys(sifre);
        ckHotelsHomePage.loginButonu.click();
        Assert.assertTrue(ckHotelsHomePage.girilemediYazisi.isDisplayed());
        Driver.closeDriver();
    }
    // array[4][2]
    @DataProvider(name="kullanicilar")
    public Object[][] kullaniciOlustur(){
        String datalar[][]={{"Manager","Manager"},{"Manager1","Manager1"},{"Manager2","Manager2"},{"Manager3","Manager3"}};
        return datalar;
    }
}
