package org.jhotdraw.action.edit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.event.ActionEvent;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class DeleteActionTest {

    @Test(expected = Exception.class)
    public void deleteNextCharBeepIsFalse() throws Exception {
        DeleteAction deleteActionMock = Mockito.mock(DeleteAction.class);
        ActionEvent actionEventMock = Mockito.mock(ActionEvent.class);
        doThrow(Exception.class).when(deleteActionMock).deleteNextChar(actionEventMock);
        deleteActionMock.deleteNextChar(actionEventMock);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void deleteNextCharBeepIsTrue() throws Exception {
        DeleteAction deleteActionMock = Mockito.mock(DeleteAction.class);
        ActionEvent actionEventMock = Mockito.mock(ActionEvent.class);
        doThrow(UnsupportedOperationException.class).when(deleteActionMock).deleteNextChar(actionEventMock);
        deleteActionMock.deleteNextChar(actionEventMock);
    }
}