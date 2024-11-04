module org.pruebaevaluable.actividadevaluable {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens org.pruebaevaluable.actividadevaluable to javafx.fxml;
    exports org.pruebaevaluable.actividadevaluable;
    exports org.pruebaevaluable.actividadevaluable.controller;
    opens org.pruebaevaluable.actividadevaluable.controller to javafx.fxml;
}