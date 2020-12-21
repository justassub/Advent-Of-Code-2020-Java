package lt.justassub.adventofcode.year2020.day4;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;
import static java.util.Objects.isNull;

public class PassportValidator {
    private static final List<String> ALLOWED_EYE_COLOR_VALUES = asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

    public static boolean isPasswordValidNoValueCheck(Passport passport) {
        int howManyFieldsAreNotValid = 0;

        if (isNull(passport.getByr())) {
            howManyFieldsAreNotValid++;
        }
        if (isNull(passport.getIyr())) {
            howManyFieldsAreNotValid++;
        }
        if (isNull(passport.getEyr())) {
            howManyFieldsAreNotValid++;
        }
        if (isNull(passport.getHgtWithDifferentSystem())) {
            howManyFieldsAreNotValid++;
        }
        if (isNull(passport.getHcl())) {
            howManyFieldsAreNotValid++;
        }
        if (isNull(passport.getEcl())) {
            howManyFieldsAreNotValid++;
        }
        if (isNull(passport.getPid())) {
            howManyFieldsAreNotValid++;
        }
        if (isNull(passport.getCid())) {
            howManyFieldsAreNotValid++;
        }
        return (howManyFieldsAreNotValid == 0 && passport.getCid() != null) ||
                (howManyFieldsAreNotValid == 1 && passport.getCid() == null);
    }

    public static boolean isPasswordValid(Passport passport) {
        int howManyFieldsAreNotValid = 0;

        if (!commonIntegerChecker(passport.getByr(), 1920, 2002)) {
            howManyFieldsAreNotValid++;
        }
        if (!commonIntegerChecker(passport.getIyr(), 2010, 2020)) {
            howManyFieldsAreNotValid++;
        }
        if (!commonIntegerChecker(passport.getEyr(), 2020, 2030)) {
            howManyFieldsAreNotValid++;
        }
        if (!validateHeight(passport.getHgtWithDifferentSystem())) {
            howManyFieldsAreNotValid++;
        }
        if (!validateHcl(passport.getHcl())) {
            howManyFieldsAreNotValid++;
        }
        if (!validateEyeColour(passport.getEcl())) {
            howManyFieldsAreNotValid++;
        }
        if (!validatePassportId(passport.getPid())) {
            howManyFieldsAreNotValid++;
        }
        if (isNull(passport.getCid())) {
            howManyFieldsAreNotValid++;
        }
        return (howManyFieldsAreNotValid == 0 && passport.getCid() != null) ||
                (howManyFieldsAreNotValid == 1 && passport.getCid() == null);
    }

    private static boolean commonIntegerChecker(Integer value, int minValue, int maxValue) {
        if (Objects.isNull(value)) {
            return false;
        }
        return value >= minValue && value <= maxValue;
    }

    private static boolean validateHeight(String height) {
        if (Objects.isNull(height)) {
            return false;
        }
        if (height.contains("cm")) {
            String heightValue = height.replace("cm", "");
            double h = Double.parseDouble(heightValue);
            return h >= 150 && h <= 193;
        }
        if (height.contains("in")) {
            String heightValue = height.replace("in", "");
            double h = Double.parseDouble(heightValue);
            return h >= 59 && h <= 79;
        }
        return false; // height should have in or cm
    }

    private static boolean validateHcl(String hcl) {

        if (Objects.isNull(hcl)) {
            return false;
        }
        if (!hcl.startsWith("#")) {
            return false;
        }
        String hclValue = hcl.replace("#", "");
        if (hclValue.length() != 6) {
            return false;
        }
        boolean isValid = true;
        for (Character c : hclValue.toCharArray()) {
            if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f')) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private static boolean validateEyeColour(String ecl) {
        if (Objects.isNull(ecl)) {
            return false;
        }
        return ALLOWED_EYE_COLOR_VALUES.contains(ecl);
    }

    private static boolean validatePassportId(String pid) {
        if (Objects.isNull(pid)) {
            return false;
        }
        return pid.length() == 9;
    }

}
