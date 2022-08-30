package testMutual;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import pageEvents.AltoroMutualEvents;
import utils.OpenCSV;
import utils.Utils;
import baseClass.ClaseBase;

public class AltoroMutualTest extends ClaseBase{
	@Test(enabled = true, dataProvider = "carritoComprasData")
	public void QAS12(String args[]) throws InterruptedException {

		Utils.infoTestCase("Carrito de compras",
				"Validar la generación de una compra al agregar un producto al carrito de compras");

		AltoroMutualEvents.iniciarSesion(args[0], args[1]);
		AltoroMutualEvents.transferMount(args[2]);
		AltoroMutualEvents.signOff();
	}
	
	@DataProvider(name = "carritoComprasData")
	public Object[][] dataBrokerAPAlternative() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParameters("CSVAltoroMutual.csv", 1, 3);
		return data;
	}
}
