package com.forecast;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static List<Integer> forecastHandler(String sysname, String fromDate, String toDate) {
        ArrayList<Map<String, String>> json = new ArrayList<>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", "abc");
        map.put("fk_id", "row dim id of abc sysname");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("id", "2");
        map2.put("fk_id", "1");
        json.add(map);
        json.add(map2);
        for (int i = 0; i < json.size(); i++) {
            if (json.get(i).get("id") == sysname) {
                System.out.println(json.get(i).get("fk_id"));
            }
        }
        System.out.println(DataService.getRowDimensionTable());
        return null;
    }

//    public static List<String> calculcateForecastDateRanges(String lastDate){
//        List<String> week = new ArrayList<>();
//        LocalDate endDate = LocalDate.parse(lastDate);
//        week.add(endDate.plusDays(1).toString());
//        week.add(endDate.plusDays(1).toString());
//        return  week;
//    }

    public static List<String> calculateWeekRanges(String weekStartDate, String weekEndDate, int numberOfWeeks) {
        List<String> week = new ArrayList<>();
        week.add(LocalDate.parse(weekStartDate).plusWeeks(numberOfWeeks).toString());
        week.add(LocalDate.parse(weekEndDate).plusWeeks(numberOfWeeks).toString());
        return week;
    }


    public static SortedMap<Integer,TimeDimensionRange> getTimeDimensionRanges() throws SQLException {
        DBAccess dbObject = new DBAccess();
        ResultSet rs5 = dbObject.queryDB("select pk_id, fk_fcm_id, fk_forecast_type_id, order_field, fk_period_id as period from cfs_forecast_time_dimension;");
        List<List<Integer>> period = new ArrayList<>();
        do {
            List<Integer> periodAndOrder = new ArrayList<>();
            periodAndOrder.add(Integer.parseInt(rs5.getString("pk_id")));
            periodAndOrder.add(Integer.parseInt(rs5.getString("fk_fcm_id")));
            periodAndOrder.add(Integer.parseInt(rs5.getString("fk_forecast_type_id")));
            periodAndOrder.add(Integer.parseInt(rs5.getString("order_field")));
            periodAndOrder.add(Integer.parseInt(rs5.getString("period")));
            period.add(periodAndOrder);
        } while (rs5.next());
        Collections.sort(period, new SortByOrder());
        System.out.println(period);
        SortedMap<Integer, TimeDimensionRange> bucket = new TreeMap<>();
        SortedMap<Integer, TimeDimensionRange> bucket2 = new TreeMap<>();
        List<String> week = new ArrayList<>();
        LocalDate cur = LocalDate.now();
        String day = cur.getDayOfWeek().toString();
        switch (day) {
            case "SUNDAY":
                week.add(cur.toString());
                week.add(cur.plusDays(6).toString());
                break;
            case "MONDAY":
                week.add(cur.minusDays(1).toString());
                week.add(cur.plusDays(5).toString());
                break;
            case "TUESDAY":
                week.add(cur.minusDays(2).toString());
                week.add(cur.plusDays(4).toString());
                break;
            case "WEDNESDAY":
                week.add(cur.minusDays(3).toString());
                week.add(cur.plusDays(3).toString());
                break;
            case "THURSDAY":
                week.add(cur.minusDays(4).toString());
                week.add(cur.plusDays(2).toString());
                break;
            case "FRIDAY":
                week.add(cur.minusDays(5).toString());
                week.add(cur.plusDays(1).toString());
                break;
            case "SATURDAY":
                week.add(cur.minusDays(6).toString());
                week.add(cur.toString());
                break;
        }
        List<Integer> currentTimeDimension = period.stream().filter(list -> list.get(3) == 0).collect(Collectors.toList()).get(0);
        TimeDimensionRange timeDimensionRange = new TimeDimensionRange(currentTimeDimension.get(0), currentTimeDimension.get(1), currentTimeDimension.get(2), currentTimeDimension.get(3), currentTimeDimension.get(4), week.get(0), week.get(1));
//        bucket.put(currentTimeDimension.get(0), timeDimensionRange);
        bucket2.put(currentTimeDimension.get(3), timeDimensionRange);
        for (List list : period) {
//            if ((int)list.get(2) == 2) {
//            if ((int) list.get(1) > 0) {
                List<String> weekRange = calculateWeekRanges(bucket2.get(currentTimeDimension.get(3)).getFromDate(), bucket2.get(currentTimeDimension.get(3)).getToDate(), (int) list.get(3));
//                bucket.put((int) list.get(0), new TimeDimensionRange((int) list.get(0), (int) list.get(1), (int) list.get(2), (int) list.get(3), (int) list.get(4), weekRange.get(0), weekRange.get(1)));
                bucket2.put((int) list.get(3), new TimeDimensionRange((int) list.get(0), (int) list.get(1), (int) list.get(2), (int) list.get(3), (int) list.get(4), weekRange.get(0), weekRange.get(1)));
//            } else if ((int) list.get(1) < 0) {
//                List<String> weekRange = calculateWeekRanges(bucket.get(currentTimeDimension.get(0)).getFromDate(), bucket.get(currentTimeDimension.get(0)).getToDate(), (int) list.get(3));
//                bucket.put((int) list.get(0), new TimeDimensionRange((int) list.get(0), (int) list.get(1), (int) list.get(2), (int) list.get(3), (int) list.get(4), weekRange.get(0), weekRange.get(1)));
//                bucket2.put((int) list.get(3), new TimeDimensionRange((int) list.get(0), (int) list.get(1), (int) list.get(2), (int) list.get(3), (int) list.get(4), weekRange.get(0), weekRange.get(1)));
//            }
//            }
//            else if((int)list.get(2)== 1){
//                List<String> dateRange = new ArrayList<>();
//                if((int)list.get(1) == 0){
//                    dateRange.add(LocalDate.now().toString());
//                    dateRange.add(LocalDate.now().toString());
//                    bucket.put((String)list.get(0),dateRange);
//                }
//                else{
//                    List<String> dateRangeList = calculcateForecastDateRanges(bucket.get(String.valueOf(bucket.size())).get(1));
//                    bucket.put((String)list.get(0),dateRangeList );
//                }
//            }
        }
        Map<String,SortedMap<Integer,TimeDimensionRange>> map = new HashMap<>();
        map.put("Date Ranges based on time dimension ids",bucket);
        map.put("Date Ranges based on order",bucket2);
        return bucket2;
    }



    public static void main(String[] args) throws SQLException {
//        ResultSet rs = (new DBAccess()).queryDB("select fk_fc_cell_id,date_field,SUM(cell_value) as value from forecast_schema.cfs_forecast_snapshot_cell where date_field between '2021-05-12' and '2021-05-28' \n" +
//                "and fk_fc_cell_id in \n" +
//                "(select pk_id from forecast_schema.cfs_forecast_cell where fk_row_dimension_id \n" +
//                "= ( select pk_id from forecast_schema.cfs_forecast_row_dimension where sysname="+"d011"+"))\n" +
//                "group by fk_fc_cell_id;");
//        do{
//            System.out.println(rs.getString("fk_fc_cell_id") + " " + rs.getString("date_field") + " " + rs.getString("value"));
//        }while(rs.next());
        Iterator mapIterator = getTimeDimensionRanges().entrySet().iterator();
        while(mapIterator.hasNext()){
            System.out.println(mapIterator.next());
        }
    }
}
