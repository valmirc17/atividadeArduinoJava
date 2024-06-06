import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;


public class ControlePorta {
    private OutputStream serialOut;
    private int taxa;
    private String portaCOM;
    
    public ControlePorta(String portaCOM, int taxa){
    
                this.portaCOM = portaCOM;
                this.taxa = taxa;
                this.inicializar();
}


   private void inicializar(){
    
try{
    //Define uma variável portId do tipo CommPortIdentifier para realizar a comunicação serial
    CommPortIdentifier portId = null;
    try{
        //tenta verificar se a porta COM informada existe
        portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);
        
    }catch(NoSuchPortException npe){
        //Caso a porta COM não exista, será exibido um erro
    JOptionPane.showMessageDialog(null, "Porta COM não encontrada", "Porta COM", JOptionPane.PLAIN_MESSAGE);
    }
    
    SerialPort port = (SerialPort) portId.open("Comunicação Serial", this.taxa);
    serialOut = port.getOutputStream();
    port.setSerialPortParams(this.taxa,
                            SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);


} catch( Exception e){
    e.printStackTrace();
}
   
}
   public void enviaDados(int opcao){
   try{
       serialOut.write(opcao);//escreve o valor na porta serial para ser enviado 
   }catch(IOException ex){
       JOptionPane.showMessageDialog(null, "Não foi Possível enviar o dado. ", "Enviar dados", JOptionPane.PLAIN_MESSAGE);
   }
   
   }

    void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}