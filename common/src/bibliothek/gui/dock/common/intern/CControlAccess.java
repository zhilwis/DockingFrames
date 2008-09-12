/*
 * Bibliothek - DockingFrames
 * Library built on Java/Swing, allows the user to "drag and drop"
 * panels containing any Swing-Component the developer likes to add.
 * 
 * Copyright (C) 2007 Benjamin Sigg
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 * Benjamin Sigg
 * benjamin_sigg@gmx.ch
 * CH - Switzerland
 */
package bibliothek.gui.dock.common.intern;

import bibliothek.gui.Dockable;
import bibliothek.gui.dock.action.DockAction;
import bibliothek.gui.dock.common.CControl;
import bibliothek.gui.dock.common.MissingCDockableStrategy;
import bibliothek.gui.dock.common.MultipleCDockableFactory;

/**
 * Gives access to the internal methods of a {@link bibliothek.gui.dock.common.CControl}
 * @author Benjamin Sigg
 */
public interface CControlAccess {
	/**
	 * Gets the control to which this object gives access.
	 * @return the owner
	 */
	public CControl getOwner();
    
	/**
	 * Makes <code>dockable</code> visible.
	 * @param dockable the element that will be made visible
	 */
	public void show( CDockable dockable );
	
	/**
	 * Makes <code>dockable</code> invisible.
	 * @param dockable the element that will be made invisible
	 */
	public void hide( CDockable dockable );
	
	/**
	 * Tells whether <code>dockable</code> is visible or not.
	 * @param dockable the dockable whose visibility-state is in question
	 * @return <code>true</code> if <code>dockable</code> is visible
	 */
	public boolean isVisible( CDockable dockable );
	
	/**
	 * Gets the id of <code>factory</code>.
	 * @param factory the factory to search
	 * @return the id or <code>null</code>
	 */
	public String getFactoryId( MultipleCDockableFactory<?,?> factory );
	
	/**
	 * Gets the manager that is responsible to change the states of the
	 * {@link Dockable}s.
	 * @return the manager
	 */
	public CStateManager getStateManager();
	
	/**
	 * Gets an action that closes <code>dockable</code> when clicked.
	 * @param dockable the element to close
	 * @return the action
	 */
	public DockAction createCloseAction( CDockable dockable );
	
	/**
	 * Gives or removes access to internal properties of an {@link CDockable}.
	 * @param dockable the element which changes its access
	 * @param access the new access, might be <code>null</code>
	 */
	public void link( CDockable dockable, CDockableAccess access );
	
	/**
	 * Grants access to the internal methods of a {@link CDockable}.
	 * @param dockable the element whose access is searched
	 * @return the access or <code>null</code>
	 */
	public CDockableAccess access( CDockable dockable );
	
	/**
	 * Calls either {@link MissingCDockableStrategy#shouldStoreSingle(String)}
	 * or {@link MissingCDockableStrategy#shouldStoreMultiple(String)} depending
	 * on how <code>key</code> looks like. 
	 * @param key the key for which a dockable might be stored
	 * @return <code>true</code> if layout information for <code>key</code> should
	 * be stored, <code>false</code> otherwise
	 */
	public boolean shouldStore( String key );
}
