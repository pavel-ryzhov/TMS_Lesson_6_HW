
/**
 * Создать класс, в котором будет статический метод.
 * (почитать и понять, чем статический метод отличается от нестатического - обсудить на занятии по необходимости)
 * Этот метод принимает на вход три параметра:
 * login
 * password
 * confirmPassword
 * Все поля имеют тип данных String.
 * Длина login должна быть меньше 20 символов и не должен содержать пробелы.
 * Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
 * Длина password должна быть меньше 20 символов, не должен содержать пробелом и должен содержать хотя бы одну цифру.
 * Также password и confirmPassword должны быть равны.
 * Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
 * WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
 * Метод возвращает true, если значения верны или false в другом случае.
 */

public class N1 {
    public static void main(String[] args) {
        System.out.println(registerUser("login", "password", "password"));
        System.out.println(registerUser("login", "password1", "password1"));
    }

    public static boolean registerUser(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (login.length() >= 20 || login.contains(" ")) throw new WrongLoginException();
    }

    private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.equals(confirmPassword) || password.length() >= 20 || password.contains(" ") || password.replaceAll("\\D", "").length() == 0)
            throw new WrongPasswordException();
    }

    private static class WrongLoginException extends Exception {
        public WrongLoginException() {
        }

        public WrongLoginException(String message) {
            super(message);
        }
    }

    private static class WrongPasswordException extends Exception {
        public WrongPasswordException() {
        }

        public WrongPasswordException(String message) {
            super(message);
        }
    }
}
