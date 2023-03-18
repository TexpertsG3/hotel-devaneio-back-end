package br.com.hotel.modelo;

import java.util.HashSet;
import java.util.Set;

public class RedeHotel {

	private static Integer idRedeHotel;
	private static Set<Hotel> listaHotel = new HashSet<>();
	private static Set<Admin> listaAdmin = new HashSet<>();

	public RedeHotel(Set<Hotel> listaHotel, Set<Admin> listaAdmin) {
		RedeHotel.listaHotel = listaHotel;
		RedeHotel.listaAdmin = listaAdmin;
	}

	public static Integer getIdRedeHotel() {
		return idRedeHotel;
	}

	public static void setIdRedeHotel(Integer idRedeHotel) {
		RedeHotel.idRedeHotel = idRedeHotel;
	}

	public Set<Hotel> getListaHotel() {
		return listaHotel;
	}

	public void setListaHotel(Set<Hotel> listaHotel) {
		RedeHotel.listaHotel = listaHotel;
	}

	public static Set<Admin> getListaAdmin() {
		return listaAdmin;
	}

	public static void setListaAdmin(Set<Admin> listaAdmin) {
		RedeHotel.listaAdmin = listaAdmin;
	}

}
