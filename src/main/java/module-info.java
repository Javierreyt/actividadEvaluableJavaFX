module org.pruebaevaluable.actividadevaluable {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.pruebaevaluable.actividadevaluable to javafx.fxml;
    exports org.pruebaevaluable.actividadevaluable;
}