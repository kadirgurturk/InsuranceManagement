# InsuranceManagement

#### InsuranceManagementApp Bir sigorta  uygulamasıdır.Sigorta firmasının "Bireysel" (Individual) ve "Kurumsal" (Enterprise) olmak üzere iki tip müşteri profili bulunmaktadır.Müşteri profili için "Account" isminde soyut sınıf (abstract class) tasarlanmıştır. Account sınıfı müşterinin sisteme giriş sonrasında tüm bilgilerinin tutulduğu hesap bilgisidir. "Account" sınıfı içinde "User" tipinde bir nesne referansı bulunur. (Aggeration ilişkisi olarak)



"User" sınıfı müşterinin kişi bilgilerini ifade eder. "User" sınıfında müşterinin



- isim (String),


- soyisim (String),


- email (String),


- şifre (String),


- meslek (String),


- yaş (int),


- adres listesi (ArrayList<Address>)


- sisteme son giriş tarihi (Date)


bilgileri bulunur. Ayrıca, "User" sınıfında ArrayList tipinde adreslerinin tutulduğu bir liste vardır. Adres bilgisi iki tiptir. Ev adresi ("HomeAddress") ve İş adresi ("BusinessAddress") . Bu adres sınıfları "Address" isimli bir interface'den kalıtım alır.



+ Müşteri adreslerinin ekleyip çıkarılma sorumluluğunu üstlenmiş olan "AddressManager" isminde bir sınıf bulunmaktadır.



+ "Account" sınıfında müşteri bilgilerini ekrana yazdıran "final" tipinde, değer döndürmeyen ve ismi "showUserInfo" bir fonksiyon bulunmaktadır.



"Account" sınıfında müşterilerin yaptırdıkları sigortaları liste halinde saklanmaktadır. Sigortayı temsil eden "Insurance" isminde bir soyut sınıf tasarlayınmıştır. Bu soyut sınıf içinde



+ sigortanın ismi (String),


+ sigortanın ücreti (double)


+ sigortanın başlangıç-bitiş tarihi (Date)


gibi değişkenlere sahiptir. Ayrıca "calculate" isminde soyut bir fonksiyon bulunmaktadır. Bu soyut fonksiyon aşağıda kalıtım alınan sınıflarda tamamıyla kendi kendime tahmin ettiğim şeklide(Sigorta fiyatlarını ve bunların nasıl fiyatlandırılacağına dair en ufak bi fikrim yok) yapılmıştır.



Bu soyut sınıftan türeyen



"HealthInsurance" (özel sağlık sigortasu),


"ResidenceInsurance" (konut sigortası),


"TravelInsurance" (seyahat sigortası),


"CarInsurance" (otomobil sigortası)


4 tane alt sınıf yazılmıştır. Her alt sınıf "calculate" isimli soyut fonksiyonu override ederek, sigorta ücretini kendine göre hesaplanmıştır.
