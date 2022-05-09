package it.polito.tdp.extflightdelays.model;

public class CoppiaID {

	private int idPartenza;
	private int idArrivo;
	private double media;
	
	public CoppiaID(int idPartenza, int idArrivo, double media) {
		super();
		this.idPartenza = idPartenza;
		this.idArrivo = idArrivo;
		this.media = media;
	}

	public int getIdPartenza() {
		return idPartenza;
	}

	public void setIdPartenza(int idPartenza) {
		this.idPartenza = idPartenza;
	}

	public int getIdArrivo() {
		return idArrivo;
	}

	public void setIdArrivo(int idArrivo) {
		this.idArrivo = idArrivo;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	
	@Override
	public String toString() {
		return idPartenza + ", " + idArrivo + ", " + media;
	}
	

}
