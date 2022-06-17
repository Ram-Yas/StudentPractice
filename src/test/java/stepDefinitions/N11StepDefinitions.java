package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.N11Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class N11StepDefinitions {

    N11Page n11Page = new N11Page();
    Actions actions = new Actions(Driver.getDriver());


    @Given("kullanici n11Url anasayfasinda")
    public void kullanici_n11url_anasayfasinda() {
        Driver.getDriver().get(ConfigReader.getProperty("n11Url"));
    }

    @Given("kullanci closeLocation'i tiklar")
    public void kullanci_close_location_i_tiklar() {
        n11Page.closeLocation.click();
    }

    @Given("kullanici header'daki magazalari goru tiklar")
    public void kullanici_header_daki_magazalari_goru_tiklar() {
        actions.moveToElement(n11Page.magazalarYazisi).perform();
        n11Page.magazalariGorButonu.click();
    }

    @Then("kullanici tum magazalar butonuna tiklar")
    public void kullanici_tum_magazalar_butonuna_tiklar() {
        n11Page.tumMagazalarButonu.click();
    }

    @Then("a harfindeki magazalari txt doyasina yazdirir")
    public void a_harfindeki_magazalari_txt_doyasina_yazdirir() throws IOException {
        String aMagazalarListesi = n11Page.aMagazalar.getText();
        File file = new File("src/resources/magazalar.txt"); // magazalar isminde txt olsturuyor
        FileUtils.writeStringToFile(file, aMagazalarListesi, Charset.defaultCharset());
    }

    @Given("kullanici arama motorunda kulaklik kelimesi aratir")
    public void kullanici_arama_motorunda_kulaklik_kelimesi_aratir() {
        String aranacakKelime = ConfigReader.getProperty("aranacakKelime");
        n11Page.aramaCubugu.sendKeys(aranacakKelime + Keys.ENTER);
    }

    @Then("kullanici sonuclari yorum sayisina gore siralar")
    public void kullanici_sonuclari_yorum_sayisina_gore_siralar() {
        Select select = new Select(n11Page.akilliSiralamaDDM);
        select.selectByVisibleText("Yorum sayısı");
    }

    @Then("kullanici siralanan urunlerden ucretsiz kargo olanlar listeleler")
    public void kullanici_siralanan_urunlerden_ucretsiz_kargo_olanlar_listeleler() {
        n11Page.ucretsizKargo.click();
    }

    @Then("kullanici listelenen sonuclardan ilk sayfadaki birinci ve sonuncu urun spete ekler")
    public void kullanici_listelenen_sonuclardan_ilk_sayfadaki_birinci_ve_sonuncu_urun_spete_ekler() {
        WebElement ilkUrun = n11Page.ilkSayfadakiUrunlerListesi.get(0);
        ilkUrun.click();
        n11Page.sepeteEkleButonu.click();
        Driver.getDriver().navigate().back();
        WebElement sonUrun = n11Page.ilkSayfadakiUrunlerListesi.get(n11Page.ilkSayfadakiUrunlerListesi.size() - 1);
        sonUrun.click();
        n11Page.sepeteEkleButonu.click();
    }

    @Then("kullanici sepete gider")
    public void kullanici_sepete_gider() {
        n11Page.sepeteGitButonu.click();
        n11Page.blackButton.click();
    }

    @Then("kullanici sepetteki urunlerden ucuz olanin adedini iki yapar")
    public void kullanici_sepetteki_urunlerden_ucuz_olanin_adedini_iki_yapar() throws ParseException, InterruptedException {
        String urun1Value = n11Page.urun1.getAttribute("value");
        String urun2Value = n11Page.urun2.getAttribute("value");
        DecimalFormat df = new DecimalFormat();
        DecimalFormatSymbols sfs = new DecimalFormatSymbols();
        sfs.setDecimalSeparator(',');
        df.setDecimalFormatSymbols(sfs);
        double d1 = df.parse(urun1Value).doubleValue();
        double d2 = df.parse(urun2Value).doubleValue();
        Thread.sleep(5000);
        if (d1 < d2) {
            n11Page.birinciUrunArttir.click();
        } else {
            n11Page.ikinciUrunuArttir.click();
        }
        String urun2Adet = n11Page.artistanSonrakiIkinciUrunAdet.getAttribute("value");
        String urun1Adet = n11Page.artistanSonrakiIlkUrunAdet.getAttribute("value");

        Assert.assertNotEquals(urun1Adet, urun2Adet);
    }

    @Then("kullanici misafir kullanici olarak odeme adimina ilerler")
    public void kullanici_misafir_kullanici_olarak_odeme_adimina_ilerler() {
        n11Page.satinAlButonu.click();
        n11Page.misafirKullanciOlarakDevamEt.click();
    }
}
