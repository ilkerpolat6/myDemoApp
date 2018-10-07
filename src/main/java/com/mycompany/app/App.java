package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App {
    public static String search(ArrayList<Integer> array, int x, int y, int z) {
        System.out.println("\n*\ninside search");
        String res="densities:";
        for(int i:array){
            int a=i/(x*y*z);
            res=res+" "+a;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("main e girdik");
        port(getHerokuAssignedPort());
        get("/", (req, res) -> "ilker polat");
        post("/compute", (req, res) -> {
            // System.out.println(req.queryParams("input1"));
            // System.out.println(req.queryParams("input2"));
            System.out.println("besmele");
            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            System.err.println("ıııııı");
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            System.out.println("1 scanlendin");
            while (sc1.hasNext()) {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s", ""));
                inputList.add(value);
            }
            System.out.println(inputList);
            String input2 = req.queryParams("input2").replaceAll("\\s", "");
            int input2AsInt = Integer.parseInt(input2);
            System.out.println("2demek almışız");
            String input3 = req.queryParams("input3").replaceAll("\\s", "");
            int input3AsInt = Integer.parseInt(input3);
            System.out.println("3demek almışız");
            String input4 = req.queryParams("input4").replaceAll("\\s", "");
            int input4AsInt = Integer.parseInt(input4);
            System.out.println("4demek almışız");
            String result = App.search(inputList, input2AsInt, input3AsInt, input4AsInt);
            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());
        get("/compute", (rq, rs) -> {
            Map map = new HashMap();
            map.put("result", "nnot computed yet!");
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; // return default port if heroku-port isn't set (i.e. on localhost)
    }
}