module todolist.todolistinterface {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens appli to javafx.fxml;
    exports appli;
    exports appli.user;
    opens appli.user to javafx.fxml;
    exports appli.todolist;
    opens appli.todolist to javafx.fxml;
}