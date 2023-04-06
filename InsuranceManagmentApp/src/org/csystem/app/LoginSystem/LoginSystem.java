package org.csystem.app.LoginSystem;

import org.csystem.app.Account.*;
import org.csystem.app.Address.AddressManager;
import org.csystem.app.Address.BusinessAddress;
import org.csystem.app.Address.HomeAddress;
import org.csystem.app.Insurance.CarInsurance;
import org.csystem.app.Insurance.HealthInsurance;
import org.csystem.app.Insurance.ResidenceInsurance;
import org.csystem.app.Insurance.TravelInsurance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LoginSystem {
    private AccountManager accountManager;
    private Scanner sc = new Scanner(System.in);

    public LoginSystem() {
        this.accountManager = new AccountManager();
    }

    public void startMenu() {

        System.out.println("--------------------------------");
        System.out.println("Yapmak Istediginiz Islemi Seciniz");
        System.out.println("Giris Yapmak Icin: 1");
        System.out.println("Yeni Hesap Islemleri Icin: 2");
        System.out.println("Hesaplari Listelemek Icin 3");
        System.out.println("Cıkıs : 0");
        System.out.println("--------------------------------");

        var val = Integer.parseInt(sc.nextLine());

        switch (val) {
            case 0:
                System.out.println("Cıkıs Yapıldı. Iyı Gunler");
                System.exit(0);
                break;
            case 1: {
                System.out.println("Lütfen Email Adresinizi Giriniz");
                var email = sc.nextLine();
                System.out.println("Lütfen Şifrenizi Giriniz");
                var password = sc.nextLine();
                accountPanel(accountManager.login(password, email));
                break;
            }
            case 2: {
                System.out.println("Asagidaki Bilgileri Eksiksiz Giriniz");
                System.out.println("Bireysel Hesap için `I`, Şirket Hesanı Icın `E` Harfini Gırınız");
                var type = sc.nextLine();
                System.out.println("Lütfen Isim Giriniz");
                var name = sc.nextLine();
                System.out.println("Lütfen Soyısım Giriniz");
                var lastName = sc.nextLine();
                System.out.println("Lütfen Email Adresinizi Giriniz");
                var email = sc.nextLine();
                if (!email.contains("@gmail.com")) {
                    System.out.println("Dogru bir mail formatı girilmedi");
                    ;
                    startMenu();
                }
                System.out.println("Lütfen Sifre Giriniz");
                var password = sc.nextLine();
                System.out.println("Lütfen Mesleginizi Giriniz");
                var job = sc.nextLine();
                System.out.println("Lütfen Yasinizi Giriniz");
                var age = Integer.parseInt(sc.nextLine());
                addNewAccount(type, name, lastName, email, password, job, age);
                startMenu();
                break;
            }
            case 3: {
                accountManager.showAccounts();
                startMenu();
                break;
            }
            default: {
                System.out.println("Gecersiz Giris. Cıkıs Yapılıyor");
                System.exit(0);
            }
        }

    }

    public void addNewAccount(String type, String name, String lastName, String email, String password, String job, int age) {

        for (var account : accountManager.getAccounts()) {
            if (email.equals(account.getUser().getEmail())) {
                System.out.println("Daha once bu email ile sisteme kayit olunmuş. Lütfen Baska bir email Seciniz");
                startMenu();
            }
        }
        var user = new User.UserBuilder()
                .name(name)
                .lastname(lastName)
                .email(email)
                .password(password)
                .job(job)
                .age(age)
                .build();
        if (type.equalsIgnoreCase("I")) {
            Account account = new IndividualAcc(user);
            accountManager.addAccount(account);
            System.out.println("Kullanıcı Basariyla Eklendı!");
        } else if (type.equalsIgnoreCase("E")) {
            Account account = new EnterpriseAcc(user);
            accountManager.addAccount(account);
            System.out.println("Kullanıcı Basariyla Eklendı!");
        } else {
            System.out.println("Gecersiz Kullanici Tipi. Lütfen Yalnız E veya I Tuslayiniz!");
            startMenu();
        }
    }

    public void accountPanel(Account account) {
        account.getUser().setLastVisitDate(LocalDate.now());

        System.out.println("-------------------------------");
        System.out.println("Hosgeldiniz " + account.getUser().getName() + " " + account.getUser().getLastName());
        System.out.println("Yapmak Istediginiz Islemi Seciniz");
        System.out.println("Varsayılan Bilgilerinizi Gostermek Icin: 1");
        System.out.println("Yeni Address Icin: 2");
        System.out.println("Yenı Sigorta Islemleri Icın 3");
        System.out.println("Cikis : 0");
        System.out.println("--------------------------------");

        var val = Integer.parseInt(sc.nextLine());

        switch (val) {
            case 0: {
                System.out.println("Cikis Yapılıyor. Iyi günler" + account.getUser().getName() + " " + account.getUser().getLastName());
                System.exit(0);
            }
            case 1: {
                account.showUserİnfo();
                accountPanel(account);
            }
            case 2: {
                System.out.println("Asagidaki Bilgileri Eksiksiz Giriniz");
                System.out.println("Ev Adresi Icin `H`, Is Adresi Icin `C` Harfini Tuslayınız");
                var addressType = sc.nextLine();
                if (!addressType.equals("H") && !addressType.equals("C")) {
                    System.out.println("Yanlış Adres Tipi");
                    accountPanel(account);
                }
                System.out.println("Lütfen Ülke Ismi Giriniz");
                var country = sc.nextLine();
                System.out.println("Lütfen Ülke Sehir Giriniz");
                var city = sc.nextLine();
                System.out.println("Lütfen Sokak Sehir Giriniz");
                var street = sc.nextLine();
                if (addressType.equals("C")) {
                    System.out.println("Lütfen Sirketinizin Ismini Giriniz");
                    var cmpnyName = sc.nextLine();
                    var companyAdress = new BusinessAddress(country, city, street, cmpnyName);
                    AddressManager.addAddress(account.getUser(), companyAdress);
                    System.out.println("İş Adresi Basariyla Eklenmistir");
                } else {
                    System.out.println("Lütfen Sirketinizin Ismini Giriniz");
                    var homeAddress = new HomeAddress(country, city, street);
                    AddressManager.addAddress(account.getUser(), homeAddress);
                    System.out.println("Ev Adresi Basariyla Eklenmistir");
                }
                accountPanel(account);

            }
            case 3 : {
                ınsuranceOperation(account);
                break;
            }
        }
    }

    public void ınsuranceOperation(Account account)
    {
        System.out.println("----------SIGORTA ISLEMLERI---------");
        System.out.println("Yapmak Istediginiz Islemi Seciniz");
        System.out.println("Araba Sigortasi Icın: 1");
        System.out.println("Saglik Sigortası Icın: 2");
        System.out.println("Ev Sigortası Icın: 3");
        System.out.println("Seyehat Sigortası Icın: 4");
        System.out.println("Bir Ust Menüyü Donmek Icin: 5");
        System.out.println("Cıkıs : 0");
        System.out.println("--------------------------------");

        var val = Integer.parseInt(sc.nextLine());

        switch (val){
            case 0: {
                System.out.println("Cıkıs Yapılıyor. Iyi günler" + account.getUser().getName() + " " + account.getUser().getLastName());
                System.exit(0);
            }
            case 1:{
                System.out.println("Asagidaki Bilgileri Eksiksiz Giriniz");
                System.out.println("Araba Modeilini Giriniz");
                var model = sc.nextLine();
                System.out.println("Arabanın Yaşını Giriniz");
                var age = Integer.parseInt(sc.nextLine());
                System.out.println("Arabanın Hasar Kaydı Var mı. Evet Icın `Y`, Hayır Icın `N` Tuslayınız");
                var isDamegedInput = sc.nextLine();
                boolean Demeged;
                if(isDamegedInput.equals("Y")){
                    Demeged = true;
                }else{
                    Demeged = false;
                }
                System.out.println("Sigortanın Yıl Bazında Süresini Giriniz");
                var year = Integer.parseInt(sc.nextLine());
                var car = new CarInsurance(model,age,Demeged,year);
                System.out.println("Sigortanın Oluşturuldu");
                account.addInsurance(car);
                System.out.println("Sigorta Basariyla Eklendi");
                ınsuranceOperation(account);
                break;
            }
            case 2:{
                System.out.println("Asagidaki Bilgileri Eksiksiz Giriniz");
                System.out.println("Sigorta Süresini Yıl Olarak Giriniz");
                var year = Integer.parseInt(sc.nextLine());
                System.out.println("Kişinin Kronik Bir Rahatsızlığı Var mı. Evet Icın `Y`, Hayır Icın `N` Tuslayınız");
                var isChronicInput = sc.nextLine();
                boolean Chronic;
                if(isChronicInput.equals("Y")){
                    Chronic = true;
                }else{
                    Chronic = false;
                }
                System.out.println("Kişinin Yaptigi Is Tehlikeli mi. Evet Icın `Y`, Hayır Icın `N` Tuslayınız");
                var isDangerousInput = sc.nextLine();
                boolean Dangerous;
                if(isDangerousInput.equals("Y")){
                    Dangerous = true;
                }else{
                    Dangerous = false;
                }
                var health = new HealthInsurance(year,Dangerous,Chronic,account.getUser().getAge());
                System.out.println("Sigortanın Oluşturuldu");
                account.addInsurance(health);
                System.out.println("Sigorta Basariyla Eklendi");
                ınsuranceOperation(account);
                break;
            }
            case 3:{
                System.out.println("Asagidaki Bilgileri Eksiksiz Giriniz");
                System.out.println("Sigorta Süresini Yıl Olarak Giriniz");
                var year = Integer.parseInt(sc.nextLine());
                System.out.println("Binanın Yasını Giriniz");
                var age = Integer.parseInt(sc.nextLine());
                System.out.println("Bina Deprem Bölgesinde mi. Evet Icın `Y`, Hayır Icın `N` Tuslayınız");
                var isDangerousInput = sc.nextLine();
                boolean Dangerous;
                if(isDangerousInput.equals("Y")){
                    Dangerous = true;
                }else{
                    Dangerous = false;
                }
                var residence = new ResidenceInsurance(year,age,Dangerous);
                System.out.println("Sigortanın Oluşturuldu");
                account.addInsurance(residence);
                System.out.println("Sigorta Basariyla Eklendi");
                ınsuranceOperation(account);
                break;
            }
            case 4:{
                System.out.println("Asagidaki Bilgileri Eksiksiz Giriniz");
                System.out.println("Seyahat Baslama Tarhini `dd/MM/YYYY` Formatında Giriniz");
                var date = sc.nextLine();
                System.out.println("Tatilin Süresini Gün Cinsinden Giriniz");
                var days = Integer.parseInt(sc.nextLine());
                System.out.println("Seyehat Edilen Yer Tehlikeli mi. Evet Icın `Y`, Hayır Icın `N` Tuslayınız");
                var isDangerousInput = sc.nextLine();
                boolean Dangerous;
                if(isDangerousInput.equals("Y")){
                    Dangerous = true;
                }else{
                    Dangerous = false;
                }
                System.out.println("Seyehat Edilen Yer Baska Bir Kitada mi. Evet Icın `Y`, Hayır Icın `N` Tuslayınız");
                var isContinentInput = sc.nextLine();
                boolean diffContinent;
                if(isDangerousInput.equals("Y")){
                    diffContinent = true;
                }else{
                    diffContinent = false;
                }
                var travel = new TravelInsurance(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")),days,Dangerous,diffContinent);
                System.out.println("Sigortanın Oluşturuldu");
                account.addInsurance(travel);
                System.out.println("Sigorta Basariyla Eklendi");
                ınsuranceOperation(account);
                break;
            }
            case 5 : {
                accountPanel(account);
                break;
            }
        }
    }
}
