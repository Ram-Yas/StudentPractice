package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class N11Page {

    public N11Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Mağazaları Gör']")
    public WebElement magazalariGorButonu;

    @FindBy(xpath = "//h3[text()='Tüm Mağazalar']")
    public WebElement tumMagazalarButonu;

    @FindBy(id = "myLocation-close-info")
    public WebElement cookiesButonu;

    @FindBy(xpath = "(//button[@class='dn-slide-deny-btn'])[1]")
    public WebElement dahaSonraYazisi;

    @FindBy(xpath = "//span[@title='Mağazalar']")
    public WebElement magazalarYazisi;

    @FindBy(xpath = "(//span[@class='closeBtn'])[1]")
    public WebElement cookiesClose;

    @FindBy(id = "myLocation-close-info")
    public WebElement closeLocation;

    @FindBy(xpath = "(//ul)[24]")
    public WebElement aMagazalar;

    @FindBy(id = "searchData")
    public WebElement aramaCubugu;

    @FindBy(xpath = "//select[@id='sortingType']")
    public WebElement akilliSiralamaDDM;

    @FindBy(id = "freeShipmentOption")
    public WebElement ucretsizKargo;

    @FindBy(xpath = "(//h3[@class='productName'])[1]")
    public WebElement sayfadakiIlkUrun;

    @FindBy(xpath = "(//h3[@class='productName'])[28]")
    public WebElement sayfadakiSonUrun;

    @FindBy (xpath ="//h3[@class='productName']" )
    public List<WebElement> ilkSayfadakiUrunlerListesi;

    @FindBy(xpath = "//button[@title='Sepete Ekle']")
    public WebElement sepeteEkleButonu;

    @FindBy (xpath = "//i[@class='icon iconBasket']")
    public WebElement sepeteGitButonu;

    @FindBy (xpath = "//div[@class='priceArea']")
    public List<WebElement> sepettekiUrunlerinFiyatlari;
    @FindBy (xpath = "//span[@class='btn btnBlack']")
    public WebElement blackButton;
    @FindBy (xpath = "(//span[@class='spinnerUp spinnerArrow'])[1]")
    public WebElement birinciUrunArttir;
    @FindBy (xpath = "(//span[@class='spinnerUp spinnerArrow'])[2]")
    public WebElement ikinciUrunuArttir;
    @FindBy (id = "js-buyBtn")
    public WebElement satinAlButonu;
    @FindBy (xpath = "//a[@title='Üye Olmadan Devam Et']")
    public WebElement misafirKullanciOlarakDevamEt;
    @FindBy (xpath = "(//div[@class='spinnerField ']//input)[2]")
    public WebElement artistanSonrakiIkinciUrunAdet;
    @FindBy (xpath = "(//div[@class='spinnerField ']//input)[1]")
    public WebElement artistanSonrakiIlkUrunAdet;


}
