package example.nio.aspects;

import example.nio.entities.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AfterAspect {

    @AfterReturning(
            pointcut = "execution(* example.nio.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        String method = joinPoint.getSignature().toString();
        System.out.println("==> Executing @AfterReturning on method:" + method);

        // print out the result of method call
        System.out.println("==> Result is: " + result);

        // post-processing some data
        convertAccountNamesToUpperCase(result);
    }

    @AfterThrowing(
            pointcut = "execution(* example.nio.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exception){

        // print method on which we are advising on
        String method = joinPoint.getSignature().toString();
        System.out.println("==> Executing @AfterThrowing on method: " + method);

        System.out.println("==> The exception is: " + exception);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        result.forEach(account -> account.setName(account.getName().toUpperCase()));
    }
}
