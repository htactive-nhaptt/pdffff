package com.audit.demo.app.dao.excel;

import java.util.Map;
import java.util.TreeMap;

public class TopData {
    public Map<String, Object[]> getData() {
        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"Shop:",                     4,    "Export Date:",  "14.06.2019"});
        data.put("2", new Object[]{"Code Auditor:",             5,    "PR Date:",      "20.09.2020"});
        data.put("3", new Object[]{"Code Supervisor:",          9,    "Audit Date:",   "25.5.2021"});
        data.put("4", new Object[]{"Code Form of Checking:",    7,    "Period:",       "01.05.2019 - 31.05.2019 (1905M)"});
        data.put("5", new Object[]{"Shop Name:",                "Gary",  "Note:",    ""});
        return data;
    }
}
