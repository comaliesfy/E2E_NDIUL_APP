package ru.stqa.ptf.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    //возвращает сегодняшнюю дату в формате день, месяц, год
    public static String factDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date dateNow = new Date();
        String date;
        date = dateFormat.format(dateNow);
        return date;
    }

    //дата -1день в формате день-месяц-год для фильтров-дат
    public static String yesterdayDate() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.DATE, -1);

        String yestDate;
        yestDate = dateFormat.format(cal.getTime());
        return yestDate;
    }

    //дат фактическая+1день в формате день-месяц-год для фильтров-дат
    public static String tomorrowDate() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.DATE, 1);
        String toDate;
        toDate = dateFormat.format(cal.getTime());
        return toDate;
    }

    //дата для записи в названиях файлов загрузки
    public static String dateForUpload() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
        Date dateNow = new Date();
        String date;
        date = dateFormat.format(dateNow);
        return date;
    }
}
