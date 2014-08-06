package entidades;
public class Electrodomestico {
	
//campos
private int id;
private float precioBase;
private static int ultimoID = 0;
private String color; // blanco,negro,rojo,azul y gris
private String consumoEnergetico;//letras de la A a la F
private float peso;
//constantes
static final float c_precio = 100;
static final String c_color = "blanco";
static final String c_consumo = "F";
static final float c_peso = 5;

//geters
public float getPrecioBase() {
	return precioBase;
}
public String getColor() {
	return color;
}
public String getConsumoEnergético() {
	return consumoEnergetico;
}
public float getPeso() {
	return peso;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
//constructores
public void asignaID(){
	id = ultimoID;
	ultimoID += 1;
}
public Electrodomestico() {
	asignaID();
	color = c_color;
	consumoEnergetico = c_consumo;
	precioBase = c_precio;
	peso = c_peso;
}
public Electrodomestico(float precio,float peso){
	asignaID();
	this.peso = peso;
	this.precioBase = precio;
	color = c_color;
	consumoEnergetico = c_consumo;
}
public Electrodomestico(float p,String c,String ce,float pe){
	asignaID();
	precioBase = p;
	comprobarColor(c);
	comprobarConsumoEnergetico(ce);
	peso = pe;
	
}
public Electrodomestico(int id,float p,String c,String ce,float pe){
	this.id = id;
	precioBase = p;
	comprobarColor(c);
	comprobarConsumoEnergetico(ce);
	peso = pe;
}
//metodos
private void comprobarConsumoEnergetico(String letra){

	switch(letra.toUpperCase()){
	case "A":consumoEnergetico = letra; break;
	case "B":consumoEnergetico = letra; break;
	case "C":consumoEnergetico = letra; break;
	case "D":consumoEnergetico = letra; break;
	case "E":consumoEnergetico = letra; break;
	case "F":consumoEnergetico = letra; break;
	default: consumoEnergetico = c_consumo;   break;
	}
}
private void comprobarColor(String color){

	switch(color.toUpperCase())
	{
	case "BLANCO": this.color = color;		break;
	case "NEGRO":  this.color = color;		break;
	case "ROJO":   this.color = color;		break;
	case "AZUL":   this.color = color;		break;
	case "GRIS":   this.color = color;		break;
	default: 	   this.color = c_color; 	break;
	}
}
public float precioFinal(){
	float p = 0;
	switch(consumoEnergetico){
	case "A": p = 	precioBase + 100;break;
	case "B": p =	precioBase + 80; break;
	case "C": p =	precioBase + 60; break;
	case "D": p =	precioBase + 50; break;
	case "E": p =	precioBase + 30; break;
	case "F": p =	precioBase + 10; break;
	default: break;
	}
	
	if(peso > 0 || peso <= 19){
		p = precioBase + 10;
	} else if(peso >= 20 || peso <= 49){
		p = precioBase + 50;
	}else if(peso >= 50 || peso <= 79){
		p = precioBase + 80;
	}else if(peso >= 50 || peso <= 79){
		p = precioBase + 100;
	}
	return p;
}


}
