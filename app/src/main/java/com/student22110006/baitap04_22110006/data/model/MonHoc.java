package com.student22110006.baitap04_22110006.data.model;

public class MonHoc {
    private String name;
    private String desc;
    private int pic;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPic() {
        return pic;
    }
    public void setPic(int pic) {
        this.pic = pic;
    }

    public MonHoc(String name, String desc, int pic) {
        this.name = name;
        this.desc = desc;
        this.pic = pic;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
