/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diegogarcia.system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

/**
 *
 * @author informatica
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    TextField textField, textField2; 
    @FXML
    Button button_1, button_2 ,button_3,button_4,button_5,button_6,button_7,button_8,button_9,button_0,button_c, button_mas, button_menos, 
            button_por, button_div, button_igual, button_punto, button_raiz, button_exponente, button_negativo, button_porcentaje, button_dividido,
            button_ce, button_back;
    
    
    double num1, resultado, proporcion, num2;
    int op, def;
    boolean flagPunto, flagNegativo, primerMenos, flagPorcentaje, flagOperacion1, flagOperacion2;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == button_1){
            textField.appendText("1");   
        } else if(event.getSource() == button_2){
            textField.appendText("2");
        }else if(event.getSource() == button_3){
            textField.appendText("3");
        }else if(event.getSource() == button_4){
            textField.appendText("4");
        }else if(event.getSource() == button_5){
            textField.appendText("5");
        }else if(event.getSource() == button_6){
            textField.appendText("6");
        }else if(event.getSource() == button_7){
            textField.appendText("7");
        }else if(event.getSource() == button_8){
            textField.appendText("8");
        }else if(event.getSource() == button_9){
            textField.appendText("9");
        }else if(event.getSource() == button_0){
            textField.appendText("0");
        } else if(event.getSource() == button_c){
            textField.clear();
            textField2.clear();
        } else if(event.getSource() == button_punto){
            if(!flagPunto){
                textField.appendText(".");
                flagPunto = true;
            }
        }else if(event.getSource() == button_mas){
            if(!flagOperacion1){
                num1 = Double.parseDouble(textField.getText());
                op = 1;
                textField.setText("");
                textField2.setText(Double.toString(num1));
                flagOperacion1 = true;
                flagOperacion2 = true;
            } else if(flagOperacion2){
                num2 =  Double.parseDouble(textField.getText());
                resultado = num1 + num2;
                textField.setText(Double.toString(resultado));
                flagOperacion1 = false;
                flagOperacion2 = false;
            }
            textField2.appendText("+");
            /*textField2.appendText(textField.getText());
            */
            resetAll();
        }else if(event.getSource() == button_menos){
            if(!flagOperacion1){
                num1 = Double.parseDouble(textField.getText());
                op = 2;
                textField.setText("");
                textField2.setText(Double.toString(num1));
                flagOperacion1 = true;
                flagOperacion2 = true;
            } else if(flagOperacion2){
                num2 =  Double.parseDouble(textField.getText());
                resultado = num1 - num2;
                textField.setText(Double.toString(resultado));
                flagOperacion1 = false;
                flagOperacion2 = false;
            }
            textField2.appendText("-");
            
            resetAll();
        }else if(event.getSource() == button_por){
            if(!flagOperacion1){
                num1 = Double.parseDouble(textField.getText());
                op = 3;
                textField.setText("");
                textField2.setText(Double.toString(num1));
                flagOperacion1 = true;
                flagOperacion2 = true;
            } else if(flagOperacion2){
                num2 =  Double.parseDouble(textField.getText());
                resultado = num1 * num2;
                textField.setText(Double.toString(resultado));
                flagOperacion1 = false;
                flagOperacion2 = false;
            }
            textField2.appendText("*");
            
            resetAll();
        }else if(event.getSource() == button_div){
            if(!flagOperacion1){
                num1 = Double.parseDouble(textField.getText());
                op = 4;
                textField.setText("");
                textField2.setText(Double.toString(num1));
                flagOperacion1 = true;
                flagOperacion2 = true;
            } else if(flagOperacion2){
                num2 =  Double.parseDouble(textField.getText());
                resultado = num1 / num2;
                textField.setText(Double.toString(resultado));
                flagOperacion1 = false;
                flagOperacion2 = false;
            }
            textField2.appendText("/");
            
            resetAll();
        }else if(event.getSource() == button_raiz){
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            resetAll();
            op = 5;
        }else if(event.getSource() == button_exponente){
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            resetAll();
            op = 6;
        }else if(event.getSource() == button_porcentaje){
            if(op == 1 || op ==2){
                proporcion = num1 * (Double.parseDouble(textField.getText()) / 100);
                textField.setText(Double.toString(proporcion));
            }else{
                proporcion = Double.parseDouble(textField.getText()) / 100;
                textField.setText(Double.toString(proporcion));
            }
            flagPorcentaje = true;
        }else if(event.getSource() == button_negativo){
            if(!flagNegativo){
                if(!primerMenos){
                    textField.insertText(0, "-");
                    primerMenos = true;
                }else {
                textField.replaceText(0, 1 , "-");
                flagNegativo = true;
                }
            } else {
                textField.replaceText(0, 1 , "+");
                flagNegativo = false;
            }
        }else if(event.getSource() == button_dividido){
            num1 = Double.parseDouble(textField.getText());
            resultado = 1 / num1;
            textField.setText(Double.toString(resultado));
            resetAll();
        }else if(event.getSource() == button_back){
            String texto = textField.getText();
            int tamaño = texto.length();
            textField.deleteText(tamaño - 1, tamaño);
        }else if(event.getSource() == button_ce){
            textField.setText("");
        }else if(event.getSource() == button_igual){
            
            switch(op){
                case 1:
                        if(flagPorcentaje){
                            resultado = num1 + proporcion;
                        } else {
                            resultado = num1 + Double.parseDouble(textField.getText());
                        }
                    textField.setText(Double.toString(resultado));
                    textField2.setText(Double.toString( resultado));
                    flagOperacion1 = false;
                    flagOperacion2 = false;
                    break;
                case 2:
                        if(flagPorcentaje){
                        resultado = num1 - proporcion;
                        } else {
                        resultado = num1 - Double.parseDouble(textField.getText());
                        }
                    textField.setText(Double.toString(resultado));
                    flagOperacion1 = false;
                    flagOperacion2 = false;
                    break;
                case 3:
                    if(flagPorcentaje){
                        resultado = num1 * proporcion;
                    } else {
                        resultado = num1 * Double.parseDouble(textField.getText());
                    }
                    textField.setText(Double.toString(resultado));
                    flagOperacion1 = false;
                    flagOperacion2 = false;
                    break;
                case 4:
                    if(flagPorcentaje){
                        resultado = num1 / proporcion ;
                    } else {
                        resultado = num1 / Double.parseDouble(textField.getText());
                    }
                    textField.setText(Double.toString(resultado));
                    break;
                case 5:
                    resultado = Math.sqrt(num1);
                    textField.setText(Double.toString(resultado));
                    break;
                case 6:
                    resultado = Math.pow(num1,2);
                    textField.setText(Double.toString(resultado));
                    break;
            }
            resetAll();
        }
        
    }
    
    public void resetAll(){
        flagPunto  = false;
        flagNegativo = false;
        primerMenos = false;
        flagPorcentaje = false;
    }
    
    public void simbolo(){
        if(op == 1){
            textField2.appendText("+");
            textField2.appendText(Double.toString(num2));
        } else if(op == 2){
            textField2.appendText("-");
            textField2.appendText(Double.toString(num2));
        } else if(op == 3){
            textField2.appendText("*");
            textField2.appendText(Double.toString(num2));
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
