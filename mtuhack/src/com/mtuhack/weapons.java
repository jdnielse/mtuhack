package com.mtuhack;

public class weapons {

	public static int longsword(){
		double damageroll1=Math.random()*8;
		int damageroll=(int) Math.ceil(damageroll1);
		return damageroll;
	}
	public static int longbow(){
		double damageroll1=Math.random()*8;
		int damageroll=(int) Math.ceil(damageroll1);
		return damageroll;
	}
	public static int greatsword(){
		double damageroll1=Math.random()*6+Math.random()*6;
		int damageroll=(int) Math.ceil(damageroll1);
		return damageroll;
	}
	public static int mace(){
		double damageroll1=Math.random()*8;
		int damageroll=(int) Math.ceil(damageroll1);
		return damageroll;
	}
}
