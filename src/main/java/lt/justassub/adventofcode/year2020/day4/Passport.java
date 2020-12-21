package lt.justassub.adventofcode.year2020.day4;

public class Passport {
    private Integer byr;//(Birth Year)
    private Integer iyr; //(Issue Year)
    private Integer eyr;// (Expiration Year)
    private String hgtWithDifferentSystem; // (Height)
    private String hcl;//(Hair Color)
    private String ecl; //(Eye Color)
    private String pid;//(Passport ID)
    private String cid; //(Country ID)

    public Passport(Integer byr, Integer iyr, Integer eyr, String hgt, String hcl, String ecl, String pid, String cid) {
        this.byr = byr;
        this.iyr = iyr;
        this.eyr = eyr;
        this.hgtWithDifferentSystem = hgt;
        this.hcl = hcl;
        this.ecl = ecl;
        this.pid = pid;
        this.cid = cid;
    }

    public Integer getByr() {
        return byr;
    }

    public Integer getIyr() {
        return iyr;
    }

    public Integer getEyr() {
        return eyr;
    }

    public String getHgtWithDifferentSystem() {
        return hgtWithDifferentSystem;
    }

    public String getHcl() {
        return hcl;
    }

    public String getEcl() {
        return ecl;
    }

    public String getPid() {
        return pid;
    }

    public String getCid() {
        return cid;
    }
}
