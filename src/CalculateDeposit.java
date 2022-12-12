import java.util.Scanner;

public class CalculateDeposit {
    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double newAmount;
        newAmount = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return valueDegree(newAmount, 2);
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double newAmount;
        newAmount = amount + (amount * yearRate * depositPeriod);
        return valueDegree(newAmount, 2);
    }

    double valueDegree(double value, int places) {
        double result = Math.pow(10, places);
        return Math.round(value * result) / result;
    }

    void printUserInputAndCalculate() {
        Scanner scanner = new Scanner(System.in);
        double deposit = 0;
        int period;
        int action;

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            deposit = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            deposit = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + deposit);
    }

    public static void main(String[] args) {
        CalculateDeposit calculate = new CalculateDeposit();
        calculate.printUserInputAndCalculate();
    }
}
