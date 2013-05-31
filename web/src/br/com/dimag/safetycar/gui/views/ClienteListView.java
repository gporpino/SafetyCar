package br.com.dimag.safetycar.gui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.gui.views.NavigationView.TreeParent;
import br.com.dimag.safetycar.model.Cliente;


/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ClienteListView extends BasicView {

	public static final String ID = "SafetyCar.clientList";
	private TableViewer viewer;
	private List<Cliente> listClientes;
	
	public ClienteListView(){
		listClientes = new ArrayList<Cliente>();
		
	}

	class ViewContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			v.getInput();
		}

		public void dispose() {
			
		}

		public Object[] getElements(Object parent) {
			return listClientes.toArray(new Cliente[listClientes.size()]);
		}

	}

	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			Cliente cliente = (Cliente)obj;
			return cliente.getNomeRazaoSocial();
		}

		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent)
				imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					imageKey);
		}
	}

	/**
	 * We will set up a dummy model to initialize tree heararchy. In real code,
	 * you will connect to a real model and expose its hierarchy.
	 */
	private List<Cliente> createModel() {
		listClientes = Facade.getInstance().listCliente();
		
		return listClientes;
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER_SOLID);
		viewer.setColumnProperties(new String[]{"Nome","Endere�o"});
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(createModel());
		viewer.addDoubleClickListener(new IDoubleClickListener(){

			@Override
			public void doubleClick(DoubleClickEvent event) {
				// TODO Auto-generated method stub
				StructuredSelection sl = (StructuredSelection) event.getSelection();
				closeView();
				openView(ClienteView.ID);
				ClienteView view = (ClienteView)findView(ClienteView.ID);
				view.loadCliente((Cliente)sl.getFirstElement());
			}
			
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	
	
}
