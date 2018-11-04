package at.htl.mydate;


//2018-11-04-HM: Sehr elegant gelöst => super!
public enum Weekday {
    MONDAY("Montag"),
    TUESDAY("Dienstag"),
    WEDNESDAY("Mittwoch"),
    THURSDAY("Donnerstag"),
    FRIDAY("Freitag"),
    SATURDAY("Samstag"),
    SUNDAY("Sonntag");

    private final String germanName;

    Weekday(String germanName) {
        this.germanName = germanName;
    }

    @Override // taken from http://tutorials.jenkov.com/java/enums.html
    public String toString() {
        return germanName;
    }
}
