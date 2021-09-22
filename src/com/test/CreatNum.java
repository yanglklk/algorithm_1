package com.test;

import com.utils.TxUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatNum {
    public static void main(String[] args) {
        int num = 2000;
        List<String> lists = new ArrayList();
        for (int i = 0; i < num; i++) {
            lists.add(String.valueOf(i));
        }

        String listStr = TxUtils.getUuidStr(lists);
        System.out.println(Color.Blue.getNameChn());
        TxUtils.setStringTotxt(listStr,"/Users/anjuke/Desktop/num"+num+".txt");
    }
}

enum Color {
    Red("red","红"),
    Blue("blue","蓝");
    private String name;
    private String nameChn;

    Color(String name, String nameChn) {
        this.name = name;
        this.nameChn = nameChn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameChn() {
        return nameChn;
    }

    public void setNameChn(String nameChn) {
        this.nameChn = nameChn;
    }
}
