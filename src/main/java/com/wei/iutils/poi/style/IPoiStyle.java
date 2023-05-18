package com.wei.iutils.poi.style;

import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

/**
 * wwwwma
 *
 * 提供一些常用的poi格式
 */
public class IPoiStyle {

    public static final double defauleFontSize = 12D;

    public static final String defauleColor = "000000";

    public static final boolean defaultBold = false;

    public static final String defultfontFamily = "simsun";

    public static final String defultWesternFontFamily = "Times New Roman";

    public static ParagraphStyle getDefaultParaStyle(){
        return getDefaultParaStyle(defauleFontSize, defauleColor, defaultBold);
    }

    public static ParagraphStyle getDefaultParaStyle(double fontSize, String color,boolean bold) {
        return  ParagraphStyle.builder().withAlign(ParagraphAlignment.LEFT).withAllowWordBreak(true).withDefaultTextStyle(getDefaultStyle(fontSize,color,bold)).withIndentFirstLineChars(2).build();
    }

    public static Style getDefaultStyle() {
        return getDefaultStyle(defauleFontSize, defauleColor, defaultBold);
    }

    public static Style getDefaultStyle(double fontSize, String color,boolean bold) {
        Style.StyleBuilder styleBuilder = Style.builder().buildFontSize(fontSize).buildColor(color).buildFontFamily(defultfontFamily).buildWesternFontFamily(defultWesternFontFamily);
        if (bold) styleBuilder.buildBold();
        return styleBuilder.build();
    }

    /**
     * 勾选框
     * @param fontSize
     * @param color
     * @return
     */
    public static Style getCheckBox(double fontSize, String color) {
        Style.StyleBuilder styleBuilder = Style.builder().buildFontSize(fontSize).buildColor(color).buildFontFamily("Wingdings 2").buildWesternFontFamily("Wingdings 2");
        return styleBuilder.build();
    }

    public static Style getCheckBox() {
        return getCheckBox(defauleFontSize, defauleColor);
    }

    /**
     * 上标
     * @param fontSize
     * @param color
     * @return
     */
    public static Style getSuperscript(double fontSize, String color) {
        return Style.builder().buildFontSize(fontSize).buildColor(color).buildFontFamily(defultfontFamily).buildWesternFontFamily(defultWesternFontFamily).buildSuper().build();
    }

    public static Style getSuperscript() {
        return getSuperscript(defauleFontSize, defauleColor);
    }

    /**
     * 下标
     * @param fontSize
     * @param color
     * @return
     */
    public static Style getSubscript(double fontSize, String color) {
        return Style.builder().buildFontSize(fontSize).buildColor(color).buildFontFamily(defultfontFamily).buildWesternFontFamily(defultWesternFontFamily).buildSub().build();

    }

    public static Style getSubscript() {
        return getSubscript(defauleFontSize, defauleColor);
    }


}
