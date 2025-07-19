public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в программу!");

        BankAccount Paul = new BankAccount("Paul");
        BankAccount Andrew = new BankAccount("Andrew");

        System.out.println("Информация об аккаунтах\n");
        System.out.println(Paul.toString());
        System.out.println(Andrew.toString());

        if (Paul.equals(Andrew)) {
            System.out.printf("Счета %s и %s одинаковы по статусу блокировки\n", Paul.number, Andrew.number);
        } else {
            System.out.printf("Счета %s и %s различаются по статусу блокировки\n", Paul.number, Andrew.number);
        }

        if (Paul.hashCode() == Andrew.hashCode()) {
            System.out.printf("Счета %s и %s одинаковы по балансу\n", Paul.number, Andrew.number);
        } else {
            System.out.printf("Счета %s и %s различаются по балансу\n", Paul.number, Andrew.number);
        }

        System.out.printf("\nПополняем счёт %s на 50000:\n", Paul.number);

        if (Paul.deposit(50000)){
            System.out.printf("Счёт %s успешно пополнен на 50000\n", Paul.number);
        } else {
            System.out.println("Не удалось пополнить счёт: счёт заблокирован");
        }

        System.out.printf("Текущий баланс %s: %d\n", Paul.number, Paul.BalanceSheet);
        
        System.out.printf("\nПереводим 50000 со счёта %s на счёт %s:\n", Paul.number, Andrew.number);

        if (Paul.transfer(Andrew, 50000)){
            System.out.printf("Со счёта %s успешно переведено 50000 на счёт %s\n", Paul.number, Andrew.number);
        } else if (Paul.IsBlocked) {
            System.out.println("Невозвожно совершить перевод: счёт отправителя заблокирован");
        } else if (Andrew.IsBlocked){
            System.out.println("Невозвожно совершить перевод: счёт получателя заблокирован");
        } else {
            System.out.println("Не удалось совершить перевод: на счёте отправителя недостаточно средств");
        }

        System.out.printf("Текущий баланс %s: %d\n", Paul.number, Paul.BalanceSheet);
        System.out.printf("Текущий баланс %s: %d\n", Andrew.number, Andrew.BalanceSheet);

        System.out.printf("\nСнимаем 20000 со счёта %s:\n", Paul.number);

        if (Paul.withdraw(20000)){
            System.out.printf("Со счёта %s успешно списано 20000\n", Paul.number);
        } else if (Paul.IsBlocked) {
            System.out.println("Невозвожно списать средства: счёт заблокирован");
        } else {
            System.out.println("Не удалось списать средства: на счёте недостаточно средств");
        }

        System.out.printf("Текущий баланс %s: %d\n", Paul.number, Paul.BalanceSheet);

        if (Paul.hashCode() == Andrew.hashCode()) {
            System.out.printf("Счета %s и %s одинаковы по балансу\n", Paul.number, Andrew.number);
        } else {
            System.out.printf("Счета %s и %s различаются по балансу\n", Paul.number, Andrew.number);
        }
    }
}
