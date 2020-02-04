package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class Controller {
    public TextField txfScource;
    public ImageView fireTarget;
    public ComboBox cmbDragDrop;

    public void txfSourceDragDetected(MouseEvent mouseEvent) {
        TextField ref = (TextField) mouseEvent.getSource();
        Dragboard db = ref.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(ref.getText());
        db.setContent(content);
    }

    public void fireTargetDragDropped(DragEvent dragEvent) {
        TextField refSource =(TextField) dragEvent.getGestureSource();
        Dragboard db = dragEvent.getDragboard();
        refSource.clear();
    }

    public void fireTargetDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void tfxTargetDragDropped(DragEvent dragEvent) {
        TextField refSource = (TextField) dragEvent.getGestureSource();
        TextField refTarget =(TextField) dragEvent.getGestureTarget();
        Dragboard db = dragEvent.getDragboard();
        refTarget.setText(db.getString());
        refSource.clear();

    }

    public void txfTargetDragOver(DragEvent dragEvent) {
        TextField refSource = (TextField) dragEvent.getGestureSource();
        TextField refTarget =(TextField) dragEvent.getGestureTarget();
        if (!refSource.equals(refTarget)){
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    public void cmbTargetDragDropped(DragEvent dragEvent) {
        TextField refSource =(TextField) dragEvent.getGestureSource();
        cmbDragDrop.getItems().add(refSource.getText());

    }

    public void cmbTargetDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }
}
