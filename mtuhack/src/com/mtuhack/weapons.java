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
	public static int staff(){
		double damageroll1=Math.random()*6;
		int damageroll=(int) Math.ceil(damageroll1);
		return damageroll;
	}
	public static int dagger(){
		double damageroll1=Math.random()*4;
		int damageroll=(int) Math.ceil(damageroll1);
		return damageroll;
	}
	public static int club(){
		double damageroll1=Math.random()*8;
		int damageroll=(int) Math.ceil(damageroll1);
		return damageroll;
	}
	public static int greatax(){
		double damageroll1=Math.random()*12;
		int damageroll=(int) Math.ceil(damageroll1);
		return damageroll;
	}
	public static int shortbow(){
		double damageroll1=Math.random()*6;
		int damageroll=(int) Math.ceil(damageroll1);
		return damageroll;
	}
	public static int crossbow(){
		double damageroll1=Math.random()*10;
		int damageroll=(int) Math.ceil(damageroll1);
		return damageroll;
	}
}
