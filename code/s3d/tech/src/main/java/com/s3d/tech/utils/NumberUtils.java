package com.s3d.tech.utils;

import java.text.NumberFormat;

public class NumberUtils {
	public static String getPercentRate(double dividend, double divisor){
		if(dividend == 0 || divisor == 0){
			return "0%";
		}
		double value = dividend/divisor;
		NumberFormat nf = NumberFormat.getPercentInstance();
		return nf.format(value);
	}
	public static double getDoubleRate(double dividend, double divisor){
		if(dividend == 0 || divisor == 0){
			return 0.0d;
		}
		double value = dividend/divisor;
		return value;
	}
}
