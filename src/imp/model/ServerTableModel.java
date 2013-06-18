package imp.model;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;
import imp.core.*;

public class ServerTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 5517888741084755520L;
	protected static final String[] columnNames = { "Host", "Architecture", "Accessible", "Username", "Password" };
	protected final LinkedList<IPObject> list;

	public ServerTableModel() {
		list = new LinkedList<IPObject>();
	}

	public void addElement(IPObject item) {
		// Adds the element in the last position in the list
		list.add(item);
		fireTableRowsInserted(list.size() - 1, list.size() - 1);
	}

	public String getColumnName(int column) {
        return columnNames[column];
    }
	
	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return list.size();
	}

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return list.get(rowIndex).toString();
            case 1: return list.get(rowIndex).serverType.name();
            case 2: return String.valueOf(list.get(rowIndex).reachable);
            case 3: return list.get(rowIndex).username;
            case 4: return list.get(rowIndex).password;
        }
        return null;
    }

}
