package entidades;

public class Lavarropas extends Electrodomestico{
//campos
private float carga; 
//constantes
static final int c_carga = 5;
//getters
public float getCarga() {
	return carga;
}
//constructores
public Lavarropas(){
	super();
	carga = c_carga;
}
public Lavarropas(float precio,float peso) {
	super(precio,peso);
	carga = c_carga;
}
public Lavarropas(float p,String c,String ce,float pe,float carga) {
	super(p,c,ce,pe);
	this.carga = carga;
}

//metodos
public float precioFinal(){
	float p = super.precioFinal();
	if(carga > 30){
		p += 50;
	}
	return p;
}

public void setCarga(float carga) {
	this.carga = carga;}


}
