import javax.swing.JButton;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fuzil
 */
public class Arduino {
    
    private ControlePorta arduino;
    
    public Arduino(){
    
            arduino = new ControlePorta("COM5", 9600);
            
    }
    
    public void comunicacaoArduino(JButton button){
        if("Ligar".equals(button.getActionCommand())){
            arduino.enviaDados(1);
            //imprime o nome do botão pressionado
            System.out.println(button.getText());
        }
        else if("Desligar".equals(button.getActionCommand())){
            arduino.enviaDados(2);
            System.out.println(button.getText());
        }
        else{
            arduino.close();
            //imprime o botão pressionado
            System.out.println(button.getText());
        }
    }
    
}
