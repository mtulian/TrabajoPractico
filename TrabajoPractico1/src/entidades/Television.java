package entidades;


public class Television extends Electrodomestico {
//campos
private float resolucion;
private boolean sintonizadorTDT;
//constantes
static final float c_resol = 20;
static final boolean c_sinto = false;
//getters
public float getResolucion() {
	return resolucion;
}
public boolean isSintonizadorTDT() {
	return sintonizadorTDT;
}
//constructores
public Television() {
	super();
	resolucion = c_resol;
	sintonizadorTDT = c_sinto;
}
public Television(float precio,float peso) {
	super(precio,peso);
	resolucion = c_resol;
	sintonizadorTDT = c_sinto;
}
public Television(float p,String c,String ce,float pe,float res,boolean sinto){
	super(p,c,ce,pe);
	resolucion = res;
	sintonizadorTDT = sinto;	
}


@Override
	public float precioFinal() {
		float p = super.precioFinal();
		if(resolucion > 40){
			p = (float) ((p * 0.3) + p);
		}
		if(sintonizadorTDT){
			p += 50;
		}
		return p;
	}

//Generado para la tabla
/*
public void setResolucion(float resolucion) {
	this.resolucion = resolucion;
}
public void setSintonizadorTDT(boolean sintonizadorTDT) {
	this.sintonizadorTDT = sintonizadorTDT;
}
*/
}
