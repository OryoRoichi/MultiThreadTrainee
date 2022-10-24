package org.example;

import java.util.ArrayList;
import java.util.List;

public class SomeCalculation {
    private List<Long> borderList;

    public SomeCalculation() {
        this.borderList = new ArrayList<>();
    }

    public List<Long> getBorderList() {
        return borderList;
    }
    public long getFromBorderListById(int index) {
        return getBorderList().get(index);
    }
    public int getBorderListSize() {
        return getBorderList().size();
    }

    public void findBorder(long k, int n){
        for(int i = 0; i <= n; i++){
            borderList.add(k/n*i);
        }
    }
     public void printBorderList(){
         for (Long elem:borderList) {
             System.out.println(elem);
         }
     }
     public Long sumNumberFromTill(long from, long until){
        long res = 0 ;
        for(long i = from+1; i <= until ; i ++){
            res += i ;
        }
        return  res;
     }


}
