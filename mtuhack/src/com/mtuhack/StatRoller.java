package com.mtuhack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class StatRoller {
	public static Map<String,Integer> StatGen(String classname){
		Map<String,Integer>allstats=new HashMap<String,Integer>();
		ArrayList<Integer>statlist=new ArrayList<Integer>();
		for (int stat=0;stat<4;stat++){
			ArrayList<Integer>rolledstats=new ArrayList<Integer>();
			int total=0;
			for (int i=0; i<4; i++){
				Double roll=Math.random()*6;
				int actualroll=(int) Math.ceil(roll);
				rolledstats.add(actualroll);
			}
			Collections.sort(rolledstats);
			rolledstats.remove(0);
			for (int i=0; i<3; i++){
				total=total+rolledstats.get(i);
			}
			statlist.add(total);
		}
		Collections.sort(statlist);
		switch(classname){
		case "Fighter":
			allstats.put("STR", statlist.get(3)-10);
			allstats.put("CON", statlist.get(2)-10);
			allstats.put("DEX", statlist.get(1)-10);
			allstats.put("INT", statlist.get(0)-10);
			break;
		case "Thief":
			allstats.put("DEX", statlist.get(3)-10);
			allstats.put("INT", statlist.get(2)-10);
			allstats.put("CON", statlist.get(1)-10);
			allstats.put("STR", statlist.get(0)-10);
			break;
		case "Wizard":
			allstats.put("INT", statlist.get(3)-10);
			allstats.put("DEX", statlist.get(2)-10);
			allstats.put("CON", statlist.get(1)-10);
			allstats.put("STR", statlist.get(0)-10);
			break;
		case "Brute":
			allstats.put("CON", statlist.get(3)-10);
			allstats.put("STR", statlist.get(2)-10);
			allstats.put("DEX", statlist.get(1)-10);
			allstats.put("INT", statlist.get(0)-10);
			break;
		case "Ranger":
			allstats.put("DEX", statlist.get(3)-10);
			allstats.put("CON", statlist.get(2)-10);
			allstats.put("STR", statlist.get(1)-10);
			allstats.put("INT", statlist.get(0)-10);
			break;
		}
		System.out.println(allstats.toString());
		return allstats;
	}
	public static int hitpoint(int CON, String classname){
		switch(classname){
		case "Fighter":
			double role=Math.random()*10;
			int hp=(int) (Math.ceil(role)+CON);
			return hp;
		case "Thief":
			role=Math.random()*8;
			hp=(int) (Math.ceil(role)+CON);
			return hp;
		case "Brute":
			role=Math.random()*12;
			hp=(int) (Math.ceil(role)+CON);
			return hp;
		case "Wizard":
			role=Math.random()*6;
			hp=(int) (Math.ceil(role)+CON);
			return hp;
		case "Ranger":
			role=Math.random()*10;
			hp=(int) (Math.ceil(role)+CON);
			return hp;

		}
		return 0;
	}
	public static void main(String[] args){
		StatGen("Brute");
	}
}
