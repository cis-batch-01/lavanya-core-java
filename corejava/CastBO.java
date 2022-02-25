package com.technocis.corejava;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CastBO {
	
	public List<Cast> FindCast(List<Cast> castList, String nationality) {
		List<Cast> cast1= new ArrayList<Cast>();
		for(Cast cast:castList)
		{
		if(cast.getNationality().equals(nationality))
		{
			cast1.add(cast);
		}
		}
		return cast1;
	}
	
	public List<Cast> FindCast(List<Cast> castList,Date dob) {
		List<Cast> cast1= new ArrayList<Cast>();
		for(Cast cast:castList)
		{
		if(cast.getDob().equals(dob))
		{
			cast1.add(cast);
		}
		}
		return cast1;
	
	}
	
}
