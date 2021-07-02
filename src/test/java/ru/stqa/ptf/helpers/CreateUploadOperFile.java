package ru.stqa.ptf.helpers;

import Configs.ReferencesConfig;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static Configs.ClientConfigs.*;
import static Configs.ReferencesConfig.PRATE_COUNTRY;
import static Configs.ReferencesConfig.PRATE_RATE;

public class CreateUploadOperFile {

    public static void createFileWithOperations() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Downloads/DownloadClient/Реестр операций клиентов.xlsx");
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet("Операции клиентов");
        Row row = sheet.createRow(13);
        Cell cell1 = row.createCell(1);
        Cell cell2 = row.createCell(2);
        Cell cell3 = row.createCell(3);
        Cell cell4 = row.createCell(4);
        Cell cell5 = row.createCell(5);
        Cell cell6 = row.createCell(6);
        Cell cell7 = row.createCell(8);
        Cell cell8 = row.createCell(9);
        Cell cell9 = row.createCell(10);
        Cell cell10 = row.createCell(11);
        Cell cell11 = row.createCell(12);
        Cell cell12 = row.createCell(13);
        Cell cell13 = row.createCell(14);
        Cell cell15 = row.createCell(16);
        Cell cell18 = row.createCell(19);

        cell1.setCellValue("1");
        cell2.setCellValue(CLIENT_OSB); // подразделение
        cell3.setCellValue(CLIENT_NAME); // нерезидент
        cell4.setCellValue(CLIENT_COUNTRY); // страна
        cell5.setCellValue(CLIENT_NUMBER); // номер договора
        cell6.setCellValue(CLIENT_PDdate); // дата договора
        cell7.setCellValue("14101"); //символ дохода
        cell8.setCellValue("1000"); // сумма дохода
        cell9.setCellValue(CLIENT_CURRENCY_NUM); // валюта дохода
        cell10.setCellValue("01"); //код дохода
        cell11.setCellValue(CLIENT_RATE); // ставка %
        cell12.setCellValue(OPER_INDATE); //Дата исчисления
        cell13.setCellValue(OPER_INDATE); // Дата уплаты
        cell15.setCellValue(OPER_INDATE); // Дата уплаты
        cell18.setCellValue(OPER_INDATE); // Дата перечиления налога в бюджет
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/src/test/resources/Downloads/DownloadClient/Реестр операций клиентов-" + DateHelper.dateForUpload() + ".xlsx");
        wb.write(fos);
        fis.close();
    }

    public static void createFileWithOperationsContractor() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Downloads/DownloadContractor/Operations CA_.xlsx");
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet("Операции контрагентов");
        Row row = sheet.createRow(9);
        Cell cell1 = row.createCell(0);
        Cell cell2 = row.createCell(1);
        Cell cell3 = row.createCell(2);
        Cell cell4 = row.createCell(3);
        Cell cell5 = row.createCell(4);
        Cell cell6 = row.createCell(5);
        Cell cell7 = row.createCell(6);
        Cell cell8 = row.createCell(7);
        Cell cell9 = row.createCell(8);
        Cell cell10 = row.createCell(9);
        Cell cell11 = row.createCell(10);
        Cell cell12 = row.createCell(11);
        Cell cell13 = row.createCell(12);
        Cell cell14 = row.createCell(13);
        Cell cell15 = row.createCell(14);
        Cell cell16 = row.createCell(15);
        Cell cell17 = row.createCell(16);
        Cell cell18 = row.createCell(17);
        cell1.setCellValue("1");
        cell2.setCellValue(CLIENT_OSB); // подразделение
        cell3.setCellValue(CLIENT_NAME); // нерезидент
        cell4.setCellValue(CLIENT_COUNTRY); // страна
        cell5.setCellValue(CONTRACTOR_NUMBER); // номер договора
        cell6.setCellValue(CLIENT_PDdate); // дата договора
        //"20000 12345 Доход контрагентов";
        cell7.setCellValue("12345"); //символ дохода
        cell8.setCellValue("1000"); // сумма дохода
        cell9.setCellValue(CLIENT_CURRENCY_NUM); // валюта дохода
        cell10.setCellValue(OPER_INDATE); // Дата дохода
        cell11.setCellValue("20000"); // Код дохода
        cell12.setCellValue(CONTRACTOR_Rate); //Ставка
        //cell13.setCellValue("200"); //Сумма налога в валюте
        //cell14.setCellValue("2,68"); // Курс валюты на дату получения дохода
        //cell15.setCellValue("535"); //Сумма налога
        //cell16.setCellValue("643"); //Валюта налога
        cell17.setCellValue(OPER_TAXDATE); // Дата налога
        //cell18.setCellValue("16.01.2020"); //Дата ввода
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/src/test/resources/Downloads/DownloadContractor/Operations CA_" + DateHelper.dateForUpload() + ".xlsx");
        wb.write(fos);
        fis.close();
    }

    public static void createFileWithOperationsDepo() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Downloads/DownloadDepository/DEPO_autotests_.xlsx");
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet("0");
        Row row = sheet.createRow(2);
        Cell cell1 = row.createCell(0);
        Cell cell2 = row.createCell(1);
        Cell cell3 = row.createCell(2);
        Cell cell4 = row.createCell(3);
        Cell cell5 = row.createCell(4);
        Cell cell6 = row.createCell(5);
        Cell cell7 = row.createCell(6);
        Cell cell8 = row.createCell(7);
        Cell cell9 = row.createCell(8);
        Cell cell10 = row.createCell(9);
        Cell cell11 = row.createCell(10);
        Cell cell12 = row.createCell(11);
        Cell cell13 = row.createCell(12);
        Cell cell14 = row.createCell(13);
        Cell cell15 = row.createCell(14);
        Cell cell16 = row.createCell(15);
        Cell cell17 = row.createCell(16);
        Cell cell18 = row.createCell(17);
        Cell cell19 = row.createCell(18);
        Cell cell20 = row.createCell(19);
        Cell cell21 = row.createCell(20);
        Cell cell22 = row.createCell(21);
        Cell cell23 = row.createCell(22);
        cell1.setCellValue(DEPO_DOC_NUMBER);// номер договора
        cell2.setCellValue(CLIENT_PDdate); // дата договора
        cell3.setCellValue(CLIENT_NAME); // Депонент
        cell4.setCellValue("WF"); // код страны
        cell5.setCellValue("");
        cell6.setCellValue(CLIENT_INN);// инн депо
        cell7.setCellValue("");// кпп депо
        //cell8.setCellValue("Албания, Central Albania, Тирана, Rruga Ismail Qemali, 27");
        cell9.setCellValue("3"); // признак получателя дохода
        cell10.setCellValue("05"); // код фактического права
        cell11.setCellValue("Счет депозитарных программ"); // Вид счета
        cell12.setCellValue(ReferencesConfig.IS_NAME); // Эмитент
        cell13.setCellValue(ReferencesConfig.IS_INN); // инн эмитента
        cell14.setCellValue(ReferencesConfig.IS_KPP);// кпп эмитента
        cell15.setCellValue("Акции"); // вид ценной бумаги
        cell16.setCellValue(OPER_INDATE); // Дата выплаты
        cell17.setCellValue(OPER_TAXDATE);//Дата пперечисления налога
        cell18.setCellValue("LEGAL"); //получатель дохода
        cell19.setCellValue(PRATE_COUNTRY); // Страна
        cell20.setCellValue("GB");//буквенный код
        cell21.setCellValue(PRATE_RATE);//ставка
        cell22.setCellValue("1920");//сумма дохода
        cell23.setCellValue("192");//сумма налога
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/src/test/resources/Downloads/DownloadDepository/DEPO_autotests_" + DateHelper.dateForUpload() + ".xlsx");
        wb.write(fos);
        fis.close();
    }

}
