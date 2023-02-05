package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport reportText = new TextReport();
        HtmlReport reportHtml = new HtmlReport();
        JSONReport reportJSON = new JSONReport();
        String textText = reportText.generate("Report's name", "Report's body");
        String textHtml = reportHtml.generate("Report's name", "Report's body");
        String textJSON = reportJSON.generate("Report's name", "Report's body");
        System.out.println(textText);
        System.out.println(textHtml);
        System.out.println(textJSON);
    }
}