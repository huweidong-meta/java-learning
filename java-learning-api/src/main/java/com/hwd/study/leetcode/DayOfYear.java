package com.hwd.study.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 问题
 *
 * 给定一个特定的日期，编写一个函数来返回该日期的一年中的哪一天。 该函数的签名是
 *
 * int dayOfYear(int year, int month, int day)
 *
 *
 * 例如，给定输入 year=2016，month=1，day=3。 该函数应返回 3，因为日期 2016-01-03 是 2016 年的第 3 天。
 *
 * 另一个例子，给定输入年=2016，月=2，日=1。 该函数应返回 32，因为日期 2016-02-01 是 2016 年的第 32 天。
 */
public class DayOfYear {

    public static int dayOfYear(int year, int month, int day){
        int dayOfYear = day;
        List<Integer> oneList = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        List<Integer> twoList = Arrays.asList(4, 6, 9, 11);
        for (int i = 1; i < month; i++) {
            if(oneList.contains(i)){
                dayOfYear += 31;
                continue;
            }
            if(twoList.contains(i)){
                dayOfYear += 30;
                continue;
            }
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                dayOfYear += 29;
                continue;
            }
            dayOfYear += 28;
        }
        return dayOfYear;
    }

    public static void main(String[] args) {
        System.out.println(dayOfYear(2016, 1, 3) == 3);
        System.out.println(dayOfYear(2016, 2, 1) == 32);
        System.out.println(dayOfYear(2019, 2, 10) == 41);
    }
}
