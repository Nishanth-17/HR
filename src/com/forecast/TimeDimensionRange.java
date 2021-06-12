package com.forecast;

public class TimeDimensionRange {
    private int pk_id;
    private int fcm_id;
    private int forecast_type_id;
    private int order;
    private int period_type;
    private String fromDate;
    private String toDate;

    public TimeDimensionRange(int pk_id, int fcm_id, int forecast_type_id, int order, int period_type, String fromDate, String toDate) {
        this.pk_id = pk_id;
        this.fcm_id = fcm_id;
        this.forecast_type_id = forecast_type_id;
        this.order = order;
        this.period_type = period_type;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }



    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }
    public int getFcm_id() {
        return fcm_id;
    }

    public void setFcm_id(int fcm_id) {
        this.fcm_id = fcm_id;
    }

    public int getForecast_type_id() {
        return forecast_type_id;
    }

    public void setForecast_type_id(int forecast_type_id) {
        this.forecast_type_id = forecast_type_id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPeriod_type() {
        return period_type;
    }

    public void setPeriod_type(int period_type) {
        this.period_type = period_type;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "{pk_id=" + pk_id +
                ", fcm_id=" + fcm_id +
                ", forecast_type_id=" + forecast_type_id +
                ", order=" + order +
                ", period_type=" + period_type +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }
}
