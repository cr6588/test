package com.cheny.web.bean;

import java.util.Locale;

import org.codehaus.jackson.annotate.JsonCreator;

public enum Language {
    CHINESE("zh", "zh_CN"), ENGLISH("en", "en_US");
    private final static String I18N_SPLIT_CODE = "_";
    private String shortName;
    private String i18nStr;

    private Language(String shortName, String i18nStr) {
        this.shortName = shortName;
        this.i18nStr = i18nStr;
    }

    public String getShortName() {
        return shortName;
    }

    public String getI18nStr() {
        return i18nStr;
    }

    @JsonCreator
    public static Language create(String lanuageStr) {
        Language[] values = Language.values();
        for (Language lanuage : values) {
            if (lanuage.getShortName().equalsIgnoreCase(lanuageStr)) {
                return lanuage;
            }
        }
        return CHINESE;
    }

    public static Language getLanuage(Locale locale) {
        Language[] values = Language.values();
        for (Language lanuage : values) {
            if (lanuage.getShortName().equalsIgnoreCase(locale.getLanguage())) {
                return lanuage;
            }
            if (lanuage.getI18nStr().equalsIgnoreCase(locale.getLanguage() + I18N_SPLIT_CODE + locale.getCountry())) {
                return lanuage;
            }
        }
        return Language.CHINESE;
    }

}
