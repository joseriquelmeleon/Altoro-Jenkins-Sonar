package pageObjects;

public interface AltoroMutualElements {
		
	String inputUsuario = "input[id='uid']";
	String inputContrasena = "input[id='passw']";
	
	String btnSubmit = "input[name='btnSubmit']";
	String btnTransfer = "a[id='MenuHyperLink3']";
	
	String fromAccount = "//*[@id=\"fromAccount\"]/option[2]";
	String toAccount = "//*[@id=\"toAccount\"]/option[3]";
	String Ammount = "//*[@id=\"transferAmount\"]";
	String btnTransferMonto = "//*[@id=\"transfer\"]";
	String signOut = "//*[@id=\"LoginLink\"]/font";
	
	
	String labelInicioSesion = "/html/body/table[2]/tbody/tr/td[2]/div/h1";
	String labelPageTransfer = "//*[@id=\"tForm\"]/h1";
	String labelTransfer = "//*[@id=\"_ctl0__ctl0_Content_Main_postResp\"]/span";
	String labelSignOff = "//*[@id=\"LoginLink\"]/font";
}
