package com.example.btvn_listview;

public class Contact {
    public String name, nameSchool, text1, text2, text3, text4, text5, text6;

    public int img1, backgroud;

    public Contact(String name, String nameSchool, String text1, String text2, String text3, String text4, String text5, String text6, int img1,  int backgroud) {
        this.name = name;
        this.nameSchool = nameSchool;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
        this.text6 = text6;
        this.img1 = img1;
        this.backgroud = backgroud;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public String getText6() {
        return text6;
    }

    public void setText6(String text6) {
        this.text6 = text6;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getBackgroud() {
        return backgroud;
    }

    public void setBackgroud(int backgroud) {
        this.backgroud = backgroud;
    }
}
