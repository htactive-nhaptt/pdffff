package com.audit.demo.app.dao.excel;

import java.util.*;

public class BodyData {
    public  Map<String, Object[]> getDataBody() {
        Map<String, Object[]> dates = new TreeMap<String, Object[]>();
        dates.put("2",new Object[]{127395190, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "B2C", "", "", "", ""});
        dates.put("3",new Object[]{127395191, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "B2B", "", "", "", ""});
        dates.put("4",new Object[]{127395192, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "B2C", "", "", "", ""});
        dates.put("5",new Object[]{127395193, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "B2B", "", "", "", ""});
        dates.put("6",new Object[]{127395194, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "B2C", "", "", "", ""});
        dates.put("7",new Object[]{127395195, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "B2C", "", "", "", ""});
        dates.put("8",new Object[]{127395196, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "B2B", "", "", "", ""});
        dates.put("9",new Object[]{127395197, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "B2C", "", "", "", ""});
        dates.put("10",new Object[]{12739518, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "B2B", "", "", "", ""});
        dates.put("11",new Object[]{12739512, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "B2B", "", "", "", ""});
        dates.put("12",new Object[]{12739558, 1373, "MEDIATABLETS", "SAMSUNG", "SAMSUNG", "10.00\" WXGA 16.0GB FLASH HD 2048MB-RAM ANDROID 5.1.X LOLLIPOP MT8321 3G   NO SIM FREE NO GOLD", "B2C", "", "", "", ""});

        return dates;
    }

    public List<String> getHeaderBody() {
        String [] headerStrings =  {"ARTICLE_NUMBER", "PG NUMBER", "PG NAME", "BRAND", "MODEL", "FEATURE TEXT", "SALES TYPE" ,"MULTI PACK", "PRO", "SAL", "NOTE"};
        return new ArrayList<>(Arrays.asList(headerStrings));
    }
}
