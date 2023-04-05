package org.csystem.app.Account;

import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accounts;

    public AccountManager() {
        accounts = new TreeSet<>();
    }

    public TreeSet<Account> getAccounts() {
        return accounts;
    }

    public void showAccounts()
    {
       if(accounts.isEmpty()){
           System.out.println("Hıc Kayıt Yok");
       }else{
           for(var acc : accounts){
               acc.showUserİnfo();
           }
       }
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public Account login(String password, String email){

        try {
            for(var account : accounts){
               account.login(email,password);

               if(account.getAuthenticationStatus() == AuthenticationStatus.SUCCESS)
                   System.out.println("Giris Yapılıyor...");
                   return account;

                }
            }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
