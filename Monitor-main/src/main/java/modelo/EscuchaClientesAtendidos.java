package modelo;

import java.util.LinkedList;
import java.util.Stack;

import comunicacion.Conexion;
import modeloInfo.InfoClienteAtendido;
import modeloInfo.InfoClientesAtendidos;
import modeloInfo.InfoPeticion;
import ventana.Ventana;

public class EscuchaClientesAtendidos implements Runnable {
	private Ventana window;
	private Conexion conexion;
	
	public EscuchaClientesAtendidos(Ventana window,Conexion conexion) {
		this.window = window;
		this.conexion = conexion;
	}

	public void run() {
		while(true) {
			try {
				InfoPeticion peticion = new InfoPeticion();
				this.conexion.enviarPaquete(peticion);
				InfoClientesAtendidos clientesAtendidos =(InfoClientesAtendidos)this.conexion.recibirPaquete();
				Stack<InfoClienteAtendido> clientes = clientesAtendidos.getPilaClientesAtendidos();
				LinkedList<Integer> dnis = new LinkedList<Integer>();
				LinkedList<Integer> box = new LinkedList<Integer>();
				LinkedList<String> nombres = new LinkedList<String>();
				InfoClienteAtendido actual;
				while(!clientes.isEmpty()) {
					 actual = clientes.pop();
					 dnis.add(actual.getDni());
					 box.add(actual.getBox());
					 nombres.add(actual.getNombre());
				}
				this.window.getModeloTabla().setClientes(dnis);
				this.window.getModeloTabla().setBox(box);
				this.window.getModeloTabla().setNombres(nombres);
				this.window.getTable().repaint();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

}
