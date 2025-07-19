import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class BankAccount{

    BankAccount(String OwnerName){
        this.OwnerName = OwnerName;
        BalanceSheet = 100000;
        OpenDate = LocalDateTime.now();
        IsBlocked = false;
        number = generateNumber();
    }

    String OwnerName;

    int BalanceSheet;

    LocalDateTime OpenDate;

    boolean IsBlocked;

    String number;

    //Информация о счёте
    @Override
    public String toString(){
        return String.format("""
                Номер счёта: %s
                Имя владельца: %s
                Баланс: %d
                Дата открытия: %tD
                Заблокирован: %b
                """, number, OwnerName, BalanceSheet, OpenDate, IsBlocked);
    }

    //Сравнение счетов по их блокировке
    @Override
    public boolean equals(Object obj){

        if (!(obj instanceof BankAccount)) return false;

        BankAccount b = (BankAccount) obj;
        String status1 = Boolean.toString(this.IsBlocked);
        String status2 = Boolean.toString(b.IsBlocked);

        return status1.equals(status2);
    }

    //Сравнение счетов по балансам
    @Override
    public int hashCode() {
        return Objects.hash(BalanceSheet);
    }

    boolean deposit(int amount){
        if (!IsBlocked) {
            this.BalanceSheet += amount;
            return true;
        }
        else {
            return false;
        }
    }

    boolean withdraw(int amount){
        if (!IsBlocked && amount <= this.BalanceSheet) {
            this.BalanceSheet -= amount;
            return true;
        }
        else {
            return false;
        }

    }

    boolean transfer(BankAccount otherAccount, int amount){
        if (!IsBlocked && !otherAccount.IsBlocked && amount <= this.BalanceSheet) {
            this.BalanceSheet -= amount;
            otherAccount.BalanceSheet += amount;
            return true;
        }
        else {
            return false;
        }
    }

    //Генерация номера счёта
    String generateNumber(){
        StringBuilder randomNumber = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++){
            int X = random.nextInt(10);
            randomNumber.append(X);
        }
        return randomNumber.toString();
    }


}
