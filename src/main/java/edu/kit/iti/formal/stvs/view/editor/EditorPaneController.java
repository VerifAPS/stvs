package edu.kit.iti.formal.stvs.view.editor;

import edu.kit.iti.formal.stvs.model.code.Code;
import edu.kit.iti.formal.stvs.view.Controller;
import org.fxmisc.richtext.StyleSpans;

/**
 * Created by csicar on 09.01.17.
 */
public class EditorPaneController implements Controller, OnCodeModelChangeListener {
    private EditorPane view;

    public EditorPaneController(Code code) {

        // code.addChangeListener(this);
    }

    ;

    public void onCodeChange(Code code) {

    }

    ;

    private StyleSpans computeSyntaxHighlighting() {
        return null;
    }

    ;

    @Override
    public EditorPane getView() {
        return null;
    }
}
