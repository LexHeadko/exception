public class Main {
    public static void main(String[] args) {
        validateCredentials("Elvis", "pass", "pass");
        validateCredentials("Lo/gin", "Pass", "Pass");
        validateCredentials("jfldsafkjsadlfksdfjlsafjfskjadlfjlsdfsdlkf", "pass", "pass");
        validateCredentials("Elvis", "Elv1s", "Elvis");
        validateCredentials("Login", "pppppaaaaassssssssssss", "pppppaaaaassssssssssss");
    }

    private static boolean validateCredentials(String login, String password, String repeatPassword) {
        try {
            checkLogin(login);
            checkPassword(password, repeatPassword);
            return true;
        } catch (WrongLoginException e) {
            System.out.println("Invalid login: " + e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Invalid password: " + e.getMessage());
            return false;
        }
    }

    private static void checkLogin(String login) {
        if (hasLengthMoreThan(login, 20) || isNoneAlphanumeric(login)) {
            throw new WrongLoginException("Login is wrong!");
        }
    }

    private static void checkPassword(String password, String repeatPassword) {
        if (hasLengthMoreThan(password, 20) || isNoneAlphanumeric(password) || stringsNotEquals(password, repeatPassword)) {
            throw new WrongPasswordException("Password is wrong!");
        }
    }

    private static boolean stringsNotEquals(String value, String value2) {
        return !value.equals(value2);
    }

    private static boolean isNoneAlphanumeric(String string) {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890_";
        for (int i = 0; i < string.length(); i++) {
            if (!alphabet.contains(String.valueOf(string.charAt(i)).toLowerCase())){
                return true;
            }
        }
        return false;
    }

    private static boolean hasLengthMoreThan(String string, int length) {
        return string.length() > length;
    }
}