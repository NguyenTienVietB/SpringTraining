package org.example;
import org.example.model.Account;
import org.example.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService accountService = context.getBean(AccountService.class);

        // Thực hiện giao dịch
        try {
            accountService.deposit("12345", 1000);
            accountService.withdraw("12345", 500);
        } catch (Exception e) {
            System.err.println("Transaction failed: " + e.getMessage());
        }

        // In thông tin tài khoản
        System.out.println("Account balance after transaction: " + accountService.getAccountBalance("12345"));

    }
}
