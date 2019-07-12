package com.py.examples.io;

/**
 * @author panyi on 18-9-14.
 */
public class Salary {

    public static final Double wuxian=13473.0;/*五险的基数 ,如果有需要的自己修改*/
    public static final Double gongjin=0.0;/*公积金的基数,如果有需要的自己修改*/

    public static void main(String[] args) {


        latesalary(17623.0);

        //latesalary(15000.0);


    }


    public static void latesalary(Double salary) {
        Double sal=salary;
        System.out.println("税前薪资为："+(salary));

//		Double wuxian=4279.0;/*五险的基数 ,如果有需要的自己修改*/
//		Double gongjin=8000.0;/*公积金的基数,如果有需要的自己修改*/
        Double wuxianjin=wuxian*0.08/*养老保险*/+wuxian*0.02/*医疗保险*/+wuxian*0.005/*医疗保险*/+gongjin*0.07/*公积金*/;
        System.out.println("税前缴纳的五险金为："+wuxianjin);

        System.out.println("税前扣除五险一金薪资为："+(salary-wuxianjin)+"\n");

        Double geshui=0.0;

        Double latest=0.0;
        Double before=0.0;

        Double qizhengdian=3500.0;
        System.out.println("个税3500的薪资计算:");
        if(qizhengdian==Double.parseDouble("3500")) {
            salary=	salary-wuxianjin-qizhengdian;//扣除个税起征点之后的薪资
            if(salary<=1500) { /*(0,1500]*/
                geshui=(salary*0.03);
            }else if(salary<=4500) {/*[1500,4500]*/
                geshui=(1500*0.03)+(salary-1500)*0.10;
            }else if(salary<=9000){/*[4500,9000]*/
                geshui=(1500*0.03)+3000*0.10+(salary-4500)*0.20;
            }else if(salary<=35000) {/*[9000,35000]*/
                geshui=(1500*0.03)+(3000*0.10)+(4500)*0.20+(salary-9000)*0.25;
            }else if(salary<=55000){/*[35000,55000]*/
                geshui=(1500*0.03)+(3000*0.10)+(4500)*0.20+26000*0.25+(salary-35000)*0.30;
            }else if(salary<=80000){/*[55000,80000]*/
                geshui=(1500*0.03)+(3000*0.10)+(4500)*0.20+26000*0.25+20000*0.30+
                        (salary-55000)*0.35;
            }else {/*80000+*/
                geshui=(1500*0.03)+(3000*0.10)+(4500)*0.20+26000*0.25+20000*0.30
                        +25000*0.35+(salary-80000)*0.45;
            }

            System.out.println("交的个税为："+geshui);
            salary=salary+qizhengdian-geshui;
            before=salary;
            System.out.println("税后薪资为："+salary);
        }


        qizhengdian=5000.0;
        System.out.println("\n"+"个税5000的薪资计算:");

        salary=sal;
        if(qizhengdian==Double.parseDouble("5000")) {
            salary=	salary-wuxianjin-qizhengdian;//扣除个税起征点之后的薪资

            if(salary<=3000) {
                geshui=(salary*0.03);
            }else if(salary <= 12000){
                geshui=3000*0.03+(salary-3000)*0.10;
            }else if(salary <= 25000) {
                geshui=3000*0.03+9000*0.10+(salary-12000)*0.20;
            }else if(salary <=35000){
                geshui=3000*0.03+9000*0.10+13000*0.20+(salary-25000)*0.25;
            }else if(salary <=55000) {
                geshui=3000*0.03+9000*0.10+13000*0.20+10000*0.25+(salary-35000)*0.30;
            }else if(salary <=80000) {
                geshui=3000*0.03+9000*0.10+13000*0.20+10000*0.25+20000*0.30+
                        (salary-55000)*0.35;
            }else {
                geshui=3000*0.03+9000*0.10+13000*0.20+10000*0.25+20000*0.30+
                        25000*0.35+(salary-80000)*0.45;
            }
            System.out.println("交的个税为："+geshui);
            salary=salary+qizhengdian-geshui;
            latest=salary;
            System.out.println("税后薪资为："+salary);
        }

        System.out.println("\n"+"个税提到5000之后每个月教之前多发的金额："+(latest-before)+"\n"+">>>>>>>>>>>>>>>>>"+"\n");


    }

}
