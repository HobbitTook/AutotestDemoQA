package com.demoqa;


import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckingTheArchive {
    ClassLoader classLoader = CheckingTheArchive.class.getClassLoader();


    @Test
    void zipXLSReaderTest() throws Exception {
        InputStream is = classLoader.getResourceAsStream("Archive.zip");
        ZipInputStream zip = new ZipInputStream(is);
        ZipFile zfile = new ZipFile(new File("src/test/resources/" + "Archive.zip"));
        ZipEntry entry;
        while ((entry = zip.getNextEntry()) != null) {
            if (entry.getName().contains("prajs_ot_1808.xls")) {
                try (InputStream stream = zfile.getInputStream(entry)) {
                    XLS xls = new XLS(stream);
                    assertThat(
                            xls.excel.getSheetAt(0)
                                    .getRow(18)
                                    .getCell(2)
                                    .getStringCellValue()
                    ).contains("Ценовая группа/ Номенклатура/ Характеристика номенклатуры");
                }
            }
        }

        }


    @Test
    void zipPdfReader() throws Exception {
        InputStream is = classLoader.getResourceAsStream("Archive.zip");
        ZipInputStream zip = new ZipInputStream(is);
        ZipEntry entry;
        ZipFile zfile = new ZipFile(new File("src/test/resources/" + "Archive.zip"));
        while ((entry = zip.getNextEntry()) != null) {
            if (entry.getName().contains("junit-user-guide-5.9.0.pdf")) {
                try (InputStream stream = zfile.getInputStream(entry)) {
                    PDF pdf = new PDF(stream);
                    assertThat(pdf.text).contains("To find out what artifacts are available for download");

                }
            }
        }
        }


    @Test
    void zipCsvReader() throws Exception {
        InputStream is = classLoader.getResourceAsStream("Archive.zip");
        ZipInputStream zip = new ZipInputStream(is);
        ZipEntry entry;
        ZipFile zfile = new ZipFile(new File("src/test/resources/" + "Archive.zip"));
        while ((entry = zip.getNextEntry()) != null) {
            if (entry.getName().contains("test.csv")) {
                try (InputStream stream = zfile.getInputStream(entry)){
                    CSVReader csvReader = new CSVReader(new InputStreamReader(stream, UTF_8));
                    List<String[]> csv = csvReader.readAll();
                    assertThat(csv).contains(
                            new String[]{"Философский камень", "1"},
                            new String[]{"Тайная комната", "2"},
                            new String[]{"Узник Азкабана", "3"}
                    );
                }
            }
        }
    }
}

