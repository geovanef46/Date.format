

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author geovanef46@gmail.com
 * 
 */
public class CalData {
	Date data = new Date();
	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	
	private Long calculaQtdDias(String datainicial, String dataFinal) {
		long qtdDias = 0;
		formatador.setLenient(false);
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = formatador.parse(datainicial);
			d2 = formatador.parse(dataFinal);
		} catch (ParseException e) {
			System.err.println("Ocorreu um erro ao gerar a data");
		}
		long dt = (d2.getTime() - d1.getTime());
		qtdDias = dt / 86400000L;
		return qtdDias;
	}
	
    /**calcula a quantidade de dias entre duas datas
	 * data final - data inicial
	 * @param datainicial
	 * @param dataInicial
	 * @return qtdDias
	 */
	@SuppressWarnings("deprecation")
	private String calculaDataEntrega(String dataInicial) {
		Date data = new Date(); 
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			data = formatador.parse(dataInicial);
		} catch (ParseException e) {
			System.err.println("Ocorreu um erro a gerar a data");
		}
		//data.setDate(data.getDate()+15);
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.DATE, 15);
		data = c.getTime();    
		dataInicial = formatador.format(data);
		return dataInicial;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalData calculo= new CalData();
		String datainicial = "01/05/2015";
		String dataFinal = calculo.formatador.format(calculo.data);
		System.err.println(" data inicial: "+datainicial+"  data final: "+dataFinal);
		System.out.println("qtd dias: "+calculo.calculaQtdDias(datainicial, dataFinal)+" dias");
		
		System.out.println("A data será: "+calculo.calculaDataEntrega(datainicial));
	}

}
