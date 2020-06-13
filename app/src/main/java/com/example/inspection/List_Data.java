package com.example.inspection;

public class List_Data {
    private String id;
    private String name;
    private String option1;
    private String option2;
    private String option3;
    public  List_Data(){


    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }



    public List_Data(String id, String name, String option1, String option2, String option3) {
        this.id = id;
        this.name = name;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

}



