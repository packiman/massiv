package ru.netology.stats;

public class StatsService {
    // Сумма всех продаж
    public int SummaAllSales(int[] allsales) {
        int sum = 0;
        for (int i = 0; i < allsales.length; i++) {
            sum = sum + allsales[i];
        }
        return sum;
    }

    //Средняя сумма продаж в месяц
    public int AverageSumMonth(int[] averagesum) {
        int average = 0;
        int sum1 = 0;
        for (int i = 0; i < averagesum.length; i++) {
            sum1 += averagesum[i];
        }
        average = sum1 / averagesum.length;

        return Math.round(average);
    }


    //Номер месяца, в котором был пик продаж, то есть осуществлены продажи на максимальную сумму
    public int MaxSales(int[] sales) {
        int maxMonth = 0;
        int month = 0;
        for (long sale : sales) {
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1;
        }
        return maxMonth + 1;
    }


    //Номер месяца, в котором был минимум продаж, то есть осуществлены продажи на минимальную сумму
    public int MinSales(int[] sales) {
        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth + 1;
    }


    //Количество месяцев, в которых продажи были ниже среднего
    public int DownAverage(int[] month) {
        int variable = 0;
        for (int i = 0; i < month.length; i++) {
            if (month[i] > AverageSumMonth(month)) {
                variable++;
            }
        }
        return variable;
    }

    //Количество месяцев, в которых продажи были выше среднего
    public int UpAverage(int[] month) {
        int variable = 0;
        for (int i = 0; i < month.length; i++) {
            if (month[i] < AverageSumMonth(month)) {
                variable++;
            }
        }
        return variable;
    }
}