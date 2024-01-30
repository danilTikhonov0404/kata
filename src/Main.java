import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String vvod = s.nextLine();
        System.out.print("Результат выражения: " + vvod);

        char operation; //Операция (+,-,/,*)
        int num1 = 0; //Первое число
        int num2 = 0; // Вторе число
        int result = 0; //Итоговый результат
        int resultArab = 0; //Итоговый результат в арабсих числах
        String[] numbersAndOperation; // Массив строк в котром 0-ой элемент это первое число, 1-ый элемент это опрация, 2-й элемент это второе число
        numbersAndOperation = vvod.split(" "); //Разбиваем строку на элементы в массив выше
        operation =  numbersAndOperation[1].charAt(0); // получаем операцию,берем 1-ый элемент массива, в нем берем 0-ой символ
        if (numbersAndOperation.length > 3) { // проверяем на корректность выражения, не ввел ли пользователь лишние буквы, числа, символы
            System.out.println(" = ? \nЧто-то пошло не так...\nКалькулятор считает только две переменные! Попробуйте снова.");
            System.exit(0); //если ввел не корректно, то выходим из программы
        }
        try{
            num1 = romanNumeral(numbersAndOperation[0]);//Если у нас римские цифры,то они будут перведены в орабсие и присвоены соответствующим переменным;
            num2 = romanNumeral(numbersAndOperation[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" = ? \nНет символа для выполнения операции или отсутствует вторая переменная! Попробуйте снова.");
            System.exit(0); // снова на случай, если пользователь вел не верно , то выходим их программы
        }
        if (num1 == 0 | num2 == 0) {
            result = 0;
            try {
                num1 = Integer.parseInt(numbersAndOperation[0]);
                num2 = Integer.parseInt(numbersAndOperation[2]);
                if (num1 > 10 | num2 > 10 | num1 < 0 | num2 <0) {
                    System.out.println(" = ? \nКалькулятор умеет работать только с целыми арабскими или римскими цифрами от 1 до 10 одновременно! Попробуйте снова.");
                    System.exit(0);
                }
                resultArab = calculate(num1, num2, operation);
                System.out.println(" = " + resultArab);
            } catch (NumberFormatException e) {
                System.out.println("=? \nКалькулятор умеет работать только с целыми арабскими или римскими цифрами от 1 до 10 одновременно! Попробуйте снова.");
            } catch (ArithmeticException e) {
                System.out.println("=? \nНа ноль делить нельзя! Попробуйте снова.");
            }
        } else {
            try {
                result = calculate(num1, num2, operation);
                if (result == 0) {
                    System.out.println(" = ? \nРезультатом работы калькулятора с римскими числами могут быть только положительные числа! Попробуйте снова.");
                    System.exit(0);
                }
                String resultRom = romanSolution(result);
                System.out.println(" = " + resultRom + " (" + result + ")");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(" = ? \nРезультатом работы калькулятора с римскими числами могут быть только положительные числа! Попробуйте снова.");
            }
        }
    }

    public static int calculate(int x1, int x2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = x1 + x2;
                break;
            case '-':
                result = x1 - x2;
                break;
            case '*':
                result = x1 * x2;
                break;
            case '/':
                result = x1 / x2;
                break;
            default:
                break;
        }
        return result;
    }

    public static int romanNumeral(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            return 0;
        }
    }

    public static String romanSolution(int arabNumeral) {
        String[] romanAll = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "*****", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String q = romanAll[arabNumeral];
        return q;


    }
}