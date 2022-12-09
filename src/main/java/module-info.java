module br.com.burguerqueen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires jasypt;
    requires com.gluonhq.charm.glisten;

    opens br.com.burguerqueen to javafx.fxml;
    exports br.com.burguerqueen;

    exports br.com.burguerqueen.DB;
    opens br.com.burguerqueen.DB to javafx.fxml;
    exports br.com.burguerqueen.controllers.dados;
    opens br.com.burguerqueen.controllers.dados to javafx.fxml;
    exports br.com.burguerqueen.classes;
    opens br.com.burguerqueen.classes to javafx.fxml;

}