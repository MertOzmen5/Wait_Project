package WaitProject_1;
/*
    Senaryo
    1- https://testsheepnz.github.io/BasicCalculator.html sitesine gidiniz.
    2- random 100 e kadar 2 sayı üretiniz.
    3- Sayıları hesap makinesinin bütün fonksiyonları için çalıştırınız.
    4- Sonuçları Assert ile kontrol ediniz.
    5- Yukarıdaki işlemi 5 kez tekrar ettiriniz.
 */

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class wait extends BaseDriver {

    @Test

    public void test() {


        for (int i = 0; i < 5; i++) {


            driver.get("https://testsheepnz.github.io/BasicCalculator.html");

            wait.until(ExpectedConditions.urlToBe("https://testsheepnz.github.io/BasicCalculator.html"));

            WebElement randomNumber1 = driver.findElement(By.id("number1Field"));
            int sayi1 = (int) (Math.random() * 100);
            String number1 = String.valueOf(sayi1);
            randomNumber1.sendKeys(number1);

            WebElement randomNumber2 = driver.findElement(By.id("number2Field"));
            int sayi2 = (int) (Math.random() * 100);
            String number2 = String.valueOf(sayi2);
            randomNumber2.sendKeys(number2);

            for (int j = 0; j < 5; j++) {

                WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
                Select choose = new Select(operation);
                choose.selectByIndex(j);

                switch (j) {

                    case 0:
                        int sonuc = sayi1 + sayi2;
                        String sonuc1 = String.valueOf(sonuc);

                        WebElement calculate = driver.findElement(By.id("calculateButton"));
                        calculate.click();

                        WebElement answer = driver.findElement(By.id("numberAnswerField"));
                        wait.until(ExpectedConditions.visibilityOf(answer));
                        System.out.println("answer.getAttribute(\"value\") = " + answer.getAttribute("value"));

                        Assert.assertTrue("Answer is wrong.", answer.getAttribute("value").contains(sonuc1));
                        break;

                    case 1:
                        int sonuc2 = sayi1 - sayi2;
                        String sonuc3 = String.valueOf(sonuc2);

                        WebElement calculate1 = driver.findElement(By.id("calculateButton"));
                        calculate1.click();

                        WebElement answer1 = driver.findElement(By.id("numberAnswerField"));
                        wait.until(ExpectedConditions.visibilityOf(answer1));
                        System.out.println("answer.getAttribute(\"value\") = " + answer1.getAttribute("value"));

                        Assert.assertTrue("Answer is wrong.", answer1.getAttribute("value").contains(sonuc3));
                        break;

                    case 2:
                        int sonuc4 = sayi1 * sayi2;
                        String sonuc5 = String.valueOf(sonuc4);

                        WebElement calculate2 = driver.findElement(By.id("calculateButton"));
                        calculate2.click();

                        WebElement answer2 = driver.findElement(By.id("numberAnswerField"));
                        wait.until(ExpectedConditions.visibilityOf(answer2));
                        System.out.println("answer.getAttribute(\"value\") = " + answer2.getAttribute("value"));

                        Assert.assertTrue("Answer is wrong.", answer2.getAttribute("value").contains(sonuc5));
                        break;

                    case 3:
                        int sonuc6 = sayi1 / sayi2;
                        String sonuc7 = String.valueOf(sonuc6);

                        WebElement calculate3 = driver.findElement(By.id("calculateButton"));
                        calculate3.click();

                        WebElement answer3 = driver.findElement(By.id("numberAnswerField"));
                        wait.until(ExpectedConditions.visibilityOf(answer3));
                        System.out.println("answer.getAttribute(\"value\") = " + answer3.getAttribute("value"));

                        Assert.assertTrue("Answer is wrong.", answer3.getAttribute("value").contains(sonuc7));
                        break;

                    case 4:
                        String sonuc8 = number1 + number2;

                        WebElement calculate4 = driver.findElement(By.id("calculateButton"));
                        calculate4.click();

                        WebElement answer4 = driver.findElement(By.id("numberAnswerField"));
                        wait.until(ExpectedConditions.visibilityOf(answer4));
                        System.out.println("answer.getAttribute(\"value\") = " + answer4.getAttribute("value"));

                        Assert.assertTrue("Answer is wrong.", answer4.getAttribute("value").contains(sonuc8));
                        break;
                }
            }
        }
        BekleKapat();
    }
}
