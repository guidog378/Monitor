package modeloSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JLabel;

import modeloPaqueteInfo.PaqueteProxCliente;

public class Receptor implements Runnable {
	private JLabel dni,box;
	
	public Receptor(JLabel dni,JLabel box) {
		this.box = box;
		this.dni = dni;
	}

	public void run() {
		try {
			ServerSocket sv = new ServerSocket(9790);
			while(true) {
				Socket socket = sv.accept();
				ObjectInputStream fe = new ObjectInputStream(socket.getInputStream());
				PaqueteProxCliente paquete = (PaqueteProxCliente)fe.readObject();
				this.dni.setText(Integer.toString(paquete.getDNIcliente()));
				this.box.setText(Integer.toString(paquete.getBox()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
