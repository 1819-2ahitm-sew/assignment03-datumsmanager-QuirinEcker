package at.htl.mydate;

/**
 * Informationen zu Enums: http://tutorials.jenkov.com/java/enums.html
 *               zu split: https://stackoverflow.com/a/3481842/9818338
 *   zur Ermittlung des Wochentages: https://de.wikipedia.org/wiki/Wochentagsberechnung#Programmierung
 */
public class MyDate {

    private int day;
    private int month;
    private int year;
    private String helpDate;
    private String monthString;

    public MyDate(int year, int month, int day) {
        initializeFields(year, month, day);
    }

    private void initializeFields(int year, int month, int day) {
        if (isvalid(year, month, day)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    private boolean isvalid(int year, int month, int day) {
        return 1 <= year && year <= 3000 &&
                1 <= month && month <= 12 &&
                1 <= day && day <= 31;
    }

    public MyDate(String date) {
        if (date.equals("quit")) {
            this.helpDate = date;
        } else {
            this.helpDate = date;
            String[] dateComponents = date.split("\\.");
            int day = Integer.parseInt(dateComponents[0]);
            int month = Integer.parseInt(dateComponents[1]);
            int year = Integer.parseInt(dateComponents[2]);

            initializeFields(year, month, day);
        }
    }

    //region Getter und Setter
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getDate() {
        return this.helpDate;
    }
    //endregion

    public Weekday getWeekday() {
        if (isvalid(year, month, day)) {
            int calculatedYear = adjustYearToFormula();
            int weekday = ((day + (int)(2.6 * ((month + 9) % 12 + 1) - 0.2)
                    + calculatedYear % 100 + (int)(calculatedYear % 100 / 4) + (int)(calculatedYear / 400)
                    - 2 * (int)(calculatedYear / 100) - 1) % 7 + 7) % 7 + 1;
            return Weekday.values()[weekday-1];
        } else {
            return null;
        }
    }

    private int adjustYearToFormula() {
        int calculatedYear = year;
        if (month < 3) {
           calculatedYear--;
        }
        return calculatedYear;
    }

    /**
     * Formatierung des Datums
     *
     * @return String, zB Samstag, 29. September 2018
     */
    public String formatDate() {

        return getWeekday().toString() + ", " + this.getDay() + ". " + getMonthString() + " " + this.getYear();
    }

    /**
     *  Überprüfen, ob ein übergebenes Datum (other) jünger oder älter ist
     *
     * @param other
     * @return true, wenn this-Datum jünger als other-Datum ist
     *         false, wenn this-Datum jünger oder gleich other-Datum ist
     */
    public boolean isYoungerThan(MyDate other) {
        boolean isYounger = false;

        isYounger = checkYear(other, isYounger);

        return isYounger;
    }

    private boolean checkYear(MyDate other, boolean isYounger) {
        if (this.getYear() > other.getYear()) {
            isYounger = true;
        } else if (this.getYear() == other.getYear()) {
            isYounger = checkMonth(other, isYounger);
        } else {
            isYounger = false;
        }
        return isYounger;
    }

    private boolean checkMonth(MyDate other, boolean isYounger) {
        if (this.getMonth() > other.getMonth()) {
            isYounger = true;
        } else if (this.getMonth() == other.getMonth()) {
            isYounger = checkDay(other, isYounger);
        } else {
            isYounger = false;
        }
        return isYounger;
    }

    private boolean checkDay(MyDate other, boolean isYounger) {
        if (this.getDay() > other.getDay()) {
            isYounger = true;
        } else {
            isYounger = false;
        }

        return isYounger;
    }

    public String getMonthString() {
        if (this.getMonth() == 1) return "Jänner";
        else if (this.getMonth() ==  2) return "February";
        else if (this.getMonth() ==  3) return "März";
        else if (this.getMonth() ==  4) return "April";
        else if (this.getMonth() ==  5) return "Mai";
        else if (this.getMonth() ==  6) return "Juni";
        else if (this.getMonth() ==  7) return "Juli";
        else if (this.getMonth() ==  8) return "August";
        else if (this.getMonth() ==  9) return "September";
        else if (this.getMonth() == 10) return "Oktober";
        else if (this.getMonth() == 11) return "November";
        else if (this.getMonth() == 12) return "Dezember";
        return null;
    }
}
