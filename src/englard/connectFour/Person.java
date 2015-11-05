package englard.connectFour;

import java.awt.Color;

import englard.math.InvalidDataException;

public class Person {
	private String name;
	private int color;
	
	/*
	 * each person has a name and can be either color 1 = red
	 * or color 2 = blue
	 */
	public Person(String name, int color) throws InvalidDataException{
		this.name= name;
		if(color != 1 || color != 2){
			throw new InvalidDataException();
		}
		this.color = color;
	}

}
