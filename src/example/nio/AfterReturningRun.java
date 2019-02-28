package example.nio;

import example.nio.dao.AccountDAO;
import example.nio.entities.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningRun {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class, MyLoggerConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = accountDAO.findAccounts(false);

        System.out.println("\n\nMain Program: AfterReturningAop");
        System.out.println("--------------");
        accounts.forEach(System.out::println);

        System.out.println("\n");


        List<Account> throwingAccounts = null;
        try {
            throwingAccounts = accountDAO.findAccounts(true);
        }catch (Exception e){
            System.out.println("\n\nProgram Caught Exception");
        }

        System.out.println("\n\nMain Program: AfterThrowing");
        System.out.println("--------------");

        System.out.println("\n");

        context.close();
    }
}
