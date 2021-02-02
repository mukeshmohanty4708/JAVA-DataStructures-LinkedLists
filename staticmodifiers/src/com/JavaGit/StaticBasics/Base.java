package com.JavaGit.StaticBasics;

class Base {
    private static String college_name;
    private static long ip_address;

    public void setCollegeName(String college_name, long ip_address){
        this.college_name = college_name;
        this.ip_address = ip_address;
    }

}

class Sub extends Base{
    public String student_name;
    public int percentage;


}





