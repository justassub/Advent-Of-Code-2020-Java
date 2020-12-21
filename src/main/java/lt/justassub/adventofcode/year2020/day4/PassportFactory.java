package lt.justassub.adventofcode.year2020.day4;

import java.util.Map;

public class PassportFactory {
    public static Passport createPassport(Map<String, String> fields) {
        String byr = fields.get("byr");//(Birth Year)
        String iyr = fields.get("iyr"); //(Issue Year)
        String eyr = fields.get("eyr");// (Expiration Year)
        String hgt = fields.get("hgt"); // (Height)
        String hcl = fields.get("hcl");//(Hair Color)
        String ecl = fields.get("ecl"); //(Eye Color)
        String pid = fields.get("pid");//(Passport ID)
        String cid = fields.get("cid");//(Country ID)

        Integer byrValue = byr == null ? null : Integer.parseInt(byr);
        Integer iyrValue = iyr == null ? null : Integer.parseInt(iyr);
        Integer eyrValue = eyr == null ? null : Integer.parseInt(eyr);
        return new Passport(
                byrValue, iyrValue, eyrValue, hgt, hcl, ecl, pid, cid
        );
    }
}
