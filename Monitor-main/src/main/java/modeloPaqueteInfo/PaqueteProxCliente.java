package modeloPaqueteInfo;

public class PaqueteProxCliente implements IPaquete{
    private final int idOperacion = 1;
    private int box;
    private int DNIcliente;  

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public int getDNIcliente() {
        return DNIcliente;
    }

    public void setDNIcliente(int DNIcliente) {
        this.DNIcliente = DNIcliente;
    }

	public int getIdOperacion() {
		return this.idOperacion;
	}
}
