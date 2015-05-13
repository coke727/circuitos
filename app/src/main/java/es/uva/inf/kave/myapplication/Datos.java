package es.uva.inf.kave.myapplication;

import android.annotation.SuppressLint;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@SuppressLint("SimpleDateFormat")
public class Datos {

	protected int apartado;
	protected ArrayList<Medida> arrayDatos;
	private boolean lleno;
	
	/**
	 * Genera un nuevo contenido con Datos de un "apartado" determinado.
	 * @param apartado Número del apartado al que serán dedicados los Datos.
	 */
	public Datos(int apartado) {
		// TODO Auto-generated constructor stub
		this.apartado = apartado;
		this.arrayDatos = new ArrayList<Medida>();
		lleno = false;
	}
	/**
	 * Añade una Medida al conjunto de datos.
	 * Es responsabilidad del usuario de esta clase, que
	 * la el apartado al que corresponde la medida coincida
	 * con el apartado de los Datos.
	 * @param medida Medida con el mismo apartado que los Datos
	 */
	public void add_dato(Medida medida){
		//TODO comprobar si esta la medida.
		this.arrayDatos.add(medida);
	}
	
	/**
	 * Permite añadir los dos valores correspondientes a una medida al registro de Datos.
	 * @param y Valor de la distancia (cm) o intensidad (mA) dependiendo del apartado de los Datos.
	 * @param campo Valor del campo magnético correspondiente al valor "y".
	 */
	public void add_dato(double y, double campo){
		if(apartado <= 1){
			Medida medida = new Medida(y, campo, y*2);
			this.arrayDatos.add(medida);
		}else{//apartado >1
			Medida medida = new Medida(y, campo);
			this.arrayDatos.add(medida);
		}
	}
	/**
	 * 
	 * @return Array de medidas de los Datos de un apartado indicado.
	 */
	public ArrayList<Medida> get_array(){
		return arrayDatos;
	}

	public void setArrayDatos(ArrayList<Medida> arrayDatos) {
		this.arrayDatos = arrayDatos;
	}
	/**
	 * A partir del indice devuelve el valor de la medida correspondiente  
	 * @param indice Numero correspondiente a la posicion de la
	 * @return
	 */
	public Medida get_medida(int indice){
		//TODO control de errores
		return arrayDatos.get(indice);
	}
	
	/**
	 * Exporta los datos del apartado a un archivo CSV para su posterior tratamiento, el formato del archivo
	 * es UTF-8
	 * @return 0 Si se ha creado el archivo 1 Si la SD no esta montada, 2 si existe un archivo con el nombre de la carpeta, 3 Si no se ha podido crear el archivo
	 * 4 si no se soprta el "encoding" 
	 * 
	 */
	public int exportar_csv(){
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formato = new SimpleDateFormat("HHmmss_ddMMyyyy");
		String fecha = formato.format(cal.getTime());
		String nombreArchivo = "Apartado_"+apartado+"_"+fecha+".csv";
		
		
		File rutaSD = new File(Environment.getExternalStorageDirectory().toString());
		File rutaCarpeta = new File(rutaSD+ File.separator+"SimuCampoMagnetico");
		File rutaArchivo = new File(rutaCarpeta+ File.separator+nombreArchivo);
		
		if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			//No esta presente la SD card
			return 1;
		}else if (!rutaCarpeta.isFile()){
			rutaCarpeta.mkdirs();
			try {
				PrintWriter escritor = new PrintWriter(rutaArchivo, "UTF-8");
				escritor.write(crearCSV());
				escritor.close();
				return 0;
				
			} catch (FileNotFoundException e) {
				//No se ha creado bien el archivo
				return 3;
			} catch (UnsupportedEncodingException e) {
				//No se soporta el encoding
				return 4;
			}
				
		}else{
			//Existe UN ARCHIVO con el mismo nombre que nuestra carpeta
			return 2;
		}
	}
	/**
	 * Genera la cadena de caracteres necesaria para la creación de un archivo CSV estandar.
	 * @return String con todas las medidas de los Datos, siguiendo el estandar de los archivos CSV.
	 */
	private String crearCSV(){
		
		if (apartado==1){
			String cadenaDatos = "Intensidad(mA),Intensidad_C(A),Campo(T)\n";
			for (Medida item: arrayDatos){
				
				cadenaDatos += item.valor1+","+item.valorIc+","+item.valor2+"\n";
			}
			
			return cadenaDatos;
		}else{
			String cadenaDatos = "Intensidad(mA),Campo(T)\n";
			for (Medida item: arrayDatos){
				
				cadenaDatos += item.valor1+","+item.valor2+"\n";
			}
			return cadenaDatos;	
		}
	}
	/**
	 * Para la medida dada se comprueba si existe otra igual
	 * en el conjunto.
	 * @param medida Medida que se desa comprobar
	 */
	public boolean esta(Medida medida){
		for(Medida med : arrayDatos){
			if(medida.valor1 == med.valor1){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que da el tamaño del conjunto.
	 * @return Cantidad de datos que tiene el conjunto.
	 */
	public int length(){
		return arrayDatos.size();
	}

	public void set_lleno(boolean b) {
		// TODO Auto-generated method stub
		this.lleno = b;
	}
	
	public boolean esta_lleno(){
		return lleno;
	}
}
