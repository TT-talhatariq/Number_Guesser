package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Spinner<Integer> spinner;

    @FXML
    Button submit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10);
        valueFactory.setValue(1);
        spinner.setValueFactory(valueFactory);
    }
    public void check_win() throws InterruptedException {
        Random random = new Random();
        int rand = random.nextInt( 10);
        if(spinner.getValue() == rand){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Status");
            alert.setHeaderText("You Won");
            alert.setContentText("Congratulations on winning this round");
            alert.show();
            setSpinner();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Status");
            alert.setHeaderText("You Lose");
            alert.setContentText("Unfortunately, you're lost. Number is: " + rand + " Try Again");
            alert.show();
            setSpinner();
        }
    }
    public void setSpinner(){
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10);
        valueFactory.setValue(1);
        spinner.setValueFactory(valueFactory);
    }
}
