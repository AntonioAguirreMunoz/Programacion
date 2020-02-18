public class Main_Unidades{
	
		public static void main (String[] args){
			
			double libras = 1.3;
			double kilogramos = Unidades.convertirLibrasAKilogramos (libras);
			System.out.println (libras + "£ son " + kilogramos + "Kg ");
			
			double pies = 5.3;
			double metros = Unidades.convertirPiesAMetros (pies);
			System.out.println (pies + "ft son " + metros + "m ");
					
			double yardas = 3.4;
			double metros2 = Unidades.convertirYardasAMetros (yardas);
			System.out.println (yardas + "yd son " + metros2 + "m ");
			
			double millas = 7.4;
			double metros3 = Unidades.convertirMillasAMetros (millas);
			System.out.println (millas + "mi son " + metros3 + "m ");
			
			double acres = 4.2;
			double hectareas = Unidades.convertirAcresAHectareas (acres);
			System.out.println (acres + "a son " + hectareas + "ha ");
			
			double onzas = 8.5;
			double mililitros = Unidades.convertirOnzasAMililitros (onzas);
			System.out.println (onzas + "℥ son " + mililitros + "ml ");
			
			double galones = 9.8;
			double litros = Unidades.convertirGalonesALitros (galones);
			System.out.println (galones + "gal son " + litros + "l ");			
	}
}
