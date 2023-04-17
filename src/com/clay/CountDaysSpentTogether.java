package com.clay;

/**
 * 2409. 统计共同度过的日子数
 * Alice和Bob计划分别去罗马开会。给你四个字符串arriveAlice，leaveAlice，arriveBob和leaveBob。
 * Alice会在日期arriveAlice到leaveAlice之间在城市里（日期为闭区间），而Bob在日期arriveBob到leaveBob之间在城市里（日期为闭区间）。
 * 每个字符串都包含5个字符，格式为"MM-DD"，对应着一个日期的月和日。请你返回Alice和Bob同时在罗马的天数。你可以假设所有日期都在同一个自然年，
 * 而且不是闰年。每个月份的天数分别为：[31,28,31,30,31,30,31,31,30,31,30,31]。
 * @author CLAY
 */
public class CountDaysSpentTogether {
    public static void main(String[] args) {
        String arriveAlice = "12-26", leaveAlice = "12-27", arriveBob = "08-21", leaveBob = "12-17";

        System.out.println(countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));

    }
    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveAliceMonth = Integer.parseInt(strToIntArray(arriveAlice)[0]);
        int arriveAliceDate = Integer.parseInt(strToIntArray(arriveAlice)[1]);
        int leaveAliceMonth = Integer.parseInt(strToIntArray(leaveAlice)[0]);
        int leaveAliceDate = Integer.parseInt(strToIntArray(leaveAlice)[1]);
        int arriveBobMonth = Integer.parseInt(strToIntArray(arriveBob)[0]);
        int arriveBobDate = Integer.parseInt(strToIntArray(arriveBob)[1]);
        int leaveBobMonth = Integer.parseInt(strToIntArray(leaveBob)[0]);
        int leaveBobDate = Integer.parseInt(strToIntArray(leaveBob)[1]);
        if (arriveAliceMonth > leaveBobMonth || leaveAliceMonth < arriveBobMonth){
            return 0;
        }

        if (arriveAliceMonth == arriveBobMonth){
            if (leaveAliceMonth == leaveBobMonth){
                if (arriveAliceMonth == leaveAliceMonth){
                    if (arriveAliceDate > leaveBobDate || leaveAliceDate < arriveBobDate){
                        return 0;
                    }else {
                        return Math.min(leaveAliceDate, leaveBobDate) - Math.max(arriveAliceDate, arriveBobDate) + 1;
                    }
                }else {
                    int sumDays = 0;
                    int maxArriveDate = Math.max(arriveAliceDate, arriveBobDate);
                    int arriveMonthDays = getMonthDays(arriveAliceMonth);
                    sumDays += arriveMonthDays - maxArriveDate + 1;
                    int minLeaveDate = Math.min(leaveAliceDate, leaveBobDate);
                    if (!(leaveAliceMonth == arriveAliceMonth + 1)){
                        for (int i = arriveAliceMonth + 1; i < leaveAliceMonth; i++) {
                            sumDays += getMonthDays(i);
                        }
                    }
                    sumDays += minLeaveDate;
                    return sumDays;
                }
            }else {
                int minLeaveMonth = Math.min(leaveAliceMonth, leaveBobMonth);
                if (arriveAliceMonth == minLeaveMonth){
                    return (minLeaveMonth == leaveAliceMonth ? leaveAliceDate : leaveBobDate) - Math.max(arriveAliceDate, arriveBobDate) + 1;
                } else {
                    int sumDays = 0;
                    int maxArriveDate = Math.max(arriveAliceDate, arriveBobDate);
                    int arriveMonthDays = getMonthDays(arriveAliceMonth);
                    sumDays += arriveMonthDays - maxArriveDate + 1;
                    if (!(leaveAliceMonth == arriveAliceMonth + 1)){
                        for (int i = arriveAliceMonth + 1; i < minLeaveMonth; i++) {
                            sumDays += getMonthDays(i);
                        }
                    }
                    if (minLeaveMonth == leaveAliceMonth){
                        sumDays += leaveAliceDate;
                    }else {
                        sumDays += leaveBobDate;
                    }
                    return sumDays;
                }
            }
        }else {
            int maxArriveMonth = Math.max(arriveAliceMonth, arriveBobMonth);
            if (leaveAliceMonth == leaveBobMonth){
                if (maxArriveMonth == leaveAliceMonth){
                    if (maxArriveMonth == arriveAliceMonth){
                        if (arriveAliceDate > leaveBobDate){
                            return 0;
                        }
                    }else {
                        if (leaveAliceDate < arriveBobDate){
                            return 0;
                        }
                    }
                    return Math.min(leaveAliceDate, leaveBobDate) - (maxArriveMonth == arriveAliceMonth? arriveAliceDate : arriveBobDate) + 1;
                }else {
                    int sumDays = 0;
                    int minLeaveDate = Math.min(leaveAliceDate, leaveBobDate);
                    if (maxArriveMonth == arriveAliceMonth ){
                        sumDays += getMonthDays(arriveAliceMonth) - arriveAliceDate + 1;
                    }else {
                        sumDays += getMonthDays(arriveBobMonth) - arriveBobDate + 1;
                    }

                    if (!(leaveAliceMonth == maxArriveMonth + 1)){
                        for (int i = maxArriveMonth + 1; i < leaveAliceMonth; i++) {
                            sumDays += getMonthDays(i);
                        }
                    }

                    sumDays += minLeaveDate;
                    return sumDays;
                }
            }else {
                if(leaveAliceMonth == arriveBobMonth){
                    return leaveAliceDate < arriveBobDate ? 0 : leaveAliceDate - arriveBobDate + 1;
                }else if (arriveAliceMonth == leaveBobMonth){
                    return leaveBobDate < arriveAliceDate ? 0 : leaveBobDate - arriveAliceDate + 1;
                }else {
                    int minLeaveMonth = Math.min(leaveAliceMonth, leaveBobMonth);
                    int sumDays = 0;
                    if (maxArriveMonth == arriveAliceMonth ){
                        sumDays += getMonthDays(arriveAliceMonth) - arriveAliceDate + 1;
                    }else {
                        sumDays += getMonthDays(arriveBobMonth) - arriveBobDate + 1;
                    }
                    if (!(minLeaveMonth == maxArriveMonth + 1)){
                        for (int i = maxArriveMonth + 1; i < minLeaveMonth; i++) {
                            sumDays += getMonthDays(i);
                        }
                    }
                    if (minLeaveMonth == leaveAliceMonth ){
                        sumDays += leaveAliceDate;
                    }else {
                        sumDays += leaveBobDate;
                    }
                    return sumDays;
                }
            }
        }


    }

    public static String[] strToIntArray(String str){
        return str.split("-");
    }

    public static int getMonthDays(int month){
        int days;

        switch (month){
            case 1, 3, 5, 7, 8, 10, 12:
                days = 31;
                break;
            case 2:
                days = 28;
                break;
            case 4, 6, 9, 11:
                days = 30;
                break;
            default:
                days = 0;
                break;
        }
        return days;
    }


    public int countDaysTogether2(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] datesOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] prefixSum = new int[13];
        for (int i = 0; i < 12; i++) {
            prefixSum[i + 1] = prefixSum[i] + datesOfMonths[i];
        }

        int arriveAliceDay = calculateDayOfYear(arriveAlice, prefixSum);
        int leaveAliceDay = calculateDayOfYear(leaveAlice, prefixSum);
        int arriveBobDay = calculateDayOfYear(arriveBob, prefixSum);
        int leaveBobDay = calculateDayOfYear(leaveBob, prefixSum);
        return Math.max(0, Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1);
    }

    public int calculateDayOfYear(String day, int[] prefixSum) {
        int month = Integer.parseInt(day.substring(0, 2));
        int date = Integer.parseInt(day.substring(3));
        return prefixSum[month - 1] + date;
    }


}
