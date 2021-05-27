package modeloInfo;

import java.util.Stack;

public class InfoClientesAtendidos implements Informable {
	private Stack<InfoClienteAtendido> pilaClientesAtendidos;
	
	public int getIdOperacion() {
		return 0;
	}

	public Stack<InfoClienteAtendido> getPilaClientesAtendidos() {
		return pilaClientesAtendidos;
	}

	public void setPilaClientesAtendidos(Stack<InfoClienteAtendido> pilaClientesAtendidos) {
		this.pilaClientesAtendidos = pilaClientesAtendidos;
	}

}
