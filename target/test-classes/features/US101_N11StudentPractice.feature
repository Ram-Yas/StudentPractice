Feature: US101 N11 Sitesinde magazalar ve sepet testi

 #Scenario: TC01 N11 magazalar listesinin txt dosyasina yazilmasi

 #  Given kullanici n11Url anasayfasinda
 #  And kullanci closeLocation'i tiklar
 #  And kullanici header'daki magazalari goru tiklar
 #  Then kullanici tum magazalar butonuna tiklar
 #  And a harfindeki magazalari txt doyasina yazdirir

  @n11
  Scenario: TC002 N11 alisveris sitesinde sepete urun eklemek ve sepette degisiklik yapmak
    Given kullanici n11Url anasayfasinda
    And kullanci closeLocation'i tiklar
    And kullanici arama motorunda kulaklik kelimesi aratir
    Then kullanici sonuclari yorum sayisina gore siralar
    And kullanici siralanan urunlerden ucretsiz kargo olanlar listeleler
    And kullanici listelenen sonuclardan ilk sayfadaki birinci ve sonuncu urun spete ekler
    Then kullanici sepete gider
    And kullanici sepetteki urunlerden ucuz olanin adedini iki yapar
    And kullanici misafir kullanici olarak odeme adimina ilerler