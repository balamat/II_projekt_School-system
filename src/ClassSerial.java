public enum ClassSerial {
    CL_1(1, "07:45 - 08:30"),
    CL_2(2, "08:40 - 09:25"),
    CL_3(3, "09:35 - 10:20"),
    CL_4(4, "10:30 - 11:15"),
    CL_5(5, "11:25 - 12:10"),
    CL_6(6, "12:40 - 13:25"),
    CL_7(7, "13:35 - 14:20"),
    CL_8(8, "14:25 - 15:10"),
    CL_9(9, "15:15 - 16:00");


    ClassSerial(int serial, String period) {
        this.serial = serial;
        this.period = period;
    }

    private int serial;
    private String period;

    public int getSerial() {
        return serial;
    }

    public String getPeriod() {
        return period;
    }

    @Override
    public String toString() {
        return serial + ". óra: " + period;
    }
}
