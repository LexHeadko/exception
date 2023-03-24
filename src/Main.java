public class Main {
    public static void main(String[] args) {

    }

    private static boolean validateCredentials(String login, String password, String repeatPassword) {

    }

    private static void checkLogin(String login) {
        if (hasLengthMoreThan(login, 20) && isNoneAlphanumeric(login)) {
            throw new WrongLoginException("Login is wrong");
        }
    }

    private static void checkPassword(String password, String repeatPassword) {
        if (hasLengthMoreThan(password, 20) || isNoneAlphanumeric(password) || stringsNotEquals(password, repeatPassword)) {
            throw new WrongPasswordException("Password is wrong");
        }
    }

    private static boolean stringsNotEquals(String value, String value2) {
        return value.equals(value2);
    }

    private static boolean isNoneAlphanumeric(String string) {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890_";
        for (int i = 0; i < string.length(); i++) {
            if (!alphabet.contains(String.valueOf(string.charAt(i)))){
                return true;
            }
        }
        return false;
    }

    private static boolean hasLengthMoreThan(String string, int length) {
        return string.length() > length;
    }
}