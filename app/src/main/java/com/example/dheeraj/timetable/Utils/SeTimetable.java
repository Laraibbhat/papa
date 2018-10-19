package com.example.dheeraj.timetable.Utils;

import java.util.ArrayList;

public class SeTimetable {

    public String className;
   // public ArrayList<String> time,prac,subprof,labprof;
    public ArrayList<String> mon,tue,wen,thur,fri;


    public SeTimetable() {

    }

   // public SeTimetable(String className, ArrayList<String> time, ArrayList<String> prac, ArrayList<String> subprof, ArrayList<String> labprof) {
   public SeTimetable(String className, ArrayList<String> mon, ArrayList<String> tue, ArrayList<String> wen, ArrayList<String> thur,ArrayList<String> fri) {
        this.className = className;
       /* this.time = time;
        this.prac = prac;
        this.subprof = subprof;
        this.labprof = labprof;*/

       this.mon=mon;
       this.tue=tue;
       this.wen=wen;
       this.thur=thur;
       this.fri=fri;

    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ArrayList<String> getMon() {
        //return time;
        return mon;
    }

    public void setTime(ArrayList<String> mon) {
       // this.time = time;
        this.mon=mon;
    }

    public ArrayList<String> getTue() {
        //return prac;
        return tue;
    }

    public void setPrac(ArrayList<String> tue) {
        //this.prac = prac;
        this.tue=tue;
    }

    public ArrayList<String> getWen() {
        //return subprof;
        return wen;
    }

    public void setSubprof(ArrayList<String> wen){//subprof) {
        //this.subprof = subprof;
        this.wen=wen;
    }

    public ArrayList<String> getThur() {
        //return labprof;
        return thur;
    }

    public void setLabprof(ArrayList<String> thur){//labprof) {
        //this.labprof = labprof;
        this.thur=thur;
    }
    public ArrayList<String> getfri() {
        //return labprof;
        return fri;
    }

    public void setLabproff(ArrayList<String> fri){//labprof) {
        //this.labprof = labprof;
        this.fri=fri;
    }




}
