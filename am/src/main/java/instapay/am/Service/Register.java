package instapay.am.Service;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import instapay.am.Model.User;

public abstract class Register {
    public abstract Object register(User user);
    public boolean isStrongPassword(String password) {
        // Password must be at least 8 characters long and contain at least one uppercase letter, 
        // one lowercase letter, one digit, and one special character.
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public boolean isEGYPhoneNum(String phoneNum) {
        // Phone number must be 11 digits and start with 01.
        String regex = "^(01)[0125]\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }
}