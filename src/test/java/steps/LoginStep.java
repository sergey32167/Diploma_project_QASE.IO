package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import io.qameta.allure.Step;
import models.LoginBuilder;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProjectPage;

public class LoginStep extends BaseStep {
    public LoginStep(BrowsersService browsersService) {
        super(browsersService);
    }


    @Step("Вход в систему с данными из {loginBuilder}")
    public void loginWithBuilder(LoginBuilder loginBuilder){

        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.setEmail(loginBuilder.getUsername());
        loginPage.setPassword(loginBuilder.getPassword());
        loginPage.loginButton();

        Assert.assertTrue(new ProjectPage(browsersService, false).titleLabel.isDisplayed());

    }
}
