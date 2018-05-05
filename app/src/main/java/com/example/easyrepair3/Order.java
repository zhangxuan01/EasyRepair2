package com.example.easyrepair3;

import static android.R.attr.id;

/**
 * Created by Administrator on 2018/5/5.
 */

public class Order {

    private String username;
    private String linkman;
    private String link_tel;
    private String address;
    private String q_detail;
    private String m_name;
    private String m_tel;
    private String price;
    private String pay_mathod;

    public Order( String username,String address,String q_detail){
        this.username = username;
        this.address = address;
        this.q_detail = q_detail;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getLinkman() {
        return linkman;
    }

    public String getLink_tel() {
        return link_tel;
    }

    public String getAddress() {
        return address;
    }

    public String getQ_detail() {
        return q_detail;
    }

    public String getM_name() {
        return m_name;
    }

    public String getM_tel() {
        return m_tel;
    }

    public String getPrice() {
        return price;
    }

    public String getPay_mathod() {
        return pay_mathod;
    }
}
