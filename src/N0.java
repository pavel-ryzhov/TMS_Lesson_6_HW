import java.util.Scanner;

/**
 * Доработать нулевое домашнее задание предыдущего урока.
 * Теперь надо создать свои классы исключений на каждую ситуацию:
 * - Проверить содержит ли номер документа последовательность abc.
 * - Проверить начинается ли номер документа с последовательности 555.
 * - Проверить заканчивается ли номер документа на последовательность 1a2b.
 *
 * Если номер документа не удовлетворяет условию - то "бросить" исключение.
 * В методе класса, в котором будут вызываться эти методы для демонстрации работы,
 * перехватить исключение конструкцией try-catch и в блоке catch вывести сообщение для пользователя(сообщение на консоль).
 */
public class N0 {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        if (!str.matches("(\\d{4}-[a-zA-Z]{3}-){2}(\\d[a-zA-Z]){2}")){
            System.out.println("Wrong document number");
            return;
        }

        try{
            numberContainsABC(str);
            numberStartsWith555(str);
            numberEndsWith1A2B(str);
            System.out.println("Everything is good");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static void numberContainsABC(String number) throws NumberDoesNotContainABCException{
        if (!number.toUpperCase().contains("ABC")) throw new NumberDoesNotContainABCException("Number must contain abc");
    }
    private static void numberStartsWith555(String number) throws NumberDoesNotStartWith555Exception{
        if (!number.startsWith("555")) throw new NumberDoesNotStartWith555Exception("Number must start with 555");
    }
    private static void numberEndsWith1A2B(String number) throws NumberDoesNotEndWith1A2BException{
        if (!number.toUpperCase().endsWith("1A2B")) throw new NumberDoesNotEndWith1A2BException("Number must end with 1a2b");
    }


    private static class NumberDoesNotContainABCException extends Exception{
        public NumberDoesNotContainABCException(String message){
            super(message);
        }
    }
    private static class NumberDoesNotStartWith555Exception extends Exception{
        public NumberDoesNotStartWith555Exception(String message){
            super(message);
        }
    }
    private static class NumberDoesNotEndWith1A2BException extends Exception{
        public NumberDoesNotEndWith1A2BException(String message){
            super(message);
        }
    }
}
