import { AppPage } from './app.po';
import { browser, by,element,logging } from 'protractor';


describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Book Keeper');
  });

  it('should display title of application', () => {
    page.navigateTo();
    expect(browser.getTitle()).toEqual('Book Keeper');
  });

  it('should be redirected to /login route',() => {
    browser.element(by.id('register-btn')).click();
    expect(browser.getCurrentUrl()).toContain('/register');
    browser.driver.sleep(1000);
  });

  it('should be able to register',() => {
    browser.element(by.name('username')).sendKeys('swara32');
    browser.element(by.name('password')).sendKeys('nav');
    browser.element(by.className('btn btn-primary')).click();
    browser.driver.sleep(1000);
    browser.switchTo().alert().accept();

  });

  it('should be able to login',() => {
    expect(browser.getCurrentUrl()).toContain('/login');
    browser.element(by.name("username")).sendKeys('swara22');
    browser.element(by.name('password')).sendKeys('nav');
    browser.element(by.className('btn btn-primary')).click();
    browser.driver.sleep(1000);
  });

  it('should be able to click on Search button',() => {
    browser.element(by.className('search')).sendKeys('java');
    browser.element(by.id('Search')).click();
    browser.driver.sleep(1000);
    expect(browser.getCurrentUrl()).toContain('/dashboard');
    browser.driver.sleep(1000);
  });

  it('should be able to  click  on  favlist',() => {
    browser.element(by.className('book')).click();
    //browser.switchTo().alert().accept();

    expect(browser.getCurrentUrl()).toContain('/bookDetail');
    browser.driver.sleep(1000);

  });



  it('should be able to click add favourite button',() => {
    browser.element(by.className('favoriteButton')).click();
    expect(browser.getCurrentUrl()).toContain('/favoriteList');
    browser.driver.sleep(1000);
  });


  it('should be able to click on Recomneded button',() => {
    browser.element(by.className('backButton')).click();
    browser.element(by.className('bookRecommendation')).click();
    expect(browser.getCurrentUrl()).toContain('/bookReclist');
    browser.driver.sleep(1000);
  });




  it('should be able to logout',() => {
    browser.driver.sleep(1000);
    browser.element(by.className('user')).click();
    expect(browser.getCurrentUrl()).toContain('/login');
    browser.driver.sleep(1000);
  });


});
