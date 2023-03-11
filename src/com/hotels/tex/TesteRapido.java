package com.hotels.tex;

import com.hotels.tex.dao.HotelDAO;

public class TesteRapido {
	
	public static void main(String[] args) {
		
		HotelDAO hotelDAO = new HotelDAO();
		
		System.out.println(hotelDAO.procurarHotelPorId(1));
		
		hotelDAO.delete(1);
		
	}

}
