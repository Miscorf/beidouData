package com.mis.beidoudata.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author Li HuiKun
 * @Date 2022/8/4 11:18
 **/
public class LoadFile {

    public static ArrayList<ArrayList<Float>> BufferedReader(String path,int length) {
        BufferedReader reader;
        String[] perm = new String[length];
        ArrayList<ArrayList<Float>>  res = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = null;
            while((line = reader.readLine())!=null){
                //perm = line.split("\\s+");
                perm = line.split(",");
                ArrayList<Float> temp = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    // temp.add(Integer.parseInt(perm[i]));
                    temp.add(Float.parseFloat(perm[i]));

                }
                res.add(temp);
            }
            reader.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return res;

    }
}
