package example.nio.dao;

import example.nio.entities.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts(){
        List<Account> myAccounts = new ArrayList<>();

        // create some sample accs and add them to the list

        Account temp1 = new Account("John", "Gold");
        Account temp2 = new Account("Marta", "Platinum");
        Account temp3 = new Account("Grzegorz", "Silver");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

    public void addAccount(){
        System.out.println(getClass() + ": doing some db work: add account");
    }

    public void addAccount(Account account){
        System.out.println(getClass() + ": account method with Account param");
    }

    public void addAmount(int amount){
        System.out.println(getClass() + ": adding " + amount + "$ the account");
    }

    public void checkAccount(Account account, boolean isVip){
        System.out.println(account + " is vip: " + isVip);
    }

}
