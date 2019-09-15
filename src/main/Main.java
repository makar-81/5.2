package main;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by emakarov on 28.01.2016.
 */



public class Main {
    public static void main(String[] args) {
        // put your code here
        //try {
        String temp;

        //FileReader fr = new FileReader("./test1.txt");
        //FileWriter wr = new FileWriter("./test2.txt");

        //BufferedWriter  bw = new BufferedWriter(wr);

        //BufferedReader br = new BufferedReader(fr);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //Map<String, Integer> store = new HashMap<String, Integer>();
        //Map<Integer,String> keys = new HashMap<Integer,String>();
        ArrayList<String> myArrayList = new ArrayList<String>();
        //ArrayList<String> myArrayList_correlations = new ArrayList<String>();

        // Map<String, Integer> count = new HashMap<String, Integer>();
        //int key = 0;
        try {
            while ((temp = br.readLine()) != null) {
                while (!temp.isEmpty()) {
                    int pos1 = temp.indexOf(" ");
                    String word1 = "";
                    if (pos1 > 0) {
                        word1 = temp.substring(0, pos1);
                        temp=temp.substring(pos1 + 1, temp.length());

                    } else {word1=temp; temp="";}
                    myArrayList.add(word1);
                }
                for (int i =0;i<myArrayList.size();i++){

                            ArrayList<String> myArrayTemp = (ArrayList<String>)myArrayList.clone();
                            myArrayTemp.remove(i);
                            //myArrayTemp.remove(myArrayList.get(i));
                            String stripe ="";

                            for(int j = 0; j<myArrayTemp.size();j++)
                            {
                                int count =0;
                                if (!stripe.contains(myArrayTemp.get(j)) && myArrayList.get(i).compareTo(myArrayTemp.get(j)) != 0) {
                                for (int l=0; l < myArrayTemp.size(); l++) {
                                    if (myArrayTemp.get(l).compareTo(myArrayTemp.get(j)) == 0) {
                                        count = count + 1;
                                    }

                                }
                                if (count>0) stripe = stripe + myArrayTemp.get(j) + ":" + count + ",";
                              }

                            }

                            stripe = (myArrayList.get(i) + "\t" + stripe);
                            stripe = stripe.substring(0,stripe.length()-1)+"\n";
                            System.out.println(stripe);
                            bw.write(stripe);
                            bw.flush();
                            myArrayTemp.clear();


                }
                myArrayList.clear();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    } /*catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}

