package com.api.repository;

import com.api.model.AccountInfoModel;
import com.api.model.ClientInfoModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestRepo {
    public static void main(String[] args) {
        ModelRepository modelRepository = ModelRepository.getInstance();
        String xPathName = "//div[@class='card account-card']//h6[1]";
        String xPathType = "//div[@class='card account-card']//span";
        String xPathBalance = "//div[@class='card account-card']//h6[2]";
        String xPathCurrency = "//div[@class='card account-card']//span[@class='text-muted']";
        String xPathId = "//div[@class='card account-card']//pre[@title='<routing>--<account>']";
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://bootcamp.rebank.anyg.io/");
        WebElement webLogin = webDriver.findElement(By.xpath("//input[@id='id_username']"));
        WebElement webPass = webDriver.findElement(By.xpath("//input[@id='id_password']"));
        WebElement webLogInBtn = webDriver.findElement(By.xpath("//input[@id='submit-id-login']"));
        webLogin.sendKeys("user");
        webPass.sendKeys("user01");
        webLogInBtn.click();

        WebElement accountOverviewLink = webDriver.findElement(By.xpath("//a[@href='/account/overview/']"));
        accountOverviewLink.click();
        List<WebElement> name = webDriver.findElements(By.xpath("//div[@class='card-body']"));
        //System.out.println("name.getText() = " + name);

//        List<WebElement> listAccNames = webDriver.findElements(By.xpath(xPathName));
//        List<WebElement> listAccBalance = webDriver.findElements(By.xpath(xPathBalance));
//        List<WebElement> listAccCurrency = webDriver.findElements(By.xpath(xPathCurrency));
//        List<WebElement> listAccId = webDriver.findElements(By.xpath(xPathId));
//        List<WebElement> listAccType = webDriver.findElements(By.xpath(xPathType));
        List<WebElement> listCardBody = webDriver.findElements(By.xpath("//div[@class='card-body']"));
//        listAccNames.stream().map(WebElement::getText).forEach(System.out::println);
//        listAccBalance.stream().map(e -> e.getText().split(" ")[0]).forEach(System.out::println);
//        listAccCurrency.stream().map(WebElement::getText).forEach(System.out::println);
        System.out.println("listCardBody.size() = " + listCardBody.size());
        List<AccountInfoModel> listAccountInfoModel = listCardBody.stream().
                map(e -> createAccountInfoModel(e)).
                filter(e -> e.getCurrency() != null &&
                        Double.parseDouble(e.getBalance()) > 0).
                collect(Collectors.toList());

        listAccountInfoModel.stream().forEach(System.out::println);

        WebElement accountInformationLink = webDriver.findElement(By.xpath("//a[@href='/user/information/']"));
        accountInformationLink.click();

        List<WebElement> listCardAcc = webDriver.findElements(By.xpath("//div[@class='card account-card']"));
        List<String> listArrStr = listCardAcc.stream().map(e -> e.getText().split("\n")).
                flatMap(e -> Arrays.stream(e)).collect(Collectors.toList());

        listArrStr.stream().forEach(System.out::println);
        System.out.println("listArrStr.size() = " + listArrStr.size());

    }

    public static AccountInfoModel createAccountInfoModel(WebElement webElement) {
        AccountInfoModel accountInfoModel = new AccountInfoModel();
        String[] str = webElement.getText().split("\n");
        accountInfoModel.setId(str[3]);
        accountInfoModel.setAccountName(str[0]);
        accountInfoModel.setAccountType(str[2]);
        if (str[1].contains(" ")) {
            accountInfoModel.setBalance(str[1].split(" ")[0]);
            accountInfoModel.setCurrency(str[1].split(" ")[1]);
        } else {
            accountInfoModel.setBalance(str[1]);
            accountInfoModel.setCurrency(null);
        }

        return accountInfoModel;
    }

    public static ClientInfoModel createClientInfoModel(WebElement webElement){
        ClientInfoModel clientInfoModel = new ClientInfoModel();
        String[] str = webElement.getText().split("\n");
        clientInfoModel.setIndex(str[1]);
        clientInfoModel.setCity(str[2].split(" ")[0]);
        clientInfoModel.setState(str[2].split(" ")[1].substring(0, str[1].length()-1));
        return null;
    }
}
