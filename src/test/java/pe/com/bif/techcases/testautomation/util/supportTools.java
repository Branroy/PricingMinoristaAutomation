package pe.com.bif.techcases.testautomation.util;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class supportTools {

    public static void captureEvidence(XWPFRun run, FileOutputStream out, String dirPath) throws Exception {

        String screenshot_name = System.currentTimeMillis() + ".png";
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        File file = new File(dirPath + screenshot_name);
        ImageIO.write(image, "png", file);
        InputStream pic = new FileInputStream(dirPath + screenshot_name);
        run.addBreak();
        run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, screenshot_name, Units.toEMU(450), Units.toEMU(290));
        pic.close();
        file.delete();
    }

    public static XWPFStyle createTableStyle(XWPFStyles styles, String styleId) throws Exception {
        if (styles == null || styleId == null) return null;
        String tableStyleXML =
                "<w:style xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" w:styleId=\"" + styleId + "\" w:type=\"table\">"
                        + "<w:name w:val=\"" + styleId + "\"/>"
                        + "<w:pPr><w:spacing w:lineRule=\"auto\" w:line=\"240\" w:after=\"0\"/></w:pPr>"
                        + "<w:tblPr>"
                        + "<w:tblStyleRowBandSize w:val=\"1\"/><w:tblStyleColBandSize w:val=\"1\"/>"
                        + "<w:tblBorders>"
                        + "<w:top w:val=\"single\" w:themeTint=\"99\" w:themeColor=\"text1\" w:color=\"666666\" w:space=\"0\" w:sz=\"4\"/>"
                        + "<w:bottom w:val=\"single\" w:themeTint=\"99\" w:themeColor=\"text1\" w:color=\"666666\" w:space=\"0\" w:sz=\"4\"/>"
                        + "<w:insideH w:val=\"single\" w:themeTint=\"99\" w:themeColor=\"text1\" w:color=\"666666\" w:space=\"0\" w:sz=\"4\"/>"
                        + "</w:tblBorders>"
                        + "</w:tblPr>"
                        + "<w:tblStylePr w:type=\"firstRow\"><w:rPr><w:b/><w:bCs/></w:rPr></w:tblStylePr>"
                        + "<w:tblStylePr w:type=\"lastRow\"><w:rPr><w:b/><w:bCs/></w:rPr></w:tblStylePr>"
                        + "<w:tblStylePr w:type=\"firstCol\"><w:rPr><w:b/><w:bCs/></w:rPr></w:tblStylePr>"
                        + "<w:tblStylePr w:type=\"lastCol\"><w:rPr><w:b/><w:bCs/></w:rPr></w:tblStylePr>"
                        + "<w:tblStylePr w:type=\"band1Vert\"><w:tblPr/><w:tcPr><w:shd w:val=\"clear\" w:color=\"auto\" w:themeFillTint=\"33\" w:themeFill=\"text1\" w:fill=\"D9E2F3\"/></w:tcPr></w:tblStylePr>"
                        + "<w:tblStylePr w:type=\"band1Horz\"><w:tblPr/><w:tcPr><w:shd w:val=\"clear\" w:color=\"auto\" w:themeFillTint=\"33\" w:themeFill=\"text1\" w:fill=\"D9E2F3\"/></w:tcPr></w:tblStylePr>"
                        + "</w:style>";

        CTStyles ctStyles = CTStyles.Factory.parse(tableStyleXML);
        CTStyle ctStyle = ctStyles.getStyleArray(0);

        XWPFStyle style = styles.getStyle(styleId);
        if (style == null) {
            style = new XWPFStyle(ctStyle, styles);
            styles.addStyle(style);
        } else {
            style.setStyle(ctStyle);
        }

        return style;
    }

    public static String datetime() {
        DateFormat dateFormat = new SimpleDateFormat("EEEEEEEEE, MMM d, yyyy '@' HH:mm:ss");

        String date = dateFormat.format(Calendar.getInstance().getTime());

        return date;
    }
}
