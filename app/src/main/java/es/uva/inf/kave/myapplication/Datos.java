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

	private ArrayList<String> arrayMedidas;
	private String medida;

	private static Datos datos;

	private Datos() {
		arrayMedidas = new ArrayList<String>();
	}

	public void add_dato(double r1, double r2, double r3, double v1, double v2, double v3){
		medida = r1 + "," + r2 + "," + r3 + "," + v1 + "," + v2 + "," + v3;
		arrayMedidas.add(medida);
	}

	public static Datos getDatos(){
		if(datos == null) return new Datos();
		return datos;
	}

	public String get_medida(int indice){
		return arrayMedidas.get(indice);
	}

	public ArrayList<String> getArray(){
		return arrayMedidas;
	}

	public void add(String item){
		arrayMedidas.add(item);
	}

	public void remove(){
		if(arrayMedidas.size()>0) arrayMedidas.remove(arrayMedidas.size()-1);
	}
	
	/**
	 * Exporta los datos del apartado a un archivo CSV para su posterior tratamiento, el formato del archivo
	 * es UTF-8
	 * @return 0 Si se ha creado el archivo 1 Si la SD no esta montada, 2 si existe un archivo con el nombre de la carpeta, 3 Si no se ha podido crear el archivo
	 * 4 si no se soprta el "encoding" 
	 * 
	 *
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
	 *
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
	 * Metodo que da el tamaño del conjunto.
	 * @return Cantidad de datos que tiene el conjunto.
	 */
	public int length(){
		return arrayMedidas.size();
	}
}
