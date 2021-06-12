package com.forecast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataService {
    public static ArrayList<Map<String,String>> getRowDimensionTable(){
        ArrayList<Map<String,String>> jsonArray = new ArrayList<>();

        Map<String, String> row2= new HashMap<String,String>();
        row2.put("pk_id","2");
        row2.put("sysname","d011");
        row2.put("fk_fcm_id","model_1");
        row2.put("parent_id","1");
        row2.put("order","1");
        row2.put("fk_dimension_id", "101");
        row2.put("dimension_value_id", "1000");
        row2.put("dimension_name", "Stark USA");
        Map<String, String> row3= new HashMap<String,String>();
        row3.put("pk_id","3");
        row3.put("sysname","d012");
        row3.put("fk_fcm_id","model_1");
        row3.put("parent_id","1");
        row3.put("order","2");
        row3.put("fk_dimension_id", "101");
        row3.put("dimension_value_id", "1001");
        row3.put("dimension_name", "Stark Germany");
        Map<String, String> row4= new HashMap<String,String>();
        row4.put("pk_id","4");
        row4.put("sysname","d013");
        row4.put("fk_fcm_id","model_1");
        row4.put("parent_id","1");
        row4.put("order","3");
        row4.put("fk_dimension_id", "101");
        row4.put("dimension_value_id", "1002");
        row4.put("dimension_name", "Stark Canada");
        Map<String, String> row5= new HashMap<String,String>();
        row5.put("pk_id","5");
        row5.put("sysname","d020");
        row5.put("fk_fcm_id","model_1");
        row5.put("parent_id","null");
        row5.put("order","2");
        row5.put("fk_dimension_id", "100");
        row5.put("dimension_value_id", "3");
        row5.put("dimension_name", "Account Receivables");
        Map<String, String> row6= new HashMap<String,String>();
        row6.put("pk_id","6");
        row6.put("sysname","d021");
        row6.put("fk_fcm_id","model_1");
        row6.put("parent_id","5");
        row6.put("order","1");
        row6.put("fk_dimension_id", "101");
        row6.put("dimension_value_id", "1000");
        row6.put("dimension_name", "Stark USA");
        Map<String, String> row7= new HashMap<String,String>();
        row7.put("pk_id","7");
        row7.put("sysname","d022");
        row7.put("fk_fcm_id","model_1");
        row7.put("parent_id","5");
        row7.put("order","2");
        row7.put("fk_dimension_id", "101");
        row7.put("dimension_value_id", "1001");
        row7.put("dimension_name", "Stark Germany");
        Map<String, String> row8= new HashMap<String,String>();
        row8.put("pk_id","8");
        row8.put("sysname","d023");
        row8.put("fk_fcm_id","model_1");
        row8.put("parent_id","5");
        row8.put("order","3");
        row8.put("fk_dimension_id", "101");
        row8.put("dimension_value_id", "1002");
        row8.put("dimension_name", "Stark Canada");
//        jsonArray.add(row1);
        jsonArray.add(row2);
        jsonArray.add(row3);
        jsonArray.add(row4);
        jsonArray.add(row5);
        jsonArray.add(row6);
        jsonArray.add(row7);
        jsonArray.add(row8);
        return jsonArray;
    }
//    public static ArrayList<Map<String,String>> getCFSForecastCell(){
//        ArrayList<Map<String,String>> jsonArray = new ArrayList<>();
//        Map<String, String> row1= new HashMap<>();
//        row1.put("pk_id", "cell_1");
//                "fk_fcm_id": "model_1",
//                "fk_fc_row_dim_id": "1",
//                "fk_fc_time_dim_id": "1",
//                "fk_value_type_id": "type_7",
//                "fk_fc_fm_id": null
//        return jsonArray;
//    }
}
